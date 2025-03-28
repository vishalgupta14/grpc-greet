package com.grpc.service;

import com.grpc.GreetRequest;
import com.grpc.GreetResponse;
import com.grpc.GreetServiceGrpc;
import io.grpc.stub.StreamObserver;

public class GreetServiceImpl extends GreetServiceGrpc.GreetServiceImplBase {
    @Override
    public void greet(GreetRequest request, StreamObserver<GreetResponse> responseObserver) {
        String name = request.getName();
        String message = "Hello, " + name + " 👋 from gRPC server!";
        GreetResponse response = GreetResponse.newBuilder().setMessage(message).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
