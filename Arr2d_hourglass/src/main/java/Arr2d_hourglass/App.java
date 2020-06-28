package Arr2d_hourglass;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class App {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int max = 0;
        int temp = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == 0 && j == 1)
                    max = temp;
                else
                    max = Math.max(max, temp);
                temp = 0;
                for (int j2 = i; j2 < i + 3; j2++) {
                    for (int j3 = j; j3 < j + 3; j3++) {
                        if (j2 == i + 1) {
                            temp = temp + arr[j2][j3 + 1];
                            break;
                        } else
                            temp = temp + arr[j2][j3];

                    }
                }

            }
        }
        max = Math.max(max, temp);
        System.out.println(max);
        scanner.close();
    }
}
