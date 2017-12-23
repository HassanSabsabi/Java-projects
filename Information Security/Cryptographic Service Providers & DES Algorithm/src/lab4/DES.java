/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 *
 * @author PcMax
 */
public class DES {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, FileNotFoundException, IOException, ClassNotFoundException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        
        FileInputStream fis = new FileInputStream("k.key");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Key k = (Key) ois.readObject();
        Cipher ce = Cipher.getInstance("DES");
        ce.init(Cipher.ENCRYPT_MODE, k);
        byte[] ci = ce.doFinal("Hello".getBytes());
        System.out.println(new String(ci));
        
        
        Cipher cd = Cipher.getInstance("DES");
        cd.init(Cipher.DECRYPT_MODE, k);
        byte[] plian = cd.doFinal(ci);
        System.out.println(new String(plian));
    }
    
}
