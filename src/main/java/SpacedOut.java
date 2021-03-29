/*
 * Copyright 2020 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file except in compliance
 * with the License. A copy of the License is located at
 *
 * http://aws.amazon.com/apache2.0/
 *
 * or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES
 * OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SpacedOut {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int[][] field = new int[size][size];
        boolean[][] cow = new boolean[size][size];
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                field[i][j] = input.nextInt();
                if (!nums.contains(field[i][j])) {
                    nums.add(field[i][j]);
                }
            }
        }
        int[] arr = new int[nums.size()];
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = nums.get(i);
        }
        Arrays.sort(arr);
    }

    public static int findBeauty(int[][] field, boolean[][] cow) {
        int total = 0;
        for (int i = 0; i < cow.length; ++i) {
            for (int j = 0; j < cow[i].length; ++j) {
                if (cow[i][j]) {
                    total += field[i][j];
                }
            }
        }
        return total;
    }

    public static boolean isValid(boolean[][] cow, int row, int column) {
        if (cow[row][column]) {
            return false;
        }
        int north = 0;
        int east = 0;
        int south = 0;
        int west = 0;
        int northeast = 0;
        int northwest = 0;
        int southeast = 0;
        int southwest = 0;
        if (row - 1 >= 0) {
            if (column - 1 >= 0) {
                if (cow[row - 1][column - 1]) {
                    ++northwest;
                }
            }
            if (column + 1 < cow[row].length) {
                if (cow[row - 1][column + 1]) {
                    ++northeast;
                }
            }
            if (cow[row - 1][column]) {
                ++north;
            }
        }
        if (row + 1 < cow.length) {
            if (column - 1 >= 0) {
                if (cow[row + 1][column - 1]) {
                    ++southwest;
                }
            }
            if (column + 1 < cow[row].length) {
                if (cow[row + 1][column + 1]) {
                    ++southeast;
                }
            }
            if (cow[row + 1][column]) {
                ++south;
            }
        }
        if (column - 1 >= 0) {
            if (cow[row][column - 1]) {
                ++west;
            }
        }
        if (column + 1 < cow[row].length) {
            if (cow[row - 1][column]) {
                ++east;
            }
        }
        if (northwest + north + west > 1) {
            return false;
        }
        if (northeast + north + east > 1) {
            return false;
        }
        if (southeast + south + east > 1) {
            return false;
        }
        return southwest + south + west <= 1;
    }
}
