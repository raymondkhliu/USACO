import java.util.HashSet;
import java.util.Scanner;

public class DaisyChains {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        HashSet<Integer> set;
        int[] arr = new int[input.nextInt()];
        int total = arr.length;
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = input.nextInt();
        }
        for (int i = 0; i < arr.length; ++i) {
            int sum = arr[i];
            set = new HashSet<>();
            set.add(arr[i]);
            for (int j = 1; j + i < arr.length; ++j) {
                set.add(arr[i + j]);
                sum += arr[i + j];
                if (sum % (j + 1) == 0) {
                    if (set.contains(sum / (j + 1))) {
                        ++total;
                    }
                }
            }
        }
        System.out.println(total);
    }
    //
    //    public static void main(String[] args) {
    //        Scanner input = new Scanner(System.in);
    //        int[] arr = new int[input.nextInt()];
    //        int total = arr.length;
    //        for (int i = 0; i < arr.length; ++i) {
    //            arr[i] = input.nextInt();
    //        }
    //        for (int i = 0; i < arr.length; ++i) {
    //            int sum = arr[i];
    //            for (int j = 1; j + i < arr.length; ++j) {
    //                sum += arr[i + j];
    //                if (sum % (j + 1) == 0) {
    //                    for (int k = 0; k + i < arr.length; ++k) {
    //                        if (arr[i + k] == sum / (j + 1)) {
    //                            ++total;
    //                            break;
    //                        }
    //                    }
    //                }
    //            }
    //        }
    //        System.out.println(total);
    //    }
}
