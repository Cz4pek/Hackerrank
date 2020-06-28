package com.company;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;


public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String pasword = scan.nextLine();
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md.update(pasword.getBytes());
        byte[] hash = md.digest();
        for (byte b:hash) {
            System.out.printf("%02x", b);
        }

    }
}