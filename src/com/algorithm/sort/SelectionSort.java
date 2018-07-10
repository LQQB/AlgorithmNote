package com.algorithm.sort;

import com.algorithm.uitls.SortTestHelper;

public class SelectionSort {

    public static void selectionSort(int[] arr) {
        for (int i = 0; arr.length > i; i++)  {
            // 寻找[i, n)区间里最的最小值
            int minIndex =  i;
            for(int j = i + 1; arr.length > j; j++)
                if(arr[j] < arr[minIndex] ) minIndex = j;

            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i]=temp;

        }
    }

    public static void main(String[] args) {

        int n =10000;
        int[] arr = SortTestHelper.generateRandomArray(n, 0, n);

        long startTime = System.currentTimeMillis();
        selectionSort(arr);
        long endTime = System.currentTimeMillis() ;
        System.out.println("程序运行时间：" + (endTime - startTime)/1000.0 + "s");    //输出程序运行时间

        SortTestHelper.printArray(arr);
    }

}
