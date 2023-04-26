package util;

import java.security.MessageDigest;

import org.apache.tomcat.util.codec.binary.Base64;


public class Encrypt {
	public   String encryptPassword(String str) {
		String result = null;
		try {
			byte[] databyte = str.getBytes("UTF-8");
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			result = Base64.encodeBase64String(md.digest(databyte));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	

}
