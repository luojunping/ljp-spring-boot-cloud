package com.ljp.test.rsa;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.junit.jupiter.api.Test;

public class RSATest {

	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
			BadPaddingException, IllegalBlockSizeException {
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
		keyPairGenerator.initialize(1024, new SecureRandom());
		KeyPair keyPair = keyPairGenerator.genKeyPair();
		PublicKey publicKey = keyPair.getPublic();
		PrivateKey privateKey = keyPair.getPrivate();
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		byte[] encryptArray = cipher.doFinal("这里是中国北京！！！".getBytes());
		System.out.println(Base64.getMimeEncoder().encodeToString(encryptArray));
		System.out.println("------------------------------------------------");
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		byte[] decryptArray = cipher.doFinal(encryptArray);
		decryptArray = Base64.getMimeDecoder().decode(decryptArray);
		for (byte b : decryptArray) {
			System.out.println(b);
		}
		System.out.println(new String(Base64.getMimeDecoder().decode(decryptArray), StandardCharsets.UTF_8));
	}

	@Test
	public void testOne() throws IOException {
		// try (FileOutputStream publicFileOutputStream = new FileOutputStream(
		// new
		// File("E:\\www\\www\\ljp-spring-boot-cloud\\ljp-common\\src\\test\\resources\\public.keystore"));
		// FileOutputStream privateFileOutputStream = new FileOutputStream(new File(
		// "E:\\www\\www\\ljp-spring-boot-cloud\\ljp-common\\src\\test\\resources\\private.keystore")))
		// {
		// publicFileOutputStream.write(publicKey.getEncoded());
		// publicFileOutputStream.flush();
		// privateFileOutputStream.write(privateKey.getEncoded());
		// privateFileOutputStream.flush();
		// }
		// File publicFile = new File(
		// "E:\\www\\www\\ljp-spring-boot-cloud\\ljp-common\\src\\test\\resources\\public.keystore");
		// File privateFile = new File(
		// "E:\\www\\www\\ljp-spring-boot-cloud\\ljp-common\\src\\test\\resources\\private.keystore");
		// try (FileInputStream publicFileInputStream = new FileInputStream(publicFile);
		// FileInputStream privateFileInputStream = new FileInputStream(privateFile)) {
		// byte[] publicByte = new byte[(int) publicFile.length()];
		// publicFileInputStream.read(publicByte);
		// byte[] privateByte = new byte[(int) privateFile.length()];
		// privateFileInputStream.read(privateByte);
		// X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(publicByte);
		// x509EncodedKeySpec.getEncoded();
		// }
	}

}
