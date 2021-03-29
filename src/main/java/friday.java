/*
ID: raymond68
LANG: JAVA
PROG: friday
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class friday {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new File("friday.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
        int year = input.nextInt();
        int day = 0;
        int[] week = new int[7];
        for (int i = 1900; i < 1900 + year; ++i) {
            for (int j = 1; j < 13; ++j) {
                ++week[day % 7];
                switch (j) {
                    case 2:
                        if (i % 4 == 0) {
                            if (i % 100 == 0) {
                                if (i % 400 == 0) {
                                    day += 29;
                                } else {
                                    day += 28;
                                }
                            } else {
                                day += 29;
                            }
                        } else {
                            day += 28;
                        }
                        break;
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                    case 8:
                    case 10:
                    case 12:
                        day += 31;
                        break;
                    case 4:
                    case 6:
                    case 9:
                    case 11:
                        day += 30;
                        break;
                }
            }
        }
        out.println(Arrays.stream(week).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
        out.close();
    }
}
