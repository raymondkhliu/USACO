import java.util.Scanner;

public class ComfortableCows2 {

    static int total = 0;
    static int[][] pasture = new int[2000][2000];

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int cows = input.nextInt();
        for (int i = 0; i < cows; ++i) {
            int x = input.nextInt() + 500;
            int y = input.nextInt() + 500;
            if (pasture[x][y] != 0) {
                --total;
            } else {
                surrounding(x, y);
            }
            System.out.println(total);
        }
    }

    public static void check(int x, int y) {
        if (pasture[x][y] == 0 || pasture[x][y] == 4) {
            return;
        }
        int count = 0;
        boolean up = pasture[x][y - 1] != 0;
        boolean down = pasture[x][y + 1] != 0;
        boolean left = pasture[x - 1][y] != 0;
        boolean right = pasture[x + 1][y] != 0;
        if (up) {
            ++count;
        }
        if (down) {
            ++count;
        }
        if (left) {
            ++count;
        }
        if (right) {
            ++count;
        }
        if (count == 3) {
            ++total;
            if (!up) {
                surrounding(x, y - 1);
            } else if (!down) {
                surrounding(x, y + 1);
            } else if (!left) {
                surrounding(x - 1, y);
            } else {
                surrounding(x + 1, y);
            }
        } else if (count == 4) {
            pasture[x][y] = 4;
        }
    }

    private static void surrounding(int x, int y) {
        pasture[x][y] = 1;
        check(x, y);
        check(x, y - 1);
        check(x, y + 1);
        check(x - 1, y);
        check(x + 1, y);
    }
}
