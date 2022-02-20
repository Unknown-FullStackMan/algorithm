package com.simple.algorithm.recursion;

import com.simple.algorithm.constant.MagicalValue;



/**
 * @Author Simple
 * @Create 2022/2/15 10:50
 * 斐波那契
 */
public class Fibonacci {

    /**
     * 循环次数
     */
    private static final int LOOP = 10;

    public static void main(String[] args) {
        for (int i = 0; i <= LOOP; i++) {
            System.out.println(fibonacciByRecursion(i));
        }
        for (int i = 0; i <= LOOP; i++) {
            System.out.println(fibonacciByCycle(i));
        }
    }

    /**
     * 递归实现斐波那契数列
     * @param num
     * @return
     */
    public static long fibonacciByRecursion(long num) {
        if ( (num == MagicalValue.ZERO) || (num == MagicalValue.ONE) ) {
            return num;
        }else {
            return fibonacciByRecursion(num - MagicalValue.ONE) + fibonacciByRecursion(num - MagicalValue.TWO);
        }
    }

    /**
     * For循环实现斐波那契数列
     * @param num
     * @return
     */
    public static long fibonacciByCycle(long num) {
        /** 三个数一组： 分前中后 **/
        long front = MagicalValue.ONE;
        long middle = MagicalValue.ONE;
        long rear = MagicalValue.ZERO;
        if (num < MagicalValue.ONE) {
            return MagicalValue.ZERO;
        }
        if (num == MagicalValue.ONE || num == MagicalValue.TWO) {
            return MagicalValue.ONE;
        }
        for (int i = 0; i < num - MagicalValue.TWO; i++) {
            rear = front + middle;
            front = middle;
            middle = rear;
        }
        return rear;
    }

}
