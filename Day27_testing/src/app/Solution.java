package app;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    public static int minimum_index(int[] seq) {
        if (seq.length == 0) {
            throw new IllegalArgumentException("Cannot get the minimum value index from an empty sequence");
        }
        int min_idx = 0;
        for (int i = 1; i < seq.length; ++i) {
            if (seq[i] < seq[min_idx]) {
                min_idx = i;
            }
        }
        return min_idx;
    }

    static class TestDataEmptyArray {
        public static int[] get_array() {
            return new int[0];
        }
    }

    private static Random rand = new Random();

    static List<Integer> gerRandListOfInts(){
        int size = rand.nextInt(101);
        while (size < 2) size = rand.nextInt(101);
        HashSet<Integer> temp = new HashSet<>(size);
        while(temp.size() != size){
            temp.add(rand.nextInt(100));
        }
        return new ArrayList<>(temp);
    }
    static class TestDataUniqueValues {
        
        private static int expectedMinIndex;
        public static int[] get_array() {
            List<Integer> randomInts = gerRandListOfInts();
            expectedMinIndex = randomInts.indexOf(Collections.min(randomInts));
            int n = randomInts.size();
            int[] returnArr = new int[n];
            for (int i = 0; i < n; i++) {
                returnArr[i] = randomInts.get(i);
            }
            return returnArr;
        }

        public static int get_expected_result() {
            return expectedMinIndex;
        }
    }

    static class TestDataExactlyTwoDifferentMinimums {
        private static int expectedMinIndex;
        public static int[] get_array() {
            List<Integer> randomInts = gerRandListOfInts();
            expectedMinIndex = randomInts.indexOf(Collections.min(randomInts));
            int n = randomInts.size();
            int minValue = randomInts.get(expectedMinIndex);
            if(randomInts.get(n-1) == minValue){
                int index = rand.nextInt(n-2);
                int temp = randomInts.get(index);
                Collections.replaceAll(randomInts, randomInts.get(index), minValue);
                Collections.replaceAll(randomInts, minValue, temp);

            }
            int secondMin = rand.nextInt(n);
            while(secondMin <= expectedMinIndex) secondMin = n+1;
            Collections.replaceAll(randomInts, randomInts.get(secondMin), minValue);
            int[] returnArr = new int[n];
            for (int i = 0; i < n; i++) {
                returnArr[i] = randomInts.get(i);
            }
            return returnArr;
        }

        public static int get_expected_result() {
            return expectedMinIndex;
        }
    }

    
	public static void TestWithEmptyArray() {
        try {
            int[] seq = TestDataEmptyArray.get_array();
            int result = minimum_index(seq);
        } catch (IllegalArgumentException e) {
            return;
        }
        throw new AssertionError("Exception wasn't thrown as expected");
    }

    public static void TestWithUniqueValues() {
        int[] seq = TestDataUniqueValues.get_array();
        if (seq.length < 2) {
            throw new AssertionError("less than 2 elements in the array");
        }

        Integer[] tmp = new Integer[seq.length];
        for (int i = 0; i < seq.length; ++i) {
            tmp[i] = Integer.valueOf(seq[i]);
        }
        if (!((new LinkedHashSet<Integer>(Arrays.asList(tmp))).size() == seq.length)) {
            throw new AssertionError("not all values are unique");
        }

        int expected_result = TestDataUniqueValues.get_expected_result();
        int result = minimum_index(seq);
        if (result != expected_result) {
            throw new AssertionError("result is different than the expected result");
        }
    }

    public static void TestWithExactlyTwoDifferentMinimums() {
        int[] seq = TestDataExactlyTwoDifferentMinimums.get_array();
        if (seq.length < 2) {
            throw new AssertionError("less than 2 elements in the array");
        }

        int[] tmp = seq.clone();
        Arrays.sort(tmp);
        if (!(tmp[0] == tmp[1] && (tmp.length == 2 || tmp[1] < tmp[2]))) {
            throw new AssertionError("there are not exactly two minimums in the array");
        }

        int expected_result = TestDataExactlyTwoDifferentMinimums.get_expected_result();
        int result = minimum_index(seq);
        if (result != expected_result) {
            throw new AssertionError("result is different than the expected result");
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            TestWithEmptyArray();
            TestWithUniqueValues();
            TestWithExactlyTwoDifferentMinimums();
            System.out.println("OK");
        }

    }
}
