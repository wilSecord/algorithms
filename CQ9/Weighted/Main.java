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
     * Complete the 'weightedUniformStrings' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER_ARRAY queries
     */

    

    // This isn't finished, I ran out of time
    


    public static int[] slice(int[] arr, int s, int e) {
        
    }
    
    public static int sum(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum;
    }
     
    public static String subsetSum(int[] arr, int t, int[] l) {
        int s = sum(l);
        
        if (s == t) {
            return "Yes";
        } 
        if (s >= t) {
            return "No";
        }
        
        for (int i = 0; i < arr.length; i++) {
            int n = arr[i];
            int e = arr.length - 1;
            int[] following = slice(arr, i + 1, e);
            int[] nl = new int[l.length + 1];
            for (int j = 0; j < l.length; j++) {
                nl[j] = l[j];
            }
            nl[l.length] = n;
            subsetSum(following, t, l);
        }
    }

    public static List<String> weightedUniformStrings(String s, List<Integer> queries) {
        char[] S = s.toCharArray();
        // System.out.println((int) c - 96);
        for (char c : S) {
            
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> queries = IntStream.range(0, queriesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());


        bufferedWriter.write(
            result.stream()
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

