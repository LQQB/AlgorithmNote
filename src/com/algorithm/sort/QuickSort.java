package com.algorithm.sort;

import com.algorithm.uitls.SortTestHelper;

import java.util.Random;

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
     *      1. 选择第一个元素作为基准数，
     *
     * @param arr
     */
    public static void  quickSort(int[] arr) {
        __quickSort(arr, 0, arr.length-1);
    }


    // 对 arr[l ... r] 部分进行快速排序
    private static void __quickSort(int[] arr, int l, int r) {

        if(l >= r) return;

        int p = __partition(arr, l, r);     //
        __quickSort(arr, l, p-1);   // 递归左侧数组
        __quickSort(arr, p+1, r);   // 递归右侧数组
    }


    // 对 arr[l ... r] 部分进行 partition 操作
    // 返回 p(基准数), 使得arr[l ... p-1] < arr[p] ; arr[p+1 .... r] > arr[p]
    private static int __partition(int[] arr, int l, int r) {

        SortTestHelper.exchange( arr, l, SortTestHelper.ranInt()%(r - l + 1) );

        int v = arr[l];

        int j = l;
        for(int i = l + 1; i <= r; i++) {
            if( arr[i] < v) {
                SortTestHelper.exchange(arr, j+1, i);
                j ++;
            }
        }
        SortTestHelper.exchange(arr, l, j);
        return j;
    }





    public static void main(String[] args) {

        int n = 100000;
//        int[] arr = SortTestHelper.generateRandomArray(n, 0, n);

        int[] arr = SortTestHelper.generateNearyOrdereArray(n, 100);
        long startTime = System.currentTimeMillis();
        quickSort(arr);
        long endTime = System.currentTimeMillis() ;
        System.out.println("程序运行时间：" + (endTime - startTime)/1000.0 + "s");    //输出程序运行时间

        SortTestHelper.printArray(arr);
    }
}
