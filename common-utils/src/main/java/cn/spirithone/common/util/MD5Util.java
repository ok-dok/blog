package cn.spirithone.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
	/**
	 * 给定一个字符串，使用md5加密，返回32位加密后的16进制字符串
	 * 
	 * @param srcStr
	 *            要加密的字符串.
	 * @return 加密后的16进制字符串.
	 */
	public static String getMD5(String srcStr) {
		StringBuilder sb = new StringBuilder();
		MessageDigest md5;
		try {
			md5 = MessageDigest.getInstance("MD5");
			md5.update(srcStr.getBytes());
			for (byte b : md5.digest()) {
				sb.append(String.format("%02X", b)); // 10进制转16进制，X
														// 表示以十六进制形式输出，02
														// 表示不足两位前面补0输出
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
}
