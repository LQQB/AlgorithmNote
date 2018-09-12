package com.algorithm.sort;

import com.algorithm.uitls.SortTestHelper;

/**
 * @author lqqqq
 * @Title:
 * @ProjectName AlgorithmNote
 * @Description: TODO
 * @date 2018/9/1210:42
 */
public class MergeSortBU {

    /**
     * 归并排序 (自底向上) 排序:
     * @param arr
     */
    public static void mergeSortBU(int[] arr) {

        int len = arr.length;
        for(int sz = 1; sz <= len; sz += sz ) {
            for(int i = 0; i + sz < len; i += sz + sz) {
               int right = i + sz + sz -1<= len-1 ? i + sz + sz -1 : len -1;
               // 对 arr[i, ... i+sz-1] 和 arr[i+sz,... i+2*sz-1]
               MergeSort.merge(arr, i, right, i+sz-1 );
            }
        }

    }

    public static void main(String[] args) {
        int n = 100000;
        int[] arr = SortTestHelper.generateRandomArray(n, 0, n);
        long startTime = System.currentTimeMillis();
        mergeSortBU(arr);
        long endTime = System.currentTimeMillis() ;
        System.out.println("程序运行时间：" + (endTime - startTime)/1000.0 + "s");    //输出程序运行时间

        SortTestHelper.printArray(arr);
    }

}
