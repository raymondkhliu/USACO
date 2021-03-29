import java.util.Scanner;

public class NoTimeToPaint {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int[][] range = new int[input.nextInt()][2];
        char[] fence = input.next().toCharArray();
        boolean[] alphabet;
        for (int i = 0; i < range.length; ++i) {
            for (int j = 0; j < 2; ++j) {
                range[i][j] = input.nextInt();
            }
        }
        for (int i = 0; i < range.length; ++i) {
            alphabet = new boolean[26];
            int count = 0;
            char[] left = new char[range[i][0] - 1];
            for (int j = 0; j < range[i][0] - 1; ++j) {
                left[j] = fence[j];
                alphabet[fence[j] - 'A'] = true;
            }
            int leftCount = findCount(left, alphabet);
            alphabet = new boolean[26];
            char[] right = new char[fence.length - range[i][1]];
            int index = 0;
            for (int j = range[i][1]; j < fence.length; ++j) {
                right[index++] = fence[j];
                alphabet[fence[j] - 'A'] = true;
            }
            System.out.println(leftCount + findCount(right, alphabet));
        }
    }

    public static int findCount(char[] fence, boolean[] alphabet) {
        if (fence.length == 0) {
            return 0;
        }
        int total = 0;
        for (int i = 'Z'; i >= 'A'; --i) {
            if (alphabet[i - 'A']) {
                int count = 0;
                boolean found = false;
                for (char c : fence) {
                    if (c >= i) {
                        if (!found) {
                            ++count;
                            found = true;
                        }
                    } else {
                        found = false;
                    }
                }
                total += count;
            }
        }
        return total;
    }
}
