/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MAC;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;

/**
 *
 * @author PcMax
 */
public class server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException, InvalidKeyException, ClassNotFoundException {
        
        String message = "Information Securty";
        ServerSocket ss = new ServerSocket(8080);
        Socket s = ss.accept();
        
        FileInputStream fis = new FileInputStream("../lab4/k.key");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Key key = (Key) ois.readObject();
        
        Mac mac = Mac.getInstance("HMACMD5");
        mac.init(key);
        byte[] mm = mac.doFinal(message.getBytes());
        
        ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
        oos.writeObject(mm);
        
        
    }
    
}
