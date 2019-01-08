package com.algorithm.sort;

import com.algorithm.uitls.SortTestHelper;

/**
 * @author LiQB
 * @Title:
 * @ProjectName AlgorithmNote
 * @Description: TODO
 * @date 2018/9/11 18:01
 */
public class QuickSort2 {

    /**
     * 快速排序-二路快排
     *
     * @param arr
     */
    public static void  quickSort2(int[] arr) {
        __quickSort2(arr, 0, arr.length-1);
    }


    // 对 arr[l ... r] 部分进行快速排序
    private static void __quickSort2(int[] arr, int l, int r) {

        if(l >= r) return;

        int p = __partition(arr, l, r);     //
        __quickSort2(arr, l, p-1);   // 递归左侧数组
        __quickSort2(arr, p+1, r);   // 递归右侧数组
    }


    // 对 arr[l ... r] 部分进行 partition 操作
    // 返回 p(基准数), 使得arr[l ... p-1] <= arr[p] ; arr[p+1 .... r] => arr[p]
    private static int __partition(int[] arr, int l, int r) {
        SortTestHelper.exchange( arr, l, (SortTestHelper.ranInt()%(r - l + 1)) + l);

        int v = arr[l];

        // arr[l .... p1] <= v;arr[p+1 .... r] >= v;
        int i = l + 1, j = r;
        while (true) {
            while (i <= r && arr[i] < v) i++;
            while (j >= l+1 && arr[j] > v) j--;
            if ( i > j ) break;
            SortTestHelper.exchange(arr, i, j);
            i++;
            j--;
        }

        SortTestHelper.exchange(arr, l, j);
        return j;
    }





    public static void main(String[] args) {

        int n = 100000;
        int[] arr = SortTestHelper.generateRandomArray(n, 0, 10);

//        int[] arr = SortTestHelper.generateNearyOrdereArray(n, 100);
        long startTime = System.currentTimeMillis();
        quickSort2(arr);
        long endTime = System.currentTimeMillis() ;
        System.out.println("程序运行时间：" + (endTime - startTime)/1000.0 + "s");    //输出程序运行时间

        SortTestHelper.printArray(arr);
    }
}
