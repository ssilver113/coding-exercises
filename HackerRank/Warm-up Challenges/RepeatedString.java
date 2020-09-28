import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class RepeatedString {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        int aCountInString = s.length() - s.replace("a", "").length();
        long repetitionCount = n / s.length();
        long aCountInFullyRepeatedStrings = aCountInString * repetitionCount;

        long remainder = n % s.length();
        String remainderString = s.substring(0, (int) remainder);
        int aCountInRemainderString = remainderString.length() - remainderString.replace("a", "").length();

        return aCountInFullyRepeatedStrings + aCountInRemainderString;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
