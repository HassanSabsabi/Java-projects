/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MD;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author PcMax
 */
public class client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchAlgorithmException {
        
        Socket client = new Socket("127.0.0.1", 12345);
        ObjectInputStream ois = new ObjectInputStream(client.getInputStream());
        byte[] mm = (byte[]) ois.readObject();
        byte[] dd = (byte[]) ois.readObject();
        
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(mm);
        
        byte[] d2 = md.digest();
        
        if(MessageDigest.isEqual(d2, dd))
            System.out.println("succcess");
        else
            System.out.println("Messsage is modified");
    }
    
}
