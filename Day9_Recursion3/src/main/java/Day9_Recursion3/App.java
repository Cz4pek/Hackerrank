package Day9_Recursion3;

import java.io.*;
import java.util.*;

public class App {

    
    static int factorial(int n) {
        if(n >= 1)
            return n * factorial(n-1);
        else return 1;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int result = factorial(n);

        System.out.println(result);

        scanner.close();
    }
}
