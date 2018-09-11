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


    /**
     * 归并排序基本原理:
     *      1. 把 n 个记录看成 n 个长度为 1 的有序子表
     *      2. 进行两两归并是记录关键字有序，得到 n/2 个长度为 2的有序子表
     *      3. 重复 第二步骤，直到所有记录归并成一个长度为 n 的有序表为止。
     * @param args
     */
    private static void mergeSort(int[] args, int left, int right) {
        if (left >= right) return;
        int center = (right + left) / 2;
        // 对左边数组进行递归
        mergeSort(args, left, center);
        // 对右边数组进行递归
        mergeSort(args, center+1, right);
        // 合并
        merge(args, left, right, center);
    }

    private static void merge(int[] args, int left, int right, int center) {
        int[] temp = new int[args.length];
        int l1 = left;          // 第一段的起始位置
        int l2 = center + 1;    // 第二段的起始位置
        int k = left;

        // 扫描第一段和第二段排序，直到有一个扫描结束
        while (l1 <= center && l2 <= right)
            temp[k++] = args[l1] < args[l2]? args[l1++] : args[l2++];

        // 若第一段排序还没扫描完，将其全部复制到合并序列
        while ( l1 <= center)
            temp[k++] = args[l1++];

        // 若第二段序列还没扫描完，将其全部复制到合并序列
        while (l2 <= right)
            temp[k++] = args[l2++];

        // 将合并序列复制到原始序列中
        for (k= left; k <= right; k++)
            args[k] = temp[k];
    }

    public static void main(String[] args) {

        int n = 10000000;
        int[] arr = SortTestHelper.generateRandomArray(n, 0, n);
        long startTime = System.currentTimeMillis();
        mergeSort(arr, 0, arr.length - 1);
        long endTime = System.currentTimeMillis() ;
        System.out.println("程序运行时间：" + (endTime - startTime)/1000.0 + "s");    //输出程序运行时间

        SortTestHelper.printArray(arr);
    }

}
