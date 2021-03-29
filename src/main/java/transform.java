/*
ID: raymond68
LANG: JAVA
PROG: transform
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class transform {
    public static void main(String[] args) throws IOException {
        try (Scanner input = new Scanner(new File("transform.in"));
                PrintWriter out = new PrintWriter(new FileWriter("transform.out"))) {
            int n = input.nextInt();
            char[][] board = new char[n][n];
            char[][] board2 = new char[n][n];
            for (int i = 0; i < n; ++i) {
                board[i] = input.next().toCharArray();
            }
            for (int i = 0; i < n; ++i) {
                board2[i] = input.next().toCharArray();
            }
            board = rotate90(board);
            if (Arrays.deepEquals(board, board2)) {
                out.println(1);
            } else if (isMirror(board, board2)) {
                out.println(5);
            } else {
                board = rotate90(board);
                if (Arrays.deepEquals(board, board2)) {
                    out.println(2);
                } else if (isMirror(board, board2)) {
                    out.println(5);
                } else {
                    board = rotate90(board);
                    if (Arrays.deepEquals(board, board2)) {
                        out.println(3);
                    } else if (isMirror(board, board2)) {
                        out.println(5);
                    } else {
                        board = rotate90(board);
                        if (Arrays.deepEquals(board, board2)) {
                            out.println(6);
                        } else if (isMirror(board, board2)) {
                            out.println(4);
                        } else {
                            out.println(7);
                        }
                    }
                }
            }
        }
    }

    public static char[][] rotate90(char[][] board) {
        int n = board.length;
        char[][] board2 = new char[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                board2[j][n - i - 1] = board[i][j];
            }
        }
        return board2;
    }

    public static boolean isMirror(char[][] board, char[][] board2) {
        int n = board.length;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] != board2[i][n - j - 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
