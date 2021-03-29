import java.util.Arrays;
import java.util.Scanner;

public class JustStalling {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int[] cows = new int[size];
        int[] stalls = new int[size];
        for (int i = 0; i < size; ++i) {
            cows[i] = input.nextInt();
        }
        for (int i = 0; i < size; ++i) {
            stalls[i] = input.nextInt();
        }
        Arrays.sort(cows);
        Arrays.sort(stalls);
        long total = 1;
        int availableStalls = size - 1;
        for (int i = size - 1; i > 0; --i) {
            int count = 0;
            for (int j = availableStalls; j >= 0; --j) {
                if (stalls[j] >= cows[i]) {
                    ++count;
                    if (j == 0) {
                        --availableStalls;
                    }
                } else {
                    --availableStalls;
                    break;
                }
            }
            total *= count;
        }
        System.out.println(total);
    }
}
