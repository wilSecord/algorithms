import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    public static List<Integer> removeMin(List<Integer> arr) {
        int small = arr.get(0);
        for (int i : arr) {
            if (i < small) {
                small = i;
            }
        }
        arr.remove(arr.indexOf(small));
        return arr;
    }
    
    public static List<Integer> removeMax(List<Integer> arr) {
        int big = arr.get(0);
        for (int i : arr) {
            if (i > big) {
                big = i;
            }
        }
        arr.remove(arr.indexOf(big));
        return arr;
    }
    
    public static long getSum(List<Integer> arr) {
        long sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum;
    }
    
    public static long getMax(List<Integer> arr) {
        while (arr.size() > 4) {
            arr = removeMin(arr);
        }
        return getSum(arr);
    }
    
    public static long getMin(List<Integer> arr) {
        while (arr.size() > 4) {
            arr = removeMax(arr);
        }
        return getSum(arr);
    }
    
    
    public static void miniMaxSum(List<Integer> arr) {
        List<Integer> n_arr = new ArrayList<Integer>();
        for (int i : arr) {
            n_arr.add(i);
        }
        System.out.print(getMin(n_arr));
        System.out.print(" ");
        System.out.print(getMax(arr));
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}

