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
     * Complete the 'runningTime' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
     
    public static List<Integer> swap(List<Integer> arr, int a) {
        List<Integer> ret = arr;
        int hold;
        hold = arr.get(a);
        ret.set(a, arr.get(a + 1));
        ret.set(a + 1, hold);
        return ret;
    }

    public static int runningTime(List<Integer> arr) {
        int n = 0;
        for (int j = 0; j < arr.size(); j++) {
            for (int i = 0; i < arr.size() - 1; i++) {
                if (arr.get(i) > arr.get(i + 1) && i != arr.size()) {
                    arr = swap(arr, i);
                    n++;
                }
            }
        }
        return n;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.runningTime(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

