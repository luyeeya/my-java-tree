package dev.luyee.array;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/move-zeroes/">283. 移动零</a><br/>
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int k = 0; // [0, k) 中都是非零元素
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (nums[k] == 0) { // 优化：非零和非零之间不交换
                    swap(nums, k++, i); // 将位置 i 上非零的元素交换到位置 k
                } else {
                    k++;
                }
            }
        }
    }

    private void swap(int[] nums, int one, int another) {
        int tmp = nums[one];
        nums[one] = nums[another];
        nums[another] = tmp;
    }

    public static void main(String[] args) {
        int[] array = new int[]{0, 1, 0, 3, 12};
        System.out.println("origin array = " + Arrays.toString(array));
        new MoveZeroes().moveZeroes(array);
        System.out.println("result array = " + Arrays.toString(array));
    }
}
