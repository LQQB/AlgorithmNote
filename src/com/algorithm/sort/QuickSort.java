package com.algorithm.sort;

import com.algorithm.uitls.SortTestHelper;

/**
 * @author LiQB
 * @Title:
 * @ProjectName AlgorithmNote
 * @Description: TODO
 * @date 2018/9/11 18:01
 */
public class QuickSort {

    /**
     * 快速排序基本原理:
     *      1.
     *
     * @param arr
     */
    public static void  quickSort(int[] arr) {

    }

    public static void main(String[] args) {

        int n = 100000;
        int[] arr = SortTestHelper.generateRandomArray(n, 0, n);
        long startTime = System.currentTimeMillis();
        quickSort(arr);
        long endTime = System.currentTimeMillis() ;
        System.out.println("程序运行时间：" + (endTime - startTime)/1000.0 + "s");    //输出程序运行时间

        SortTestHelper.printArray(arr);
    }
}
