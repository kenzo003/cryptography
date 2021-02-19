/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package ciphers;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.HashMap;

/**
 * @author Susi Purba
 */
public class Vernam {
    private final static String NAME = "Vernam Cipher";
    private static HashMap<String, String> encryptionArr2 = new HashMap<>();
    private final static char encryptionArr[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' '};

    public Vernam() {

        encryptionArr2.put("a", "00000");
        encryptionArr2.put("b", "00001");
        encryptionArr2.put("c", "00010");
        encryptionArr2.put("d", "00011");
        encryptionArr2.put("e", "00100");
        encryptionArr2.put("f", "00101");
        encryptionArr2.put("g", "00110");
        encryptionArr2.put("h", "00111");
        encryptionArr2.put("i", "01000");
        encryptionArr2.put("j", "01001");
        encryptionArr2.put("k", "01010");
        encryptionArr2.put("l", "01011");
        encryptionArr2.put("m", "01100");
        encryptionArr2.put("n", "01101");
        encryptionArr2.put("o", "01110");
        encryptionArr2.put("p", "01111");
        encryptionArr2.put("q", "10000");
        encryptionArr2.put("r", "10001");
        encryptionArr2.put("s", "10010");
        encryptionArr2.put("t", "10011");
        encryptionArr2.put("u", "10100");
        encryptionArr2.put("v", "10101");
        encryptionArr2.put("w", "10110");
        encryptionArr2.put("x", "10111");
        encryptionArr2.put("y", "11000");
        encryptionArr2.put("z", "11001");
        encryptionArr2.put(" ", "11010");
        encryptionArr2.put("?", "11011");
        encryptionArr2.put(".", "11100");
        encryptionArr2.put(",", "11101");
        encryptionArr2.put("/", "11110");
        encryptionArr2.put("|", "11111");
    }

    /*
     * Returns a String that represents the key of the input length.
     * Returns null if there's a problem with the input length.
     */
    public String generateKey(int length) {
        if (length <= 0) {
            return null;
        }
        String key = "";
        SecureRandom secureRandom = new SecureRandom();
        try {
            secureRandom = SecureRandom.getInstance("SHA1PRNG");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        //Builds the key.
        for (int i = 0; i < length; i++) {
            int randomValue = secureRandom.nextInt(26);
            key += encryptionArr[randomValue];
        }
        return key;
    }

    /*
     * Encrypts using the formula: key XOR with m
     * Returns cipher text or null if a error occurred.
     */
    public String encrypt(String plainText, String key) throws UnsupportedEncodingException {
        //Make sure the key and the plainText are the same length.
        if (plainText.length() != key.length()) {
            return null;
        }
        byte[] plainTextBytes = plainText.getBytes();
       byte[] keyBytes = key.getBytes();
        byte[] encryptedText = new byte[plainTextBytes.length];
        for (int i = 0; i < plainTextBytes.length; i++) {
            encryptedText[i] = (byte) (plainTextBytes[i] ^ keyBytes[i % keyBytes.length]);
//            encryptedText[i] = (byte) (keyBytes[i] ^ plainTextBytes[i]);
        }
        return new String(encryptedText);
    }


    /*
     * Decrypts using the formula: key XOR ciphertext.
     * Returns plain text or null if a error occurred.
     */
    public String decrypt(String cipherText, String key) {
        //Make sure the key and the plainText are the same length.
        if (cipherText.length() != key.length()) {
            return null;
        }
        byte[] cipherTextBytes = cipherText.getBytes();
        byte[] keyBytes = key.getBytes();
        byte[] decryptedText = new byte[cipherTextBytes.length];
        for (int i = 0; i < cipherTextBytes.length; i++) {
            decryptedText[i] = (byte) (keyBytes[i] ^ cipherTextBytes[i]);
        }
        return new String(decryptedText);
    }

//    public Integer[] getCode(String srcText) {
//        Integer[] key = new Integer[srcText.length()];
//        String key2 = "";
//        for (int i = 0; i < srcText.length(); i++) {
//            key2 = srcText.substring(i,i+1);
//            key[i] = Integer.parseInt(encryptionArr2.get(key2));
//        }
//
//        return key;
//    }

    /*
     * Returns the name of the cipher.
     */
    public String getName() {
        return NAME;
    }


}