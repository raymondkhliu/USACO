/*
ID: raymond68
LANG: JAVA
PROG: milk2
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class milk2 {
    public static void main(String[] args) throws IOException {
        try (Scanner input = new Scanner(new File("milk2.in"));
                PrintWriter out = new PrintWriter(new FileWriter("milk2.out"))) {
            int n = input.nextInt();
            int[][] times = new int[n][2];
            for (int i = 0; i < n; ++i) {
                times[i][0] = input.nextInt();
                times[i][1] = input.nextInt();
            }
            Arrays.sort(times, Comparator.comparingInt(o -> o[0]));
            int start = times[0][0];
            int end = times[0][1];
            int gap = 0;
            int longest = 0;
            for (int i = 1; i < n; ++i) {
                if (times[i][0] <= end) {
                    end = Math.max(times[i][1], end);
                } else {
                    longest = Math.max(end - start, longest);
                    gap = Math.max(gap, times[i][0] - end);
                    start = times[i][0];
                    end = times[i][1];
                }
            }
            longest = Math.max(longest, end - start);
            out.println(longest + " " + gap);
        }
    }
}
