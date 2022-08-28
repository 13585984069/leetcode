package leetcode.zuo.day3.AllSort;

import java.security.PublicKey;

/**
 * @author JJChen
 * @version 1.0
 */
public class HeapSort extends Sort {
    public HeapSort() {
    }

    @Override
    public void sort() {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 可以用heapInsert
//        for (int i = 0; i < arr.length; i++) {
//            heapInsert(i);
//        }
        // 更快方式
        for(int i = arr.length - 1; i >=0 ; i--){
            heapify(i,arr.length);
        }

        int size = arr.length;
        while (size > 0) {
            swap(0, --size);
            heapify(0,size);
        }
    }


    // 方便后面扩展，加入了index 变量， 不然的话就是0， 一直做堆顶
    public void heapify(int index, int size) {
        int left = index * 2 + 1;
        while (left < size) {
            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
            if (arr[index] > arr[largest]) {
                break;
            }
            swap(index, largest);
            index = largest;
            left = index * 2 + 1;
        }
    }

    public void heapInsert(int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }
}
