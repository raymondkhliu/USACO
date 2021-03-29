/*
ID: raymond68
LANG: JAVA
PROG: beads
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class beads {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new File("beads.in"));
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")))) {
            int total = input.nextInt();
            int largest = 0;
            char[] beads = input.next().toCharArray();
            for (int i = 0; i < total; ++i) {
                int count = 0;
                char first = 'w';
                int start = i;
                for (int j = 0; j < total; ++j) {
                    if (beads[start] != first) {
                        if (first == 'w') {
                            first = beads[start];
                        } else if (beads[start] != 'w') {
                            count += j;
                            break;
                        }
                    }
                    if (++start == total) {
                        start = 0;
                    }
                }
                if (count == 0) {
                    out.println(total);
                    return;
                }
                start = i;
                first = 'w';
                for (int j = 0; j < total; ++j) {
                    if (--start < 0) {
                        start = total - 1;
                    }
                    if (beads[start] != first) {
                        if (first == 'w') {
                            first = beads[start];
                        } else if (beads[start] != 'w') {
                            count += j;
                            break;
                        }
                    }
                }
                largest = Math.max(count, largest);
            }
            largest = Math.min(total, largest);
            out.println(largest);
        }
    }
}
