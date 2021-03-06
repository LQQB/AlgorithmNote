package com.algorithm.sort;

import com.algorithm.uitls.SortTestHelper;

public class SelectionSort {

    /**
     * 选择排序基本思路:
     *      1. 找出数组中最小(大)的元素
     *      2. 将最小(大)的元素跟数组第一个元素交换位置
     *      3. 在剩下的元素中找出最小(大)的元素跟数组第二个交换位置
     *      4. 以此类推，不断重复
     * @param arr
     */
    public static void selectionSort(int[] arr) {
        for (int i = 0; arr.length > i; i++)  {
            // 寻找[i, n)区间里最的最小值
            int minIndex =  i;
            for(int j = i + 1; arr.length > j; j++)
                if(arr[j] < arr[minIndex] ) minIndex = j;

            // 将查询出来的最小元素，跟数组中的i交换位置
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i]=temp;

        }
    }

    public static void main(String[] args) {

        int n = 100000;
        int[] arr = SortTestHelper.generateRandomArray(n, 0, n);

        long startTime = System.currentTimeMillis();
        selectionSort(arr);
        long endTime = System.currentTimeMillis() ;
        System.out.println("程序运行时间：" + (endTime - startTime)/1000.0 + "s");    //输出程序运行时间

        SortTestHelper.printArray(arr);
    }

}
