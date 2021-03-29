import java.util.Scanner;

public class mooZ {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 7; ++i) {
            int value = input.nextInt();
            max = Math.max(value, max);
            if (value < a) {
                b = a;
                a = value;
            } else if (value < b) {
                b = value;
            }
        }
        System.out.println(a + " " + b + " " + (max - (a + b)));
    }
}
