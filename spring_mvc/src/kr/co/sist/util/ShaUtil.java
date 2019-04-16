package kr.co.sist.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.tomcat.util.codec.binary.Base64;

public class ShaUtil {
	private static Base64 base64=new Base64();
	
	public static String shaEncoding(String plaintext) {
		String ciphertext="";
		if(plaintext!=null||!"".equals(plaintext)) {
			
			//1. 알고리즘을 사용할 수 잇는 객체 얻기
			try {
				MessageDigest md=MessageDigest.getInstance("SHA-1");
				//2. 평문(plaintext)를 암호문(ciphertext)변환
				md.update(plaintext.getBytes());
				//3. 변환된 암호문(ciphertext)얻기 
				ciphertext=new String(base64.encode(md.digest()));
				
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}//end catch
			
		}//end if
		
		
		return ciphertext;
	}//shaEncoding
	/*public static void main(String[] args) {
	System.out.println(shaEncoding("q1w2e3r4"));
	}//main
*/
}//class
