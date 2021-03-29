import java.util.Scanner;

public class ComfortableCows {

    static int count = 0;
    static int[][] pasture = new int[2000][2000];
    static int up = 2;
    static int down = 4;
    static int left = 8;
    static int right = 16;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int cows = input.nextInt();
        for (int i = 0; i < cows; ++i) {
            int x = input.nextInt() + 500;
            int y = input.nextInt() + 500;
            if (pasture[x][y] != 0) {
                --count;
            } else {
                surrounding(x, y);
            }
            System.out.println(count);
        }
    }

    public static void check(int x, int y) {
        int current = pasture[x][y];
        if (current == 31 || current == 0) {
            return;
        }
        if (current + up == 31) {
            ++count;
            surrounding(x, y + 1);
        } else if (current + down == 31) {
            ++count;
            surrounding(x, y - 1);
        } else if (current + right == 31) {
            ++count;
            surrounding(x + 1, y);
        } else if (current + left == 31) {
            ++count;
            surrounding(x - 1, y);
        }
    }

    public static void surrounding(int x, int y) {
        pasture[x][y] = 1;
        if (pasture[x - 1][y] != 0) {
            pasture[x][y] += 8;
            pasture[x - 1][y] += 16;
        }
        if (pasture[x + 1][y] != 0) {
            pasture[x][y] += 16;
            pasture[x + 1][y] += 8;
        }
        if (pasture[x][y - 1] != 0) {
            pasture[x][y] += 4;
            pasture[x][y - 1] += 2;
        }
        if (pasture[x][y + 1] != 0) {
            pasture[x][y] += 2;
            pasture[x][y + 1] += 4;
        }
        check(x - 1, y);
        check(x + 1, y);
        check(x, y - 1);
        check(x, y + 1);
    }
}
