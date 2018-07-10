package com.algorithm.uitls;

import java.util.Random;

/**
 *      排序测试工具类
 */
public class SortTestHelper {

    //  生成n 个元素的随机数组, 每个随机元素的范围在[lengthL,lengthR]
    public static int[] generateRandomArray(int n, int lengthL, int lengthR) {

        Random random = new Random();
        int[] arr = new int[n];
        for (int i=0; arr.length>i; i++ )
            arr[i] = random.nextInt(lengthR)%(lengthR-lengthL)+lengthL;
        return arr;
    }

    /**
     * 输出数组
     * @param arr
     */
    public static void printArray(int[] arr) {
        for (int i=0; arr.length>i; i++)
            System.out.print(arr[i] + "   ");
    }


}
