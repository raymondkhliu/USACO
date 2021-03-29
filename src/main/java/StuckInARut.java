import java.util.Scanner;

public class StuckInARut {
    public void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char[] direction = new char[input.nextInt()];
        int[][] coordinates = new int[direction.length][2];
        for (int i = 0; i < direction.length; ++i) {
            direction[i] = input.next().charAt(0);
            coordinates[i][0] = input.nextInt();
            coordinates[i][1] = input.nextInt();
        }
        for (int i = 0; i < direction.length; ++i) {
            int eaten = Integer.MAX_VALUE;
            for (int j = 0; j < direction.length; ++j) {
                if (i == j) {
                    continue;
                }
                eaten = Math.min(eaten, intersect(direction, coordinates, i, j));
            }
            if (eaten == Integer.MAX_VALUE) {
                System.out.println("Infinity");
            } else {
                System.out.println(eaten);
            }
        }
    }

    public int intersect(char[] directions, int[][] coordinates, int i, int j) {
        int eastJ = coordinates[j][1];
        int eastI = coordinates[i][1];
        int northJ = coordinates[j][0];
        int northI = coordinates[i][0];
        if (directions[i] == directions[j]) {
            if (directions[i] == 'E') {
                if (northI == northJ) {
                    if (eastJ > eastI) {
                        return eastJ - eastI;
                    } else {
                        return Integer.MAX_VALUE;
                    }
                } else {
                    return Integer.MAX_VALUE;
                }
            } else {
                if (eastI == eastJ) {
                    if (northJ > northI) {
                        return northJ - northI;
                    } else {
                        return Integer.MAX_VALUE;
                    }
                } else {
                    return Integer.MAX_VALUE;
                }
            }
        } else {
            if (directions[i] == 'E') {
                if (northI < northJ || eastI > eastJ) {
                    return Integer.MAX_VALUE;
                } else {
                    if (eastJ - eastI > northI - northJ) {
                        return eastJ - eastI;
                    } else {
                        return Integer.MAX_VALUE;
                    }
                }
            } else {
                if (northI > northJ || eastI < eastJ) {
                    return Integer.MAX_VALUE;
                } else {
                    if (northJ - northI > eastI - eastJ) {
                        return northJ - northI;
                    } else {
                        return Integer.MAX_VALUE;
                    }
                }
            }
        }
    }
}
