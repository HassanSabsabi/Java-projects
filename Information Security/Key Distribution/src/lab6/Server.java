/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab6;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.SealedObject;

/**
 *
 * @author PcMax
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException, ClassNotFoundException, InvalidKeyException {
        // TODO code application logic here
        
        ServerSocket ss = new ServerSocket(8080);
        Socket s = ss.accept();
        
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(1024);
        KeyPair kp = keyGen.generateKeyPair();
        PublicKey pu = kp.getPublic();
        PrivateKey pv = kp.getPrivate();
        
        ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
        oos.writeObject(pu);
        
        ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
        SealedObject so = (SealedObject) ois.readObject();
        Object o = so.getObject(pv);
        System.out.println(o);
    }
    
}
