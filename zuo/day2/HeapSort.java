package leetcode.zuo.day2;

import java.util.Arrays;

import static leetcode.zuo.day1.practice2.ArraySort.SelectionSort;

/**
 * @author JJChen
 * @version 1.0
 */
public class HeapSort {
    public static void main(String[] args) {
        System.out.println(duiShuQi());
    }

    public static void heapSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr,i);
        }
//        int size = arr.length;
//        swap(arr, 0, --size);
//        while (size > 0) {
//            heapify(arr, 0, size);
//            swap(arr, 0, --size);
//        }
        int size = arr.length;

        while (size > 0){
            swap(arr, 0, --size);
            heapify(arr, 0, size);
        }
    }

    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void heapify(int[] arr, int index, int size) {
        int left = index * 2 + 1;
        while (left < size){
            int largest = left+1 <size&&arr[left+1]>arr[left]?left+1:left;
            if(arr[index] > arr[largest]){
                break;
            }
            swap(arr, index, largest);
            index = largest;
            left = index * 2 + 1;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static boolean duiShuQi() {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = Arrays.copyOf(arr1, arr1.length);
            SelectionSort(arr1);

            heapSort(arr2);


            if (!Arrays.equals(arr1, arr2)) {
                succeed = false;
                return succeed;
            }
        }
        return succeed;
    }

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random());
        }
        return arr;
    }
}

