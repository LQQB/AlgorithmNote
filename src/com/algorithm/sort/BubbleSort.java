package com.algorithm.sort;

import com.algorithm.uitls.SortTestHelper;

public class BubbleSort {

    public static void bubbleSort(int[] args) {
        for(int i=0;i<args.length-1;i++){
            for(int j=args.length-1;j>i;j--){  //这里从右向左扫描
                if(args[j]<args[j-1]){
                    int temp = args[j];
                    args[j] = args[j-1];
                    args[j-1] = temp;
                }
            }
        }

    }

    public static void main(String[] args) {
        int n =10000;
        int[] arr = SortTestHelper.generateRandomArray(n, 0, n);

        long startTime = System.currentTimeMillis();
        bubbleSort(arr);
        long endTime = System.currentTimeMillis() ;
        System.out.println("程序运行时间：" + (endTime - startTime)/1000.0 + "s");    //输出程序运行时间

        SortTestHelper.printArray(arr);
    }
}
