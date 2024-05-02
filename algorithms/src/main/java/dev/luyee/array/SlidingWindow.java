package dev.luyee.array;


/**
 * 双指针之滑动窗口
 */
public class SlidingWindow {
    /**
     * <a href="https://leetcode.cn/problems/minimum-size-subarray-sum">209. 长度最小的子数组</a><br/>
     * 给定一个含有 n 个正整数的数组和一个正整数 target，找出该数组中满足其总和大于等于 target 的长度最小的连续子数组，
     * 并返回其长度。如果不存在符合条件的子数组，返回 0<br/>
     * 示例：<br/>
     *     输入：target = 7, nums = [2,3,1,2,4,3]<br/>
     *     输出：2<br/>
     *     解释：子数组 [4,3] 是该条件下的长度最小的子数组。
     */
    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int left = 0, right = -1; // nums[left, right] 为滑动窗口
        int sum = 0; // 子数组元素总和
        int minLen = nums.length + 1; // 初始化为大于所有可能取值的值，用来后面比较最小值
        while (left < nums.length) {
            if (right < nums.length - 1 && sum < target) {
                right++;
                sum += nums[right];
            } else {
                sum -= nums[left];
                left++;
            }

            if (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
            }
        }

        return minLen == nums.length + 1 ? 0 : minLen;
    }

    /**
     * <a href="https://leetcode.cn/problems/longest-substring-without-repeating-characters">3. 无重复字符的最长子串</a><br/>
     * 给定一个字符串s ，找出其中不含有重复字符的最长子串的长度（s由英文字母、数字、符号和空格组成）<br/>
     * 示例: <br/>
     *     输入: s = "abcabcbb" <br/>
     *     输出: 3 <br/>
     *     解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int maxLen = 0;
        int left = 0, right = -1; // [left, right] 是 s 上的滑动窗口
        int[] freq = new int[128]; // ASCII表中每个字符在滑动窗口中出现的频率
        while (left < s.length()) {
            if (right < s.length() - 1 && freq[s.charAt(right + 1)] == 0) {
                right++;
                freq[s.charAt(right)]++;
            } else {
                freq[s.charAt(left)]--;
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        // 测试 minSubArrayLen()
        int minLen = new SlidingWindow().minSubArrayLen(11, new int[]{1,2,3,4,5});
        System.out.println("minLen = " + minLen);

        // 测试 lengthOfLongestSubstring()
        int maxLen = new SlidingWindow().lengthOfLongestSubstring("abcabcbb");
        System.out.println("maxLen = " + maxLen);
    }
}
