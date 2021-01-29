package com.ljp.test.crypto;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class AESTest {

	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
			BadPaddingException, IllegalBlockSizeException, DecoderException {
		KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
		keyGenerator.init(128, new SecureRandom("AES".getBytes(StandardCharsets.UTF_8)));
		SecretKey secretKey = keyGenerator.generateKey();
		byte[] encoded = secretKey.getEncoded();
		SecretKeySpec secretKeySpec = new SecretKeySpec(encoded, "AES");
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
		byte[] bytes = cipher.doFinal("中国加油！！！世界加油！！！".getBytes(StandardCharsets.UTF_8));
		String hexString = Hex.encodeHexString(bytes);
		System.out.println("hexString = " + hexString);
		cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
		byte[] result = cipher.doFinal(Hex.decodeHex(hexString));
		String ss = new String(result, StandardCharsets.UTF_8);
		System.out.println("ss = " + ss);
	}

}
