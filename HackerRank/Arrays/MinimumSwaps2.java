import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MinimumSwaps2 {

	// Complete the minimumSwaps function below.
	static int minimumSwaps(int[] arr) {
		int minimumSwapCount = 0;

		for (int i = 0; i < arr.length; i++) {
			int expectedNumber = i + 1;
			int currentNumber = arr[i];
			int currentNumberExpectedIndex = currentNumber - 1;

			if (arr[i] != expectedNumber) {
				/* not in correct position, swap into correct position */
				arr[i] = arr[currentNumberExpectedIndex];
				arr[currentNumberExpectedIndex] = currentNumber;
				minimumSwapCount++;
				i--; // go one step back to check switched number again so nothing gets skipped
			}
		}

		return minimumSwapCount;
	}
}
