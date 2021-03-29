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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class RectangularPasture {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int total = (int) Math.pow(2, n);
        Map<Integer, List<Integer>> xs = new HashMap<>();
        Map<Integer, List<Integer>> ys = new HashMap<>();
        int xval;
        int yval;
        List<Integer> list;
        for (int i = 0; i < n; ++i) {
            list = new ArrayList<>();
            xval = input.nextInt();
            if (xs.containsKey(xval)) {
                list = xs.get(xval);
            }
            list.add(i);
            xs.put(xval, list);
            list = new ArrayList<>();
            yval = input.nextInt();
            if (ys.containsKey(yval)) {
                list = ys.get(yval);
            }
            list.add(i);
            ys.put(yval, list);
        }
        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {
                //                if (isBetween(xs, ys, i, j))
            }
        }
    }

    public static boolean isBetween(
            Map<Integer, List<Integer>> xs,
            Map<Integer, List<Integer>> ys,
            int fx,
            int fy,
            int sx,
            int sy) {

        return false;
    }
}
