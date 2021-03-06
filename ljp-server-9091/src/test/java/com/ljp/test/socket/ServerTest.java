package com.ljp.test.socket;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SuppressWarnings("ALL")
public class ServerTest {

	public static void main(String[] args) throws IOException {
		ExecutorService executorService = Executors.newFixedThreadPool(8);
		ServerSocket serverSocket = new ServerSocket(9999);
		for (; ; ) {
			Socket socket = serverSocket.accept();
			System.out.println("收到来自客户端（" + socket.getRemoteSocketAddress() + "）的连接请求！");
			executorService.execute(()->{
				try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8)); BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));) {
					String customerMessage = bufferedReader.readLine();
					while(StringUtils.isNotBlank(customerMessage)){
						System.out.println("收到的客户端（" + socket.getRemoteSocketAddress() + "）消息是：" + customerMessage);
						// bufferedWriter.write("服务端已经成功收到客户端（" + socket.getRemoteSocketAddress() + "）的消息了！！！");
						bufferedWriter.write("echo: " + socket.getRemoteSocketAddress());
						bufferedWriter.newLine();
						bufferedWriter.flush();
						customerMessage = bufferedReader.readLine();
						System.out.println("-------------------------------------------");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
		}
	}

	@Test
	public void testOne() throws IOException, InterruptedException {
		ServerSocket serverSocket = new ServerSocket(9999);
		Socket socket = serverSocket.accept();
		System.out.println("收到来自客户端（" + socket.getRemoteSocketAddress() + "）的连接请求！");
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
		bufferedOutputStream.write("hello world !!!".getBytes(StandardCharsets.UTF_8));
		bufferedOutputStream.write("\n".getBytes(StandardCharsets.UTF_8));
		bufferedOutputStream.flush();
		bufferedOutputStream.write("hello china !!!".getBytes(StandardCharsets.UTF_8));
		bufferedOutputStream.write("\n".getBytes(StandardCharsets.UTF_8));
		bufferedOutputStream.flush();
		bufferedOutputStream.close();
		socket.close();
		serverSocket.close();
	}

}
