package dev.luyee.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/number-of-boomerangs">447. 回旋镖的数量</a><br/>
 * 给定平面上 n 对(1 <= n <= 500)互不相同的点 points，其中 points[i] = [xi, yi]<br/>
 * 回旋镖是由点 (i, j, k) 表示的元组，其中 i 和 j 之间的欧式距离和 i 和 k 之间的欧式距离相等（要考虑元组的顺序）<br/>
 * 返回平面上所有回旋镖的数量。<br/>
 * <br/>
 * 示例：<br/>
 * 输入：points = [[0, 0], [1, 0], [2, 0]] <br/>
 * 输出：2 <br/>
 * 解释：两个回旋镖为 [[1, 0], [0, 0], [2, 0]] 和 [[1, 0], [2, 0], [0, 0]]
 */
public class NumberOfBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
        if (points == null || points.length < 3) {
            return 0;
        }

        int result = 0;
        Map<Integer, Integer> distanceCountMap = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            distanceCountMap.clear();
            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    int dist = distance(points[i], points[j]);
                    distanceCountMap.compute(dist, (k, v) -> v == null ? 1 : v + 1);
                }
            }
            for (Integer count : distanceCountMap.values()) {
                result += count * (count - 1);
            }
        }

        return result;
    }

    private int distance(int[] p1, int[] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }

    public static void main(String[] args) {
        int[][] array = {{0, 0}, {1, 0}, {2, 0}};
        System.out.println("array = " + Arrays.deepToString(array));
        int result = new NumberOfBoomerangs().numberOfBoomerangs(array);
        System.out.println("result = " + result);
    }
}
