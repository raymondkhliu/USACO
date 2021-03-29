/*
ID: raymond68
LANG: JAVA
PROG: crypt1
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class crypt1 {
    public static void main(String[] args) throws IOException {
        try (Scanner input = new Scanner(new File("crypt1.in"));
                PrintWriter out = new PrintWriter(new FileWriter("crypt1.out"))) {
            int total = input.nextInt();
            int[] set = new int[total];
            for (int i = 0; i < total; ++i) {
                set[i] = input.nextInt();
            }
            int count = 0;
            for (int i = 0; i < total; ++i) {
                for (int j = 0; j < total; ++j) {
                    for (int k = 0; k < total; ++k) {
                        int top = 100 * set[i] + 10 * set[j] + set[k];
                        for (int l = 0; l < total; ++l) {
                            for (int m = 0; m < total; ++m) {
                                int num1 = top * set[m];
                                if (num1 > 999 || check(num1, set)) {
                                    continue;
                                }
                                int num2 = top * set[l];
                                if (num2 > 999 || check(num2, set)) {
                                    continue;
                                }
                                int result = num1 + 10 * num2;
                                if (result <= 9999 && !check(result, set)) {
                                    ++count;
                                }
                            }
                        }
                    }
                }
            }
            out.println(count);
        }
    }

    public static boolean check(int num, int[] set) {
        char[] nums = Integer.toString(num).toCharArray();
        for (char c : nums) {
            boolean found = false;
            for (int k : set) {
                if (c - '0' == k) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return true;
            }
        }
        return false;
    }
}
