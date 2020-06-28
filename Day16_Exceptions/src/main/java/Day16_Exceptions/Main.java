package Day16_Exceptions;

    import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String S = in.next();
        try {
            System.out.println(Integer.parseInt(S));
        } catch (NumberFormatException e) {
            System.out.println("Bad String");
        }
        in.close();
    }
}
