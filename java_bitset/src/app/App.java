package app;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
enum operation{
    AND,
    OR,
    XOR,
    FLIP,
    SET;
}
public class App {
    public void performOperations(operation op, int set1, int set2OrIndex, List<BitSet> l){
        switch (op) {
            case AND:
                l.get(set1).and(l.get(set2OrIndex-1));
                break;
            case OR:
                l.get(set1).or(l.get(set2OrIndex-1));
                break;
            case XOR:
                l.get(set1).xor(l.get(set2OrIndex-1));
                break;
            case FLIP:
                l.get(set1).flip(set2OrIndex);
                break;
            case SET:
                l.get(set1).set(set2OrIndex);
                break;
            default:
                break;
        }
        System.out.println(l.get(0).cardinality() + " " + l.get(1).cardinality());
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        BitSet set1 = new BitSet(n);
        BitSet set2 = new BitSet(n);
        List<BitSet> l = new ArrayList<>();
        Collections.addAll(l, set1, set2);
        App a = new App();
        for (int i = 0; i < m; i++) {
            a.performOperations(operation.valueOf(scan.next()), scan.nextInt()-1, scan.nextInt(), l);
        }

    }
}