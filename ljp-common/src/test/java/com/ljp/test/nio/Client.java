package com.ljp.test.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws IOException {
		SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8888));
		socketChannel.configureBlocking(false);
		for (; ; ) {
			Scanner scanner = new Scanner(System.in);
			String ss = scanner.nextLine();
			socketChannel.write(ByteBuffer.wrap(ss.getBytes(StandardCharsets.UTF_8)));
			ByteBuffer byteBuffer = ByteBuffer.allocate(8192);
			socketChannel.read(byteBuffer);
			if (byteBuffer.limit() > 2) {
				System.out.println(new String(byteBuffer.array(), StandardCharsets.UTF_8));
			}
		}
	}

}
