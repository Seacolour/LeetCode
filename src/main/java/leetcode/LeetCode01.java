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
     * 380. O(1) 时间插入、删除和获取随机元素
     * 实现RandomizedSet 类：
     *
     * RandomizedSet() 初始化 RandomizedSet 对象
     * bool insert(int val) 当元素 val 不存在时，向集合中插入该项，并返回 true ；否则，返回 false 。
     * bool remove(int val) 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false 。
     * int getRandom() 随机返回现有集合中的一项（测试用例保证调用此方法时集合中至少存在一个元素）。每个元素应该有 相同的概率 被返回。
     * 你必须实现类的所有函数，并满足每个函数的 平均 时间复杂度为 O(1) 。
     */
//    class RandomizedSet {
//
//        public RandomizedSet() {
//            RandomizedSet randomizedSet=new RandomizedSet();
//
//        }
//
//        public boolean insert(int val) {
//            if(val == null){
//                randomizedSet.insert(val)
//            }else{
//                return false;
//            }
//
//        }
//        public boolean remove(int val) {
//        }
//
//        public int getRandom() {
//        }
//    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        LeetCode01 leetCode01 = new LeetCode01();
        System.out.println(leetCode01.jump(nums));

    }
}
