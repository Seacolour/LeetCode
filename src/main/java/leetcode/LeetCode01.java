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
     *
     * @param
     */
//    public int removeDuplicates2(int[] nums) {
//        int fast = 1;
//        int slow = 0;
//        int count = 1;
//        while(fast < nums.length){
//            if(count < 3 && nums[slow] != nums[fast]){
//             }
//        }
//
//    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        LeetCode01 leetCode01 = new LeetCode01();

    }
}
