package com.simple.algorithm.recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Simple
 * @Date 2022/2/20
 * 爬楼梯，n阶。
 * 每次你可以爬1或2个台阶，你有多少不同的方法爬到楼顶
 * 注：n是正整数
 */
public class ClimbStairs {

    private Map<Integer,Integer> storeMap = new HashMap<>();

    /**
     * 纯粹递归实现
     * 有重复计算，时间复杂度高
     * @param n
     * @return
     */
    public int solution (int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return solution(n-1)+solution(n-2);

    }

    /**
     * 用空间换取时间。
     * 思路：使用HashMap保存已经求解出来的值
     * 避免重复计算，消耗时间性能。
     * @param n
     * @return
     */
    public int solutionWithHashMap (int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (null != storeMap.get(n)) {
            return storeMap.get(n);
        }else {
            int result = solutionWithHashMap(n-1)+solutionWithHashMap(n-2);
            storeMap.put(n,result);
            return result;
        }
    }

    /**
     * 循环的解放，自底向上累加
     * 记录前两个数字
     */
    public int solutionWithCycle (int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int result = 0;
        int pre = 2;
        int prePre = 1;
        for (int i = 3; i <= n ; i++) {
            result = pre + prePre;
            prePre = pre;
            pre = result;
        }
        return result;
    }
}
