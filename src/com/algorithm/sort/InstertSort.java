package com.algorithm.sort;

import com.algorithm.uitls.SortTestHelper;

public class InstertSort {

    /**
     * 插入排序:
     * @param arr
     */
    public static void instertSort(int arr[]) {
        for(int i =1; arr.length > i; i++  ) {

            // 寻找元素arr[i] 合适的插入位置
            int temp = arr[i];
            int j;  //  j保存元素e应该插入的位置
            for(j=i; j>0 && arr[j-1] > temp; j--) {
                arr[j] = arr[j-1];
            }
            arr[j] = temp;

        }
    }

    public static void main(String[] args) {
        int n =10000;
        int[] arr = SortTestHelper.generateRandomArray(n, 0, n);

        long startTime = System.currentTimeMillis();
        instertSort(arr);
        long endTime = System.currentTimeMillis() ;
        System.out.println("程序运行时间：" + (endTime - startTime)/1000.0 + "s");    //输出程序运行时间

        SortTestHelper.printArray(arr);
    }
}
