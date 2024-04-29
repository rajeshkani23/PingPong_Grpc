package pingpong;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.60.0)",
    comments = "Source: sec02/person.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class PingPongServiceGrpc {

  private PingPongServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "pingpong.PingPongService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<pingpong.Person.PingRequest,
      pingpong.Person.PongResponse> getPlayGameMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "playGame",
      requestType = pingpong.Person.PingRequest.class,
      responseType = pingpong.Person.PongResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<pingpong.Person.PingRequest,
      pingpong.Person.PongResponse> getPlayGameMethod() {
    io.grpc.MethodDescriptor<pingpong.Person.PingRequest, pingpong.Person.PongResponse> getPlayGameMethod;
    if ((getPlayGameMethod = PingPongServiceGrpc.getPlayGameMethod) == null) {
      synchronized (PingPongServiceGrpc.class) {
        if ((getPlayGameMethod = PingPongServiceGrpc.getPlayGameMethod) == null) {
          PingPongServiceGrpc.getPlayGameMethod = getPlayGameMethod =
              io.grpc.MethodDescriptor.<pingpong.Person.PingRequest, pingpong.Person.PongResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "playGame"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pingpong.Person.PingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pingpong.Person.PongResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PingPongServiceMethodDescriptorSupplier("playGame"))
              .build();
        }
      }
    }
    return getPlayGameMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PingPongServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PingPongServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PingPongServiceStub>() {
        @java.lang.Override
        public PingPongServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PingPongServiceStub(channel, callOptions);
        }
      };
    return PingPongServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PingPongServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PingPongServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PingPongServiceBlockingStub>() {
        @java.lang.Override
        public PingPongServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PingPongServiceBlockingStub(channel, callOptions);
        }
      };
    return PingPongServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PingPongServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PingPongServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PingPongServiceFutureStub>() {
        @java.lang.Override
        public PingPongServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PingPongServiceFutureStub(channel, callOptions);
        }
      };
    return PingPongServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default io.grpc.stub.StreamObserver<pingpong.Person.PingRequest> playGame(
        io.grpc.stub.StreamObserver<pingpong.Person.PongResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getPlayGameMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service PingPongService.
   */
  public static abstract class PingPongServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return PingPongServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service PingPongService.
   */
  public static final class PingPongServiceStub
      extends io.grpc.stub.AbstractAsyncStub<PingPongServiceStub> {
    private PingPongServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PingPongServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PingPongServiceStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<pingpong.Person.PingRequest> playGame(
        io.grpc.stub.StreamObserver<pingpong.Person.PongResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getPlayGameMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service PingPongService.
   */
  public static final class PingPongServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<PingPongServiceBlockingStub> {
    private PingPongServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PingPongServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PingPongServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service PingPongService.
   */
  public static final class PingPongServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<PingPongServiceFutureStub> {
    private PingPongServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PingPongServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PingPongServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_PLAY_GAME = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PLAY_GAME:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.playGame(
              (io.grpc.stub.StreamObserver<pingpong.Person.PongResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getPlayGameMethod(),
          io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
            new MethodHandlers<
              pingpong.Person.PingRequest,
              pingpong.Person.PongResponse>(
                service, METHODID_PLAY_GAME)))
        .build();
  }

  private static abstract class PingPongServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PingPongServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return pingpong.Person.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PingPongService");
    }
  }

  private static final class PingPongServiceFileDescriptorSupplier
      extends PingPongServiceBaseDescriptorSupplier {
    PingPongServiceFileDescriptorSupplier() {}
  }

  private static final class PingPongServiceMethodDescriptorSupplier
      extends PingPongServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    PingPongServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (PingPongServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PingPongServiceFileDescriptorSupplier())
              .addMethod(getPlayGameMethod())
              .build();
        }
      }
    }
    return result;
  }
}
