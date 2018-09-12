package com.algorithm.sort;

import com.algorithm.uitls.SortTestHelper;

/**
 * @author LiQB
 * @Title:
 * @ProjectName AlgorithmNote
 * @Description: TODO
 * @date 2018/9/10 11:24
 */
public class MergeSort {


    private static void mergeSort(int[] arr) {
        __mergeSort(arr, 0, arr.length - 1);
    }


    /**
     * 归并排序基本原理:
     *      1. 把 n 个记录看成 n 个长度为 1 的有序子表
     *      2. 进行两两归并是记录关键字有序，得到 n/2 个长度为 2的有序子表
     *      3. 重复 第二步骤，直到所有记录归并成一个长度为 n 的有序表为止。
     * @param args
     */
    public static void __mergeSort(int[] args, int left, int right) {
        if (left >= right) return;

        int center = (right + left) / 2;
        // 对左边数组进行递归
        __mergeSort(args, left, center);
        // 对右边数组进行递归
        __mergeSort(args, center+1, right);
        if (args[center] > args[center+1]) {
            // 合并
            merge(args, left, right, center);
        }

    }

    public static void merge(int[] args, int left, int right, int center) {

        int[] temp = new int[right - left + 1];     // 临时存储数组
        for (int i = left; i <= right; i++)         // 复制需要合并的数组给临时数组
            temp[i-left] = args[i];

        int l1 = left;          // 定义第一段的位置标识
        int l2 = center + 1;    // 定义第二段的位置标识

        for(int k = left; k <= right; k++) {

            if( l1 > center) {              // 当第一段的标识已结束，而第二段还未结束时
                args[k] = temp[l2-left];
                l2++;
            }
            else if(l2 > right) {           // 当第二段的标识已到最后，而第一段还未结束时
                args[k] = temp[l1-left];
                l1++;
            }
            // 对要合并的两段数组的元素进行比较
            else if(temp[l1-left] < temp[l2-left]) {
                args[k] = temp[l1-left];
                l1++;
            }
            else {
                args[k] = temp[l2-left];
                l2++;
            }
        }


//
//        // 扫描第一段和第二段排序，直到有一个扫描结束
//        while (l1 <= center && l2 <= right)
//            temp[k++] = args[l1] < args[l2]? args[l1++] : args[l2++];
//
//        // 若第一段排序还没扫描完，将其全部复制到合并序列
//        while ( l1 <= center)
//            temp[k++] = args[l1++];
//
//        // 若第二段序列还没扫描完，将其全部复制到合并序列
//        while (l2 <= right)
//            temp[k++] = args[l2++];

    }

    public static void main(String[] args) {

        int n = 100000;
        int[] arr = SortTestHelper.generateRandomArray(n, 0, n);
        long startTime = System.currentTimeMillis();
        mergeSort(arr);
        long endTime = System.currentTimeMillis() ;
        System.out.println("程序运行时间：" + (endTime - startTime)/1000.0 + "s");    //输出程序运行时间

        SortTestHelper.printArray(arr);
    }

}
