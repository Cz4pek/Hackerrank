package app;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class App {
    private static Random rand = new Random();

    public static void main(String[] args) throws Exception {

        IntStream x = rand.ints(0, 10).distinct().limit(10);
        List<Integer> temp = x.boxed().collect(Collectors.toList());
        temp.indexOf(Collections.min(temp));
        temp.forEach(System.out::println);
        System.out.println(rand.ints(2, 100).limit(1).sum());

    }
} 