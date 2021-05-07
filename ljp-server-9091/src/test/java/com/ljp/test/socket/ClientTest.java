package com.ljp.test.socket;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ClientTest {

	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("127.0.0.1", 9999);
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		bufferedWriter.write(new String("hello world !!!\nhello china !!!\n".getBytes(StandardCharsets.UTF_8)));
		bufferedWriter.flush();
//		bufferedWriter.close();
	}

}
