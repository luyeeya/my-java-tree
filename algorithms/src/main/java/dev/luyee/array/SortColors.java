package dev.luyee.array;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/sort-colors">75. 颜色分类</a><br/>
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 * 【三路快排】
 */
public class SortColors {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int red = -1; // [0, red] 中是红色元素
        int blue = nums.length; // [blue, nums.length - 1] 中是蓝色元素，则 (red, blue) 中是白色元素
        for (int i = 0; i < blue; ) { // 注意：边界为 blue
            if (nums[i] == 1) { // 白色
                i++;
            } else if (nums[i] == 0) { // 红色
                swap(nums, i, ++red); // 与 red 后面的一个元素交换位置（一定为白色元素）
                i++;
            } else { // 蓝色
                swap(nums, i, --blue); // 与 blue 前面的一个未知元素交换位置
            }
        }
    }

    private void swap(int[] nums, int one, int another) {
        int tmp = nums[one];
        nums[one] = nums[another];
        nums[another] = tmp;
    }

    public static void main(String[] args) {
        int[] array = {2, 0, 1, 1, 2, 0, 1};
        System.out.println("origin = " + Arrays.toString(array));
        new SortColors().sortColors(array);
        System.out.println("result = " + Arrays.toString(array));
    }
}
