package JavaPrimalityTest;

import java.math.BigInteger;
import java.util.Scanner;


public final class App {
    private App() {
    }

    public static void main(String[] args) {
        BigInteger x;
        Scanner scan = new Scanner(System.in);
        x = scan.nextBigInteger();
        System.out.println((x.isProbablePrime(1))? "prime": "not prime");
        scan.close();
    }
}
