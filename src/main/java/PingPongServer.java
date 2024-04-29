import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import pingpong.Person;
import pingpong.PingPongServiceGrpc;

import java.io.IOException;

public class PingPongServer {
    private Server server;

    private void start() throws IOException {
        int port = 50051;
        server = ServerBuilder.forPort(port)
                .addService(new PingPongServiceImpl())
                .build()
                .start();
        System.out.println("Server started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.err.println("*** shutting down gRPC server since JVM is shutting down");
            PingPongServer.this.stop();
            System.err.println("*** server shut down");
        }));
    }

    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        final PingPongServer server = new PingPongServer();
        server.start();
        server.blockUntilShutdown();
    }

    private static class PingPongServiceImpl extends PingPongServiceGrpc.PingPongServiceImplBase {
        @Override
        public StreamObserver<Person.PingRequest> playGame(StreamObserver<Person.PongResponse> responseObserver) {
            return new StreamObserver<Person.PingRequest>() {

                @Override
                public void onNext(Person.PingRequest request ) {
                    System.out.println("Received Ping: " + request.getMessage());
                    Person.PongResponse response = Person.PongResponse.newBuilder()
                            .setMessage("Pong from server")
                            .build();
                    responseObserver.onNext(response);
                }

                @Override
                public void onError(Throwable t) {
                    System.err.println("Error in receiving Ping: " + t);
                }

                @Override
                public void onCompleted() {
                    responseObserver.onCompleted();
                }
            };
        }
    }
}
