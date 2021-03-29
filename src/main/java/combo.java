/*
ID: raymond68
LANG: JAVA
PROG: combo
 */

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class combo {

    private static final String NAME = "combo";
    private static final boolean DEBUG = false;

    public static void main(String[] args) throws IOException {
        try (Scanner input = getScaner();
                PrintStream out = getOutput()) {
            int total = input.nextInt();
            int[] key = new int[3];
            int[] master = new int[3];
            Set<String> set = new HashSet<>();
            for (int i = 0; i < 3; ++i) {
                key[i] = input.nextInt();
            }
            for (int i = 0; i < 3; ++i) {
                master[i] = input.nextInt();
            }
            findKeys(set, key, total);
            findKeys(set, master, total);
            out.println(set.size());
        }
    }

    private static Scanner getScaner() throws IOException {
        if (DEBUG) {
            return new Scanner(System.in);
        }
        return new Scanner(new File(NAME + ".in"));
    }

    private static PrintStream getOutput() throws IOException {
        if (DEBUG) {
            return System.out;
        }
        return new PrintStream(new FileOutputStream(NAME + ".out"));
    }

    public static void findKeys(Set<String> set, int[] key, int total) {
        int num1 = previous(previous(key[0], total), total);
        for (int i = 0; i < 5; ++i) {
            int num2 = previous(previous(key[1], total), total);
            for (int j = 0; j < 5; ++j) {
                int num3 = previous(previous(key[2], total), total);
                for (int k = 0; k < 5; ++k) {
                    set.add(String.valueOf(num1) + num2 + num3);
                    num3 = next(num3, total);
                }
                num2 = next(num2, total);
            }
            num1 = next(num1, total);
        }
    }

    public static int previous(int num, int total) {
        if (num - 1 > 0) {
            return --num;
        } else {
            return total;
        }
    }

    public static int next(int num, int total) {
        if (num + 1 <= total) {
            return ++num;
        } else {
            return 1;
        }
    }
}
