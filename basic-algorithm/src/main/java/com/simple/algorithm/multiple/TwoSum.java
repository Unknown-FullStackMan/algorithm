package com.simple.algorithm.multiple;

import java.util.HashMap;
import java.util.Map;


/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的 两个 整数。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */

/**
 * @Author Simple
 * @Create 2022/2/15 13:38
 */
public class TwoSum {


    /**
     * 暴力搜索
     * 该方法使用了两个循环，第一个循环，循环n次，第二个循环(n-1)次，相对于,从第二个元素开始循环，所以时间复杂度为T（n）=O（n^2)，空间复杂度为:O(n)=1
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        int[] a = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    a[0] = i;
                    a[1] = j;
                }
            }
        }
        return a;
    }

    /**
     * 两遍哈希表（以空间速度）
     * 该方法使用了两次迭代，也就是使用了两个for循环，具体思路都在代码里，该方法的时间复杂度为T(n)=O(n),
     * 但是空间复杂度加大了，我们这里创建了一个哈希表，哈希表中存储的数据取决于数组，存了n个元素，所以是T（n）=O（n)。
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        /**
         * 保持数组中的每个元素与其索引对应的最好办法，哈希表
         * 先把数组的索引和其索引所对应的值放入HashMap中
         */

        /**1.创建一个HashMap，key-value的泛型为Integer **/
        Map<Integer, Integer> map = new HashMap<>();
        /**2.for循环，第一次迭代 **/
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        /**
         * 3.第二次迭代，判断
         */
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            /**
             * 判断是否在哈希表中，并且不能和自身相等
             */
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i,map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 一遍哈希表法
     * 时间复杂度：T（n）=O（n）
     * 空间复杂度：T（n）=O（n）
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum3(int[] nums, int target) {
        /**
         * 1.先创建一个HashMap
         */
        Map<Integer, Integer> map = new HashMap<>();
        /**
         * 2.迭代一次
         * 每次向表中添加数据的时候，判断表中是否已经有元素
         * 有元素就说明数组中有对应的两个数字相加==target
         * 没有就添加进Hashmap
         */
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement),i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
