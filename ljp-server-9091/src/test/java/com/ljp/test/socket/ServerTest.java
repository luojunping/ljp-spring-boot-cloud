package com.ljp.test.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Set;

public class ServerTest {

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(8888);
		Selector selector = Selector.open();
		Set<SelectionKey> selectionKeys = selector.selectedKeys();

	}

}
