import java.util.Scanner;

public class Cowntagion {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int roads = input.nextInt();
        int[] nodes = new int[100000];
        int count = roads - 1;
        for (int i = 0; i < roads - 1; ++i) {
            ++nodes[input.nextInt() - 1];
            ++nodes[input.nextInt() - 1];
        }
        for (int i = 0; i < roads; ++i) {
            if (nodes[i] > 1) {
                int children = nodes[i];
                if (i > 0) {
                    --children;
                }
                int temp = 1;
                int multiply = 0;
                while (temp < children + 1) {
                    ++multiply;
                    temp *= 2;
                }
                count += multiply;
            }
        }
        System.out.println(count);
    }
}
