import java.util.Scanner;
import java.util.Stack;

public class JustGreenEnough {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        boolean[][] zero = new boolean[n][n];
        boolean[][] all = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                int current = input.nextInt();
                if (current < 100) {
                    zero[i][j] = true;
                    all[i][j] = true;
                } else if (current == 100) {
                    all[i][j] = true;
                }
            }
        }
        System.out.println(count(all, n) - count(zero, n));
    }

    private static long count(boolean[][] arr, int n) {
        long[][] sums = new long[n][n];
        prefixSum(sums, arr, n);
        long result = 0;
        for (int j = 0; j < n; ++j) {
            int i = n - 1;
            Stack<long[]> stack = new Stack<>();
            long sum = 0;
            while (i >= 0) {
                long count = 0;
                while (!stack.isEmpty() && stack.peek()[0] > sums[i][j]) {
                    sum -= (stack.peek()[1] + 1) * (stack.peek()[0] - sums[i][j]);
                    count += stack.peek()[1] + 1;
                    stack.pop();
                }
                sum += sums[i][j];
                result += sum;
                stack.add(new long[] {sums[i][j], count});
                --i;
            }
        }
        return -result;
    }

    private static void prefixSum(long[][] sums, boolean[][] arr, int n) {
        for (int i = 0; i < n; ++i) {
            for (int j = n - 1; j >= 0; --j) {
                if (arr[i][j]) {
                    continue;
                }
                if (j != n - 1) {
                    sums[i][j] += sums[i][j + 1];
                }
                if (!arr[i][j]) {
                    sums[i][j] += 1;
                }
            }
        }
    }
}
