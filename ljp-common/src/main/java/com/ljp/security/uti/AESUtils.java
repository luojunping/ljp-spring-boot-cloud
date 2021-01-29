package com.ljp.security.uti;

import org.apache.commons.codec.binary.Hex;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;

public final class AESUtils {

	private static final String AES_ALGORITHM = "AES";
	private static final String SECRET_KEY = "secretKey";

	private AESUtils() throws IllegalAccessException {
		throw new IllegalAccessException("AESUtils can not be create...");
	}

	public static String encrypt(String content) {
		return encrypt(content, SECRET_KEY);
	}

	public static String encrypt(String content, String secretKey) {
		String result = null;
		try {
			KeyGenerator keyGenerator = KeyGenerator.getInstance(AES_ALGORITHM);
			keyGenerator.init(256, new SecureRandom(secretKey.getBytes(StandardCharsets.UTF_8)));
			SecretKeySpec secretKeySpec = new SecretKeySpec(keyGenerator.generateKey().getEncoded(), AES_ALGORITHM);
			Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
			cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
			byte[] bytes = cipher.doFinal(content.getBytes(StandardCharsets.UTF_8));
			result = Hex.encodeHexString(bytes, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static String decrypt(String content) {
		return decrypt(content, SECRET_KEY);
	}

	public static String decrypt(String content, String secretKey) {
		String result = null;
		try {
			KeyGenerator keyGenerator = KeyGenerator.getInstance(AES_ALGORITHM);
			keyGenerator.init(256, new SecureRandom(secretKey.getBytes(StandardCharsets.UTF_8)));
			SecretKeySpec secretKeySpec = new SecretKeySpec(keyGenerator.generateKey().getEncoded(), AES_ALGORITHM);
			Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
			cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
			byte[] bytes = cipher.doFinal(Hex.decodeHex(content));
			result = new String(bytes, StandardCharsets.UTF_8);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
