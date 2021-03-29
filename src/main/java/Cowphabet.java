import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Cowphabet {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String alphabet = input.next();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < alphabet.length(); ++i) {
            map.put(alphabet.charAt(i), i);
        }
        char[] letters = input.next().toCharArray();
        int previous = map.get(letters[0]);
        int count = 1;
        for (int i = 1; i < letters.length; ++i) {
            int current = map.get(letters[i]);
            if (previous >= current) {
                ++count;
            }
            previous = current;
        }
        System.out.println(count);
    }
}
