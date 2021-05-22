package com.ljp.test.socket;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ServerTest {

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(9999);
		for (; ; ) {
			Socket socket = serverSocket.accept();
			System.out.println("收到来自客户端（" + socket.getRemoteSocketAddress() + "）的连接请求！");
			new Thread(() -> {
				for (; ; ) {
					boolean flag = false;
					try {
						BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
//						bufferedReader.lines().forEach(message -> System.out.println("收到的客户端（" + socket.getRemoteSocketAddress() + "）消息是：" + message));
						System.out.println("收到的客户端（" + socket.getRemoteSocketAddress() + "）消息是：" + bufferedReader.readLine());
						flag = true;
					} catch (Exception e) {
						e.printStackTrace();
						try {
							socket.close();
							break;
						} catch (Exception exception) {
							exception.printStackTrace();
						}
					}
					if (flag) {
						try {
							BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));
							bufferedWriter.write("服务端已经成功收到客户端（" + socket.getRemoteSocketAddress() + "）的消息了！！！");
							bufferedWriter.newLine();
							bufferedWriter.flush();
						} catch (Exception e) {
							e.printStackTrace();
							try {
								socket.close();
								break;
							} catch (Exception exception) {
								exception.printStackTrace();
							}
						}
					}
				}
			}).start();
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
