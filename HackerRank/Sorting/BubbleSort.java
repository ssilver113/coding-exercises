import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Collectors;

import static java.util.Collections.swap;

public class BubbleSort {

    // Complete the countSwaps function below.
    static void countSwaps(int[] a) {
        List<Integer> list = Arrays.stream(a).boxed().collect(Collectors.toList());
        int swapCount = 0;
        int n = list.size();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                // Swap adjacent elements if they are in decreasing order
                if (list.get(j) > list.get(j+1)) {
                    swap(list, j, j+1);
                    swapCount++;

                }
            }
        }

        System.out.printf("Array is sorted in %d swaps.%n", swapCount);
        System.out.printf("First Element: %d%n", list.get(0));
        System.out.printf("Last Element: %d%n", list.get(list.size() - 1));
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        countSwaps(a);

        scanner.close();
    }
}
