package Day13_AbstratClasses;

import java.util.*;

public class App {
   
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        String author = scanner.nextLine();
        int price = scanner.nextInt();
        scanner.close();
        Book book = new MyBook(title, author, price);
        book.display();
    }
}