package com.grpc.client;

import com.grpc.GreetRequest;
import com.grpc.GreetResponse;
import com.grpc.GreetServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class GreetClient {

    @GrpcClient("greet-service")
    private GreetServiceGrpc.GreetServiceBlockingStub greetStub;

    public String sendGreeting(String name) {
        GreetRequest request = GreetRequest.newBuilder()
                .setName(name)
                .build();
        GreetResponse response = greetStub.greet(request);
        return response.getMessage();
    }
}
