package com.ljp.test.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ServerTest {

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(9999);
		Socket socket = serverSocket.accept();
		while (socket != null) {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
			try {
				bufferedReader.lines().forEach(message -> System.out.println("message = " + message));
				// socket.shutdownInput();
				bufferedReader.close();
				socket.close();
				socket = serverSocket.accept();
			} catch (Exception e) {
				e.printStackTrace();
				// socket.shutdownInput();
				bufferedReader.close();
				socket.close();
				socket = serverSocket.accept();
			}
		}
	}

}
