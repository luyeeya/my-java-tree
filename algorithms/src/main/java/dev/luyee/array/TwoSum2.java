package dev.luyee.array;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted">167. 两数之和 II - 输入有序数组</a><br/>
 * 给你一个下标从 1 开始的整数数组 numbers，该数组已按非递减顺序排列，请你从数组中找出满足相加之和等于目标数 target 的两个数。
 * 如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.length。
 * 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
 * 【对撞指针】
 */
public class TwoSum2 {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            throw new RuntimeException("no solution");
        }

        int left = 0, right = nums.length - 1; // 由于 nums 有序，故可用对撞指针
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                return new int[]{++left, ++right}; // 数组下标从 1 开始
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                right--;
            }
        }

        throw new RuntimeException("no solution");
    }

    public static void main(String[] args) {
        int[] array = {2, 7, 11, 15};
        int target = 9;
        System.out.println("array = " + Arrays.toString(array) + ", target = " + target);
        int[] result = new TwoSum2().twoSum(array, target);
        System.out.println("result = " + Arrays.toString(result));
    }
}
