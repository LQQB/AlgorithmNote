package com.algorithm.sort;

import com.algorithm.uitls.SortTestHelper;


public class BubbleSort {
    /**
     * 冒泡排序基本思路:
     *      1. 每一趟的比较，都在相邻的两个元素之间，交换也在相邻的两个元素之间,每一趟结束
     *      最后的元素会是最大（小）的数。
     *      2. 针对所有的元素重复以上的步骤，除了最后已经选出的元素（有序）。
     *      3. 重复上面的步骤，直到没有任何一对数字需要比较，则序列最终有序。
     *
     * 优化: 添加了一个标志change，就是在内层的循环一趟比较之后，如果没有发生元素的交换就
     * 说明该序列已经是有序的了，就没有必要再进行外层循环了。
     */
    public static void bubbleSort(int[] args) {

        boolean change = true;
        for(int i=0; i<args.length-1 && change ;i++){
            change = false;
            for(int j=args.length-1;j>i;j--){  //这里从右向左扫描
                if(args[j]<args[j-1]) {
                    int temp = args[j];
                    args[j] = args[j-1];
                    args[j-1] = temp;
                    change = true;  // 当一趟比较之后，如果有元素的交换就把change设置为TRUE
                }
            }
        }

    }

    public static void main(String[] args) {
        int n = 100000;
        int[] arr = SortTestHelper.generateRandomArray(n, 0, n);

        long startTime = System.currentTimeMillis();
        bubbleSort(arr);
        long endTime = System.currentTimeMillis() ;
        System.out.println("程序运行时间：" + (endTime - startTime)/1000.0 + "s");    //输出程序运行时间

        SortTestHelper.printArray(arr);
    }
}
