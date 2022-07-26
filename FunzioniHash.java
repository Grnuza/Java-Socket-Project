
package progetto_tps_marzo;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class FunzioniHash {
    
    
/*
Funzioni disponibili:
MD2
MD5
SHA-1
SHA-224
SHA-256
SHA-384
SHA-512  
*/   
    
public static String cripta(String input, String algoritmo)
    {
        try {
           
            MessageDigest md = MessageDigest.getInstance(algoritmo);
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(16);

            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
 
            return hashtext;
        }
        
        catch (NoSuchAlgorithmException e) {
        throw new RuntimeException(e);
        }
    }  
}