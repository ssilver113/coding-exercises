import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class RansomNote {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
        HashMap<String, Integer> magazineWordMap = new HashMap<>();
        boolean isRansomNotePossible = true;

        /*  create HashMap of magazine words (key = word; integer = word count) */
        for (String magazineWord : magazine) {
            if (magazineWordMap.containsKey(magazineWord)) {
                magazineWordMap.put(magazineWord, magazineWordMap.get(magazineWord) + 1);
            } else {
                magazineWordMap.put(magazineWord, 1);
            }
        }

        /* remove words from magazine HashMap, note can't be created if no possible words left */
        for (String noteWord : note) {
            if (magazineWordMap.containsKey(noteWord) && magazineWordMap.get(noteWord) > 0) {
                magazineWordMap.put(noteWord, magazineWordMap.get(noteWord) - 1);
            } else {
                isRansomNotePossible = false;
                break;
            }
        }

        if (isRansomNotePossible) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}
