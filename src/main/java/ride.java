/*
ID: raymond68
LANG: JAVA
PROG: ride
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ride {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("ride.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
        int comet = 1;
        for (char value : in.readLine().toCharArray()) {
            comet *= (value - '@');
        }
        int group = 1;
        for (char c : in.readLine().toCharArray()) {
            group *= (c - '@');
        }
        if ((comet % 47) == (group % 47)) {
            out.println("GO");
        } else {
            out.println("STAY");
        }
        out.close();
    }
}
