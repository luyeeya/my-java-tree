package dev.luyee.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/two-sum/">1. 两数之和</a><br/>
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。<br/>
 * 你可以假设每种输入只会对应一个答案。但是数组中同一个元素在答案里不能重复出现。<br/>
 * 你可以按任意顺序返回答案。<br/>
 * <br/>
 * 示例：<br/>
 * 输入：nums = [2,7,11,15], target = 9 <br/>
 * 输出：[0,1] <br/>
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            throw new RuntimeException("no solution");
        }

        Map<Integer, Integer> valueIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (valueIndexMap.containsKey(target - nums[i])) {
                return new int[]{valueIndexMap.get(target - nums[i]), i};
            }
            valueIndexMap.put(nums[i], i);
        }

        throw new RuntimeException("no solution");
    }

    public static void main(String[] args) {
        int[] array = {2, 7, 11, 15};
        int target = 9;
        System.out.printf("array = %s, target = %s%n", Arrays.toString(array), target);
        int[] result = new TwoSum().twoSum(array, 9);
        System.out.println("result = " + Arrays.toString(result));
    }
}
