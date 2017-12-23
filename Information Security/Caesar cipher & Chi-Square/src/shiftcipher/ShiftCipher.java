/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shiftcipher;

import java.util.Scanner;

/**
 *
 * @author PcMax
 */
public class ShiftCipher {

    char[] alpha = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    String encrypt(String plaintext, int key) {
        String ciphertext = "";

        plaintext = plaintext.toUpperCase();
        for (int i = 0; i < plaintext.length(); i++) {
            char b = plaintext.charAt(i);
            int j = find(b);
            if (j != -1) {
                ciphertext += alpha[(j + key) % 26];
            } else {
                ciphertext += b;
            }
        }
        return ciphertext;
    }

    String decrypt(String ciphertext, int key) {
        String plaintext = "";
        ciphertext = ciphertext.toUpperCase();
        for (int i = 0; i < ciphertext.length(); i++) {
            char b = ciphertext.charAt(i);
            int j = find(b);
            if (j != -1) {
                if (j - key >= 0) {
                    plaintext += alpha[j - key];
                } else {
                    plaintext += alpha[j - key + 26];
                }
            } else {
                plaintext += b;
            }
        }
        return plaintext;
    }

    int find(char a) {
        for (int i = 0; i < alpha.length; i++) {
            if (a == alpha[i]) {
                return i;
            }
        }
        return -1;
    }

    /*String cryptanlysis_brut(String cipher) {
     String plain = "";
     for (int k = 1; k < 26; k++) {
     plain = decrypt(cipher, k);
     }
     return plain;
     }
     */
    int chi(String cipher) {

        int chi = Integer.MAX_VALUE;
        int key = 0;
        int[] freq = {73, 9, 30, 44, 130, 28, 16, 35, 74, 2, 3, 35, 25, 78, 74, 27, 3, 77, 63, 93, 27, 13, 16, 5, 19, 1};
        int[] freq_m = new int[26];

        for (int i = 0; i < 26; i++) {
            freq_m[i] = 0;
        }

        for (int j = 0; j < cipher.length(); j++) {
            char c = cipher.charAt(j);
            int d = find(c);
            if (d != -1) {
                freq_m[d] += 1;
            }
        }
        //for(int i=0;i<26;i++)
        //  System.out.println(freq_m[i]);
        for (int s = 1; s < 26; s++) {
            int t = 0;
            for (int i = 0; i < 26; i++) {
                t += Math.pow(freq_m[(i + s) % 26] - freq[i], 2) / freq[i];
            }
            if (t < chi) {
                chi = t;
                key = s;
            }
        }
        return key;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        ShiftCipher s = new ShiftCipher();
        /*   String plaintext = "";
        String ciohertext = "";
        int key;
        crypto s = new crypto();

        System.out.println("What you want to do??\n"
                + "1 for Encryption\n"
                + "2 for Decryption\n"
                + "3 for Chi_Squire Cryptanalysis\n");

        Scanner scan = new Scanner(System.in);
        int choose = scan.nextInt();
        switch (choose) {
            case 1: {
                System.out.println("Enter Plaintext:");
                plaintext = scan.next();
                System.out.println("Enter the key");
                key = scan.nextInt();

                System.out.println(s.encrypt(plaintext, key));
                break;
            }
            case 2: {
                System.out.println("Enter Ciphertext:");
                ciohertext = scan.next();
                System.out.println("Enter the key");
                key = scan.nextInt();

                System.out.println(s.decrypt(ciohertext, key));
                break;
            }

            case 3: {
                System.out.println("Enter Ciphertext:");
                ciohertext = scan.next();
                key = s.chi(ciohertext);
                System.out.println("The key is " + key);
                System.out.println("the Plaintext \n"
                        + s.decrypt(ciohertext, key));
                break;
            }

        }*/

        System.out.println(s.chi("FDHVDU FRGH LV D VKLIW FLSKHU FRGH. WKH VWRUB RI WKH FRGH EHJLQV: ZKHQ MXOLXV FDHVDU"
                + " VHQW PHVVDJHV WR KLV WUXVWHG DFTXDLQWDQFHV, KH"
                + " GLGQ'W WUXVW WKH PHVVHQJHUV. VR KH UHSODFHG HYHUB D "
                + "  EB D G, HYHUB E EB D H, DQG VR RQ WKURXJK WKH DOSKDEHW. RQOB VRPHRQH ZKR NQHZ WKH "
                + "``VKLIW EB 3'' UXOH FRXOG GHFLSKHU KLV PHVVDJHV "));
    }

}
