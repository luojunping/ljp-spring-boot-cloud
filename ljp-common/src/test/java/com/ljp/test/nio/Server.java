package com.ljp.test.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

public class Server {

	public static void main(String[] args) throws IOException {
		Selector selector = Selector.open();
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		serverSocketChannel.configureBlocking(false);
		serverSocketChannel.bind(new InetSocketAddress(8888));
//		serverSocketChannel.register(selector, SelectionKey.OP_CONNECT);
		serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
		for (; ; ) {
			int timeWait = selector.select(3000);
			if (timeWait == 0) {
				continue;
			}
			Set<SelectionKey> selectionKeySet = selector.selectedKeys();
			Iterator<SelectionKey> selectionKeyIterator = selectionKeySet.iterator();
			while (selectionKeyIterator.hasNext()) {
				SelectionKey selectionKey = selectionKeyIterator.next();
				if (selectionKey.isConnectable()) {
					System.out.println("连接。。。");
//					SocketChannel socketChannel = serverSocketChannel.accept();
//					socketChannel.configureBlocking(false);
//					socketChannel.register(selector, SelectionKey.OP_ACCEPT);
				}
				if (selectionKey.isAcceptable()) {
					System.out.println("访问。。。");
					SocketChannel socketChannel = serverSocketChannel.accept();
					socketChannel.configureBlocking(false);
					socketChannel.register(selector, SelectionKey.OP_READ);
				}
				if (selectionKey.isReadable()) {
					System.out.println("读取。。。");
					SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
					ByteBuffer byteBuffer = ByteBuffer.allocate(8192);
					socketChannel.read(byteBuffer);
					System.out.println(new String(byteBuffer.array(), StandardCharsets.UTF_8));
					socketChannel.configureBlocking(false);
					socketChannel.register(selector, SelectionKey.OP_WRITE);
				}
				if (selectionKey.isWritable()) {
					System.out.println("输出。。。");
					SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
					ByteBuffer byteBuffer = ByteBuffer.allocate(8192);
					socketChannel.write(ByteBuffer.wrap("收到。。。".getBytes(StandardCharsets.UTF_8)));
				}
				selectionKeyIterator.remove();
			}
		}
	}

}
