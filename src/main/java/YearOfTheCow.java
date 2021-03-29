import java.util.Arrays;
import java.util.Scanner;

public class YearOfTheCow {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] years = new int[input.nextInt()];
        int jumps = input.nextInt();
        for (int i = 0; i < years.length; ++i) {
            years[i] = (input.nextInt() / 12 + 1) * 12;
        }
        Arrays.sort(years);
        int first = 0;
        int[] gaps = new int[years.length];
        for (int i = 0; i < gaps.length; ++i) {
            gaps[i] = years[i] - first;
            first = years[i];
        }
        Arrays.sort(gaps);
        int largest = years[years.length - 1];
        for (int i = 0; i < jumps - 1; ++i) {
            largest -= gaps[gaps.length - 1 - i] - 12;
        }
        System.out.println(largest);
    }
}
