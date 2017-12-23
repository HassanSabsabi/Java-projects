/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MAC;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Mac;

/**
 *
 * @author PcMax
 */
public class client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchAlgorithmException, InvalidKeyException {
        // TODO code application logic here
        
        Socket client = new Socket("127.0.0.1", 8080);
        
        FileInputStream fis = new FileInputStream("../lab4/k.key");
        ObjectInputStream ois1 = new ObjectInputStream(fis);
        Key key = (Key) ois1.readObject();
        
        ObjectInputStream ois = new ObjectInputStream(client.getInputStream());
        byte[] message = (byte[]) ois.readObject();
        
        Mac mac = Mac.getInstance("HmacMD5");
        mac.init(key);
        byte[] mm = mac.doFinal(message);
        
        if(Arrays.equals(mm, mm)){
            System.out.println("success");
        }
    }
    
}
