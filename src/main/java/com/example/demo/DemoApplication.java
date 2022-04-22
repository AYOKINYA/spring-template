package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.zeromq.SocketType;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;
import java.util.Random;

@EnableMongoRepositories
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		ZMQ.Socket socket = null;
//		try (ZContext context = new ZContext()) {
//			socket = context.createSocket(SocketType.PUB);
//			socket.bind("tcp://*:5556");
//			Thread.sleep(1000);
//
//			while(true) {
//				Random rand = new Random(System.currentTimeMillis());
//				int rand_data = rand.nextInt(1000);
//
//				socket.send("control-robot".getBytes(ZMQ.CHARSET), ZMQ.SNDMORE);
//				socket.send(String.format("%03d", rand_data));
////                socket.send("TEST-MSG".getBytes(ZMQ.CHARSET));
//
//				System.out.println("SEND ::: " + rand_data);
//				Thread.sleep(1000);
//			}
//		} catch (Exception e) {
//			throw new RuntimeException(e);
//		} finally {
//			socket.close();
//		}

	}

}
