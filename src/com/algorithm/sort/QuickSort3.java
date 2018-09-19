package com.algorithm.sort;

import com.algorithm.uitls.SortTestHelper;

/**
 * @author LiQB
 * @Title:
 * @ProjectName AlgorithmNote
 * @Description: TODO
 * @date 2018/9/11 18:01
 */
public class QuickSort3 {

    /**
     * 快速排序-二路快排
     *
     * @param arr
     */
    public static void  quickSort3(int[] arr) {
        __quickSort3(arr, 0, arr.length-1);
    }


    // 三路快速排序
    // 将ar[l ... r] 分为 <5; ==v; >v 三个部分
    // 之后递归对 <v ; >v 两个部分继续进行三路快速排序
    private static void __quickSort3(int[] arr, int l, int r) {

        if(l >= r) return;

        SortTestHelper.exchange( arr, l, (SortTestHelper.ranInt()%(r - l + 1)) + l);
        int v = arr[l];

        int lt = l; // arr[l+1 ... lt] < v
        int gt = r+1; // arr[gt ... r] > v
        int i = l+1;  // arr[lt+1 ... i] == v
        while(i < gt) {
            if (arr[i] < v) {
                SortTestHelper.exchange(arr, i, lt+1);
                lt++;
                i++;
            } else if (arr[i] > v) {
                SortTestHelper.exchange(arr, i, gt-1);
                gt--;
            } else {
                i++;
            }
        }

        SortTestHelper.exchange(arr, l, lt);
        __quickSort3(arr, l, lt-1);
        __quickSort3(arr, gt, r);

    }


    public static void main(String[] args) {

        int n = 100000;
        int[] arr = SortTestHelper.generateRandomArray(n, 0, 10);

//        int[] arr = SortTestHelper.generateNearyOrdereArray(n, 100);
        long startTime = System.currentTimeMillis();
        quickSort3(arr);
        long endTime = System.currentTimeMillis() ;
        System.out.println("程序运行时间：" + (endTime - startTime)/1000.0 + "s");    //输出程序运行时间

        SortTestHelper.printArray(arr);
    }
}
