/*
ID: raymond68
LANG: JAVA
PROG: palsquare
*/

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class palsquare {
    public static void main(String[] args) throws IOException {
        try (Scanner input = new Scanner(new File("palsquare.in"));
                PrintWriter out = new PrintWriter(new FileWriter("palsquare.out"))) {
            int base = input.nextInt();
            List<String> converted;
            int quotient;
            for (int i = 1; i < 301; ++i) {
                String sqr = Integer.toString(i * i, base).toUpperCase(Locale.ROOT);
                if (isPal(sqr)) {
                    out.println(Integer.toString(i, base).toUpperCase(Locale.ROOT) + " " + sqr);
                }
            }
        }
    }

    public static boolean isPal(String sqr) {
        char[] num = sqr.toCharArray();
        for (int i = 0; i < num.length / 2; ++i) {
            if (num[i] != num[num.length - i - 1]) {
                return false;
            }
        }
        return true;
    }
}
