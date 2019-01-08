package com.algorithm.sort;

import com.algorithm.uitls.SortTestHelper;

public class ShellSort {

    /**
     *  Shell 排序: 先将待排序元素切割成若干个子序列(相隔某个增量的元素组成),分别进行直接插入,
     * 然后依次缩减增量来进行排序,待整个序列中的元素基本有序时,再对全体元素进行一次直接插入排序。
     * @param arr
     */
    public static void shellSort(int[] arr) {
        int i, j, shellIndex;
        int len = arr.length;
        for(shellIndex=len/2 ; shellIndex>0; shellIndex/=2) {

            for (i = shellIndex; i < len; i++)
                for (j = i - shellIndex; j >= 0 && arr[j] > arr[j + shellIndex]; j -= shellIndex)
                    SortTestHelper.exchange(arr, j, j + shellIndex);
        }

    }


    public static void main(String[] args) {
        int n = 10;
        int[] arr = SortTestHelper.generateRandomArray(n, 0, 100);

        long startTime = System.currentTimeMillis();
        shellSort(arr);
        long endTime = System.currentTimeMillis() ;
        System.out.println("程序运行时间：" + (endTime - startTime)/1000.0 + "s");    //输出程序运行时间

        SortTestHelper.printArray(arr);
    }
}
