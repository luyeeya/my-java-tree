package dev.luyee.array;

import java.util.Arrays;
import java.util.Random;

/**
 * 二分查找：针对有序的数组
 */
public class BinarySearch {
    public static int search(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        // 在 [left, right] 中查找目标值
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) { // 维护好循环不变量
            int mid = left + (right - left) / 2; // 不能用 (left + right) / 2 计算 mid，存在整型溢出问题
            if (target == arr[mid]) {
                return mid;
            }
            if (target < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Random random = new Random(System.currentTimeMillis());
        int arrayLength = 10;
        int targetIndex = random.nextInt(arrayLength);
        int[] array = new int[arrayLength];
        array[0] = random.nextInt(100);
        for (int i = 1; i < arrayLength; i++) {
            array[i] = array[i - 1] + random.nextInt(10) + 1;
        }
        int target = array[targetIndex];
        System.out.println("array = " + Arrays.toString(array));

        int searchResult = BinarySearch.search(array, target);
        System.out.printf("target=%s, searchResult=%s%n", target, searchResult);
        assert searchResult == targetIndex;
    }
}
