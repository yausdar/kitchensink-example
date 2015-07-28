package util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {

	public static String md5(String secret){  
        String password = "";  
        MessageDigest md = null;  
        try {  
            md = MessageDigest.getInstance("MD5");  
        } catch (NoSuchAlgorithmException e) {  
            e.printStackTrace();  
        }  
        BigInteger hash = new BigInteger(1, md.digest(secret.getBytes()));  
        password = hash.toString(16);              
        return password;  
    }  
	
}
