/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shiftcipher;

/**
 *
 * @author PcMax
 */
public class crypto {

    char[] alpha = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    String cipherText = "";
    String plainText = "";
    int key;

    public char[] getAlpha() {
        return alpha;
    }

    public String getCipherText() {
        return cipherText;
    }

    public int getKey() {
        return key;
    }

    public String getPlainText() {
        return plainText;
    }

    public void setCipherText(String cipherText) {
        this.cipherText = cipherText;
    }

    public void setPlainText(String plainText) {
        this.plainText = plainText;
    }

    public void setKey(int key) {
        this.key = key;
    }

    int find(char a) {
        for (int i = 0; i < alpha.length; i++) {
            if (a == alpha[i]) {
                return i;
            }
        }
        return -1;
    }

    String encrypt(String plaintext, int key) {

        plaintext = plaintext.toUpperCase();
        for (int i = 0; i < plaintext.length(); i++) {
            char b = plaintext.charAt(i);
            int j = find(b);
            if (j != -1) {
                this.cipherText += alpha[(j + key) % 26];
            } else {
                this.cipherText += b;
            }
        }
        return this.cipherText;
    }

    String decrypt(String ciphertext, int key) {

        ciphertext = ciphertext.toUpperCase();
        for (int i = 0; i < ciphertext.length(); i++) {
            char b = ciphertext.charAt(i);
            int j = find(b);
            if (j != -1) {
                if (j - key >= 0) {
                    plainText += alpha[j - key];
                } else {
                    plainText += alpha[j - key + 26];
                }
            } else {
                plainText += b;
            }
        }
        return plainText;
    }

    int chi(String cipher) {

        int chi = Integer.MAX_VALUE;

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

}
