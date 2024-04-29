import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import pingpong.Person;
import pingpong.PingPongServiceGrpc;

public class PingPongClient {
    private final ManagedChannel channel;
    private final PingPongServiceGrpc.PingPongServiceStub stub;

    public PingPongClient(String host, int port) {
        channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
        stub = PingPongServiceGrpc.newStub(channel);
    }

    public void playGame() {
        StreamObserver<Person.PongResponse> responseObserver = new StreamObserver<Person.PongResponse>() {
            @Override
            public void onNext(Person.PongResponse response) {
                System.out.println("Received Pong: " + response.getMessage());
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("Error in receiving Pong: " + t);
            }

            @Override
            public void onCompleted() {
                System.out.println("Game completed");
            }
        };

        StreamObserver<Person.PingRequest> requestObserver = stub.playGame(responseObserver);
        for (int i = 0; i < 5; i++) {
            Person.PingRequest request = Person.PingRequest.newBuilder()
                    .setMessage("Ping from client")
                    .build();
            requestObserver.onNext(request);
            try {
                Thread.sleep(1000); // Simulating delay between Pings
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        requestObserver.onCompleted();
    }


    public static void main(String[] args) {
        PingPongClient client = new PingPongClient("localhost", 50051);
        client.playGame();
    }
}
