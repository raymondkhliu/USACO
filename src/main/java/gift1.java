/*
ID: raymond68
LANG: JAVA
PROG: gift1
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class gift1 {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new File("gift1.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        int people = input.nextInt();
        for (int i = 0; i < people; ++i) {
            map.put(input.next(), 0);
        }
        for (int i = 0; i < people; ++i) {
            String giver = input.next();
            int amount = input.nextInt();
            int num = input.nextInt();
            if (num != 0) {
                int bank = map.get(giver);
                bank -= (amount - amount % num);
                map.put(giver, bank);
                for (int j = 0; j < num; ++j) {
                    String receiver = input.next();
                    bank = map.get(receiver);
                    bank += (amount / num);
                    map.put(receiver, bank);
                }
            }
        }
        for (Map.Entry<String, Integer> name : map.entrySet()) {
            out.println(name.getKey() + " " + name.getValue());
        }
        out.close();
    }
}
