/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab6;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SealedObject;

/**
 *
 * @author PcMax
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, ClassNotFoundException {
        // TODO code application logic here
        
        Socket client = new Socket("127.0.0.1", 8080);
        ObjectInputStream ois = new ObjectInputStream(client.getInputStream());
        PublicKey pu = (PublicKey) ois.readObject();
        
        KeyGenerator kg = KeyGenerator.getInstance("DES");
        Key k = kg.generateKey();
        
        
        Cipher ce = Cipher.getInstance("RSA");
        ce.init(Cipher.ENCRYPT_MODE, pu);
        
        SealedObject so  = new SealedObject(k, ce);
        
        ObjectOutputStream oos  = new ObjectOutputStream(client.getOutputStream());
        oos.writeObject(so);
        
    }
    
}
