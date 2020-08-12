package encrypt;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

public class EncTestMain {

	public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException, GeneralSecurityException {
	
		String str="Hello~Java";
		
		//단방향 암호화 객체 생성 : SHA256
		Sha256 sha256 = new Sha256();
		
		String encStr = sha256.encrypt(str);
		
		System.out.println("평문");
		System.out.println("SHA-256암호화 : "+encStr);
		
		System.out.println(sha256.encrypt("1"));
		System.out.println(sha256.encrypt("1"));
		System.out.println(sha256.encrypt("123456789ABCDEF"));
		System.out.println(sha256.encrypt("1").length());
		
		
		//양방향 암호화 객체 : AES 
		//key는 16자리 필요함
		String key1="0000000000000001";
		String key2="0000000000000002";
		System.out.println("------------------------------------------------------------");
		
		
		AES256Util aseAes256Util = new AES256Util(key1);
		AES256Util aseAes256Util2 = new AES256Util(key2);
		
		String encStr1= aseAes256Util.encrypt(encStr);
		String encStr2= aseAes256Util.encrypt(encStr);
		
		//암호화
		System.out.println("평문 : "+str);
		System.out.println("AES를 이용한 암호화 : "+encStr1); //encrypt 평문  출력
		System.out.println("AES를 이용한 암호화 : "+encStr2); //encrypt 평문  출력
		
		System.out.println("--------------------------------------------------------------------");
		
		String plainStr1=aseAes256Util.decrypt(encStr1);
		String plainStr2=aseAes256Util.decrypt(encStr2); //잘못된 결과 출력 됨
		
		System.out.println("AES를 이용한 복호화 : "+plainStr1);
		System.out.println("AES를 이용한 복호화 : "+plainStr2);
		
		
		
	}

}
