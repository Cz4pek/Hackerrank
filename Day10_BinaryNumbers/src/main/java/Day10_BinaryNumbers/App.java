package Day10_BinaryNumbers;

import java.util.*;




public class App {



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int max = 0;
        int temp = 0;
        String[] arr = Integer.toBinaryString(n).split("");
        System.out.println(Integer.toBinaryString(n));
        for (int i = 0; i < arr.length; i++) {
            
            if(arr[i].equals("1")){
                temp++;
                if(temp > max) max = temp;
            }
            else temp = 0;
        }
        System.out.println(max);
        scanner.close();
    }
}
