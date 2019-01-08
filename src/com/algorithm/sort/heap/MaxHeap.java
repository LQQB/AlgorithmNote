package com.algorithm.sort.heap;

/**
 * 在堆的有关操作中，需要比较堆中元素的大小，所以Item需要extends Comparable
 * @param <Item>
 */
public class MaxHeap<Item extends Comparable> {

    /**
     *  最大堆中的数据
     */
    protected Item[] data;

    /**
     *  最大堆中元素数量
     */
    protected int count;

    /**
     * 数组容量
     */
    protected int capacity;

    public MaxHeap(int capacity) {
        // 不能直接声明泛型数组，只能先声明再强制转换
        this.data = (Item[]) new Comparable[capacity];
        count = 0;
        this.capacity = capacity;
    }

}
