package leetcode;

import java.util.Arrays;

public class LeetCode01 {


    /**
     * 88. 合并两个有序数组
     * <p>
     * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
     * 输出：[1,2,2,3,5,6]
     * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n     关键点nums1的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
     *              合并两个数组后用数组排序方法sort排序
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int j = 0;
        for (int i = m; i < m + n; i++) {
            nums1[i] = nums2[j];
            j++;
        }
        Arrays.sort(nums1);
        System.out.println(Arrays.toString(nums1));
    }

    /**
     * 27. 移除元素
     * 输入：nums = [0,1,2,2,3,0,4,2], val = 2
     * 输出：5, nums = [0,1,4,0,3,_,_,_]
     * 解释：你的函数应该返回 k = 5，并且 nums 中的前五个元素为 0,0,1,3,4。
     * 注意这五个元素可以任意顺序返回。
     * 你在返回的 k 个元素之外留下了什么并不重要（因此它们并不计入评测）。
     *
     * @param nums
     * @param val
     * @return 双指针，交换值，完成循环后，返回i的值，i=k；
     */
    public int removeElement(int[] nums, int val) {
        int i;
        int k;
        int j = nums.length;
        for (i = 0; i < j; i++) {
            if (nums[i] == val) {
                nums[i] = nums[j - 1];
                j--;
                i--;
            }
        }
        k = i;
        return k;
    }

    /**
     * 26. 删除排序数组中的重复项
     * 输入：nums = [0,0,1,1,1,2,2,3,3,4]
     * 输出：5, nums = [0,1,2,3,4]
     * 解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。
     * 不需要考虑数组中超出新长度后面的元素。
     *
     * @param nums 快慢双指针，关键点：数组为非严格递增，相同元素肯定相邻
     */
    public int removeDuplicates(int[] nums) {
        int fast = 1;
        int slow = 0;
        int len = nums.length;
        while (fast < len) {
            if (nums[slow] != nums[fast]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }

    /**
     * 80. 删除排序数组中的重复项 II
     * 输入：nums = [0,0,1,1,1,1,2,3,3]
     * 输出：7, nums = [0,0,1,1,2,3,3]
     * 解释：函数应返回新长度 length = 7, 并且原数组的前七个元素被修改为 0, 0, 1, 1, 2, 3, 3。
     * 不需要考虑数组中超出新长度后面的元素。
     * 快慢指针，遇到相同元素，计数器加1，如果计数器小于2，则将当前元素赋值给slow，
     * 否则跳过该元素，fast指针继续移动
     *
     * @param
     */
    public int removeDuplicates2(int[] nums) {
        int fast = 1;
        int slow = 0;
        int count = 1;
        while (fast < nums.length) {
            if (nums[fast] == nums[slow]) {
                if (count < 2) {
                    nums[++slow] = nums[fast];
                    count++;
                }
                fast++;
            } else {
                nums[++slow] = nums[fast];
                count = 1;
                fast++;
            }
        }
        return slow + 1;
    }

    /**
     * 169. 求众数
     * 输入：nums = [2,2,1,1,1,2,2]
     * 输出：2
     *
     * @param nums
     * @return 排序后，众数会出现在中间，取中间值
     */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * 45. 跳跃游戏 II
     * 输入: nums = [2,3,1,1,4]
     * 输出: 2
     * 解释: 跳到最后一个位置的最小跳跃数是 2。
     * 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
     * 经典贪心算法，从后往前。
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int len = nums.length;
        int j = len - 1;
        int count = 0;
        while (j > 0) {
            for (int i = 0; i < j; i++)
                if (nums[i] + i >= j) {
                    j = i;
                    count++;
                    break;
                }
        }
        return count;
    }

    /**
     * 121. 买卖股票的最佳时机
     * 输入：[7,1,5,3,6,4]
     * 输出：5
     * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
     * @param prices
     * @return
     * 动态规划，拿最小值，找差价最大值
     */
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int count = 0;
        for(int i=0;i<prices.length;i++){
            min=Math.min(min,prices[i]);
            count=Math.max(count,prices[i]-min);
        }
        return count;
    }

    /**
     * 122. 买卖股票的最佳时机 II
     * 输入：prices = [7,1,5,3,6,4]
     * 输出：7
     * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4。
     * 随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6 - 3 = 3。
     * 最大总利润为 4 + 3 = 7 。
     * @param prices
     * 动态规划，挣到所有涨幅，避开所有降幅
     */
    public int maxProfit2(int[] prices) {
        int count = 0;
        for(int i=0;i<prices.length-1;i++){
            if(prices[i]<prices[i+1]){
                count+=prices[i+1]-prices[i];
            }
        }
        return count;
    }

    /**
     * 238. 除自身以外数组的乘积
     * 输入: nums = [1,2,3,4]
     * 输出: [24,12,8,6]
     * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
     * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
     * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
     * 用数组保存前后缀，从左到右，从右到左，计算乘积，最后遍历answer数组，赋值即可
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] L = new int[length];
        int[] R = new int[length];
        int[] answer = new int[length];
        L[0] = 1;
        for (int i = 1; i < length; i++) {
            L[i] = nums[i - 1] * L[i - 1];
        }
        R[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            R[i] = nums[i + 1] * R[i + 1];
        }
        for (int i = 0; i < length; i++) {
            answer[i] = L[i] * R[i];
        }
        return answer;
    }

    /**
     * 125. 验证回文串
     * 输入: s = "A man, a plan, a canal: Panama"
     * 输出：true
     * 解释："amanaplanacanalpanama" 是回文串。
     * 前后双指针
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        StringBuffer sgood = new StringBuffer();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sgood.append(Character.toLowerCase(ch));
            }
        }
        int n = sgood.length();
        int left = 0, right = n - 1;
        while (left < right) {
            if (Character.toLowerCase(sgood.charAt(left)) != Character.toLowerCase(sgood.charAt(right))) {
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }


    public static void main(String[] args) {
        int[] nums = {7,1,5,3,6,4};
        LeetCode01 leetCode01 = new LeetCode01();
        System.out.println(leetCode01.maxProfit2(nums));

    }
}
