/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab4;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.KeyGenerator;

/**
 *
 * @author PcMax
 */
public class KeyGen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NoSuchAlgorithmException, FileNotFoundException, IOException {
        KeyGenerator kg = KeyGenerator.getInstance("DES");
        Key k = kg.generateKey();
        FileOutputStream fos = new FileOutputStream("k.key");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(k);
        
    }
    
}
