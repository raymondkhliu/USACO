/*
ID: raymond68
LANG: JAVA
PROG: dualpal
*/

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class dualpal {
    public static void main(String[] args) throws IOException {
        try (Scanner input = new Scanner(new File("dualpal.in"));
                PrintWriter out = new PrintWriter(new FileWriter("dualpal.out"))) {
            int n = input.nextInt();
            int start = input.nextInt() + 1;
            int i = 0;
            int found;
            while (i < n) {
                found = 0;
                for (int j = 2; j < 11; ++j) {
                    if (isPal(Integer.toString(start, j))) {
                        ++found;
                        if (found == 2) {
                            out.println(start);
                            ++i;
                            break;
                        }
                    }
                }
                ++start;
            }
        }
    }

    public static boolean isPal(String start) {
        char[] num = start.toCharArray();
        for (int i = 0; i < num.length / 2; ++i) {
            if (num[i] != num[num.length - i - 1]) {
                return false;
            }
        }
        return true;
    }
}
