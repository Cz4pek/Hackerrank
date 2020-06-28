package app;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class App {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            boolean isPrime = true;
            int testnNumber = scan.nextInt();
            if(testnNumber == 1 || (testnNumber & 1) == 0) isPrime = false;
            if(testnNumber == 2) isPrime = true;
            for (int j = 3; j <= Math.sqrt(testnNumber); j+=2) {
                if(testnNumber%j == 0){
                    isPrime = false;
                    break;
                }
            }
            System.out.println(isPrime ? "Prime" : "Not prime");
        }

        scan.close();
    }
}



