import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class DanceMooves {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] cows = new int[input.nextInt()];
        int[][] moves = new int[input.nextInt()][2];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < cows.length; ++i) {
            cows[i] = i;
            Set<Integer> set = new HashSet<>();
            set.add(i);
            map.put(i, set);
        }
        for (int i = 0; i < moves.length; ++i) {
            moves[i][0] = input.nextInt() - 1;
            moves[i][1] = input.nextInt() - 1;
        }
        while (true) {
            boolean found = false;
            for (int[] move : moves) {
                int temp = cows[move[0]];
                cows[move[0]] = cows[move[1]];
                cows[move[1]] = temp;
                if (map.get(cows[move[0]]).add(move[0])) {
                    found = true;
                }
                if (map.get(cows[move[1]]).add(move[1])) {
                    found = true;
                }
            }
            if (!found) {
                break;
            }
        }
        for (int i = 0; i < cows.length; ++i) {
            System.out.println(map.get(i).size());
        }
    }
}
