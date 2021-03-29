import java.util.Scanner;

public class EvenMoreOddPhotos {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int totalCows = input.nextInt();
        int even = 0;
        for (int i = 0; i < totalCows; ++i) {
            if (input.nextInt() % 2 == 0) {
                ++even;
            }
        }
        int odd = totalCows - even;
        if (even > odd + 1) {
            System.out.println(2 * odd + 1);
        } else if (even == odd) {
            System.out.println(totalCows);
        } else {
            int photos = 2 * even;
            int extra = (totalCows - photos) % 3;
            photos += 2 * ((totalCows - photos) / 3);
            if (extra == 2) {
                ++photos;
            } else if (extra == 1) {
                --photos;
            }
            System.out.println(photos);
        }
    }
}
