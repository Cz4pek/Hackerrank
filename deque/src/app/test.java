package app;

import java.util.*;
public class test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>(3);
        HashSet<Integer> count = new HashSet<>();
        int n = in.nextInt();
        int m = in.nextInt();
        int max = 0;
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.offer(num);
            count.add(num);
           // System.out.println(deque + "     " + count);
            if(deque.size() == m){
                if(max < count.size()) max = count.size();
                int temp = deque.removeFirst();
                if(!deque.contains(temp))count.remove(temp);
            }  
        }
        System.out.println(max);  
        in.close();
    }
}