package com.ljp.test.buffer;

import org.junit.jupiter.api.Test;

public class BufferTest {

	@Test
	public void testOne() {
//		ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
//		byteBuffer.put("中华人民共和国".getBytes());
//		byteBuffer.flip();
//		// System.out.println(new String(byteBuffer.array(), 0, byteBuffer.limit(), StandardCharsets.UTF_8));
//		for (int i = 0; i < 7; i++) {
//			System.out.println(byteBuffer.getChar());
//		}
		int a = (1 << 31) - 1;
		int b = 0x7fffffff;
		System.out.println(a);
		System.out.println(b);
		System.out.println(1 << 30);
		System.out.println(0x80000000);
	}

}
