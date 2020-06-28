package List;

import java.io.*;
import java.util.*;

public class App {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String[] temp = scan.nextLine().split(" ");
        List<Integer> list = new ArrayList<Integer>(n);
        for (String string : temp) {
            list.add(Integer.parseInt(string));
        }
        n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String temp2 = scan.nextLine();
            if(temp2.equals("Insert")){
                temp = scan.nextLine().split(" ");
                 list.add(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
            }
            else if(temp2.equals("Delete")) list.remove(Integer.parseInt(scan.nextLine()));
        }
        System.out.println(list.toString().replaceAll("[\\[\\],]", ""));
        scan.close();
    }
}