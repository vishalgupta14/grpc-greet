package com.grpc;

import com.grpc.service.GreetServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class GrpcServerApplication {

	public static void main(String[] args) throws IOException, InterruptedException {
		Server server = ServerBuilder.forPort(7071)
				.addService(new GreetServiceImpl())
				.build();

		System.out.println("🚀 gRPC Server started on port 7071");
		server.start();
		server.awaitTermination();
	}

}
