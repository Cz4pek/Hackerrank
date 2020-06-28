package JavaBigInteger;

import java.util.*;
import java.math.*;

public final class App {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BigInteger a = scan.nextBigInteger();
        BigInteger b = scan.nextBigInteger();
        System.out.println(a.add(b));
        System.out.println(a.multiply(b));
        scan.close();
    }
}
