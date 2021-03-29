/*
ID: raymond68
LANG: JAVA
PROG: barn1
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class barn1 {
    public static void main(String[] args) throws IOException {
        try (Scanner input = new Scanner(new File("barn1.in"));
                PrintWriter out = new PrintWriter(new FileWriter("barn1.out"))) {
            int boards = input.nextInt();
            List<Integer> gaps = new ArrayList<>();
            int covered = input.nextInt();
            int cows = input.nextInt();
            int[] filled = new int[cows];
            for (int i = 0; i < cows; ++i) {
                filled[i] = input.nextInt();
            }
            Arrays.sort(filled);
            int previous = filled[0];
            for (int i = 1; i < filled.length; ++i) {
                int current = filled[i];
                if (current > previous + 1) {
                    gaps.add(current - (previous + 1));
                }
                if (i == filled.length - 1) {
                    covered = current;
                }
                previous = current;
            }
            gaps.sort(Comparator.reverseOrder());
            for (int i = 0; i < boards - 1 && i < gaps.size(); ++i) {
                covered -= gaps.get(i);
            }
            covered -= filled[0] - 1;
            out.println(covered);
        }
    }
}
