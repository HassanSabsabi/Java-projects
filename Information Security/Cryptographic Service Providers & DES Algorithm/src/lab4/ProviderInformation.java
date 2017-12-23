/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab4;

/**
 *
 * @author PcMax
 */
import java.security.Provider;
import java.security.Security;
import java.util.Set;import java.util.Iterator;
public class ProviderInformation {

    

   public static void main(String[] args) {    
       Provider[] providers = Security.getProviders();    
       for (int i = 0; i < providers.length; i++) {     
             Provider provider = providers[i];      
             System.out.println("Provider name: " + provider.getName());  
             System.out.println("Provider information: " + provider.getInfo());       
             System.out.println("Provider version: " + provider.getVersion());      
            Set entries = provider.entrySet();
            Iterator iterator = entries.iterator(); 
            while (iterator.hasNext()) 
                System.out.println("Property entry: " + iterator.next()); 
     }   }   }

    
