package com.ljp.test.security;

import com.ljp.security.uti.AESUtils;

public class AESTest {

	public static void main(String[] args) {
		String encryptStr = AESUtils.encrypt("中国加油！！！");
		System.out.println(encryptStr);
		String decryptStr = AESUtils.decrypt(encryptStr);
		System.out.println(decryptStr);
		System.out.println(AESUtils.decrypt(encryptStr, "hahahaha"));
	}

}
