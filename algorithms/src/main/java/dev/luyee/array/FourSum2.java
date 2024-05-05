package dev.luyee.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/4sum-ii">454. 四数相加 II</a><br/>
 * 给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
 * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0 (0 <= i, j, k, l < n, 1 <= n <= 200) <br/>
 * <br/>
 * 示例：<br/>
 * 输入：nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2] <br/>
 * 输出：2 <br/>
 * 解释：<br/>
 * 两个元组如下：<br/>
 * 1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) + 2 = 0 <br/>
 * 2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) + 0 = 0
 */
public class FourSum2 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> sumCountMap = new HashMap<>();
        for (int v3 : nums3) {
            for (int v4 : nums4) {
                sumCountMap.compute(v3 + v4, (k, v) -> v == null ? 1 : v + 1);
            }
        }

        int count = 0;
        for (int v1 : nums1) {
            for (int v2 : nums2) {
                count += sumCountMap.getOrDefault(-(v1 + v2), 0);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2}, nums2 = {-2, -1}, nums3 = {-1, 2}, nums4 = {0, 2};
        System.out.printf("nums1 = %s, nums2 = %s, nums3 = %s, nums4 = %s%n",
                Arrays.toString(nums1), Arrays.toString(nums2), Arrays.toString(nums3), Arrays.toString(nums4));
        int count = new FourSum2().fourSumCount(nums1, nums2, nums3, nums4);
        System.out.println("count = " + count);
    }
}
