package com.ljp.test.test;

import java.security.MessageDigest;

/**
 * Created by longchen13 on 2019/5/5.
 */
public class MD5Utils {


	private static final String[] hexDigIts = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

	/**
	 * MD5加密
	 *
	 * @param origin      字符
	 * @param charsetname 编码
	 * @return
	 */
	public static String MD5Encode(String origin, String charsetname) {
		String resultString = null;
		try {
			resultString = origin;
			MessageDigest md = MessageDigest.getInstance("MD5");
			if (null == charsetname || "".equals(charsetname)) {
				resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
			} else {
				resultString = byteArrayToHexString(md.digest(resultString.getBytes(charsetname)));
			}
		} catch (Exception e) {
		}
		return resultString;
	}


	public static String byteArrayToHexString(byte[] b) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			resultSb.append(byteToHexString(b[i]));
		}
		return resultSb.toString();
	}

	public static String byteToHexString(byte b) {
		int n = b;
		if (n < 0) {
			n += 256;
		}
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigIts[d1] + hexDigIts[d2];
	}

	/**
	 * MD5 32位小写加密
	 *
	 * @param encryptStr
	 * @return
	 */
	public static String encrypt32(String encryptStr) {
		MessageDigest md5;
		try {
			md5 = MessageDigest.getInstance("MD5");
			byte[] md5Bytes = md5.digest(encryptStr.getBytes());
			StringBuffer hexValue = new StringBuffer();
			for (int i = 0; i < md5Bytes.length; i++) {
				int val = ((int) md5Bytes[i]) & 0xff;
				if (val < 16) {
					hexValue.append("0");
				}
				hexValue.append(Integer.toHexString(val));
			}
			encryptStr = hexValue.toString();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return encryptStr;
	}


	public static void main(String[] args) {
		String t1 = "changwei@2525";
		String t2 = "8e8f30d0-2742-4e8b-8a11-1725a445112a4rrxFTwaPSuMZVpicY8Uflytek_nnezwAaI2VOqO8lOrs2Zc76wMG5ztGrQUmE1fucYQNVz9LhJfSWV";
		System.out.println(MD5Utils.MD5Encode(t1, "utf-8"));

		System.out.println(MD5Utils.encrypt32(t2));
	}

}
