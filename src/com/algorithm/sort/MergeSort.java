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
     *      1. 将数组的每一个元素都当做一个只有一个元素的数组
     *      2. 然后我们将整个数组的每两个元素都当做一个小数组，然后将其两两归并
     *      3. 然后四个四个归并，依次类推，直到最后归并成一个大数组，排序就完成了
     * @param args
     */
    private static void mergeSort(int[] args) {

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
