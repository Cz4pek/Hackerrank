package JavaArraylist;

import java.io.*;
import java.util.*;

import jdk.jfr.Unsigned;

public class App {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        ArrayList<ArrayList<Integer>> Arr2d = new ArrayList<ArrayList<Integer>>(n);
        for (int i = 0; i < n; i++) {
            Arr2d.add(new ArrayList<Integer>());
            int x = scan.nextInt();
            for (int j = 0; j < x; j++) {
                Arr2d.get(i).add(j, scan.nextInt());
            }  
        }
        n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            int index1 = scan.nextInt()-1;
            int index2 = scan.nextInt()-1;
            if(index1 < Arr2d.size() && index2 < Arr2d.get(index1).size())System.out.println(Arr2d.get(index1).get(index2));
            else System.out.println("ERROR!");
        }
        scan.close();
    }
}