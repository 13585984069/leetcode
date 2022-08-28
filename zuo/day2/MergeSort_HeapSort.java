package leetcode.zuo.day2;

import java.util.Arrays;

import static leetcode.zuo.day1.ArraySort.bubbleSort;

/**
 * @author JJChen
 * @version 1.0
 */
public class MergeSort_HeapSort {
    public static void main(String[] args) {
        System.out.println(duiShuQi());
    }

    public static boolean duiShuQi() {
        int maxSize = 100;
        int maxValue = 100;
        int testTimes = 500000;
        boolean succeed = true;
        for (int i = 0; i < testTimes; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
//            int[] arr2 = Arrays.copyOf(arr1,arr1.length);
            int[] arr2 = copyArray(arr1);
//            mergeSort(arr1);
            heapSort(arr1);
//            bubbleSort(arr2);
            quickSort2(arr2, 0, arr2.length -1);
//            System.out.println("===========arr1=============");
//            System.out.println(Arrays.toString(arr1));
//            System.out.println("===========arr2=============");
//            System.out.println(Arrays.toString(arr2));
//            heapSort(arr2);
            succeed = checkArray(arr1, arr2);
//            succeed = Arrays.equals(arr1, arr2);
            if (!succeed) {
                break;
            }
        }
        return succeed;
    }

    public static boolean checkArray(int[] arr1, int[] arr2) {
        boolean same = true;
        for (int i = 0; i < arr1.length; i++) {
            same = arr1[i] == arr2[i];
            if (!same) {
                break;
            }
        }
        return same;
    }

    public static int[] copyArray(int[] arr) {
        int[] arr2 = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr2[i] = arr[i];
        }
        return arr2;
    }


    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((1 + maxValue) * Math.random());
        }
        return arr;
    }

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        mergeSort(arr, 0, arr.length - 1);
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left == right) return;
        int mid = left + ((right - left) >> 1);
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, right, mid);
    }

    public static void merge(int[] arr, int left, int right, int mid) {
        int[] help = new int[right - left + 1];
        int i = 0;
        int p1 = left;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= right) {
            help[i++] = arr[p1] > arr[p2] ? arr[p2++] : arr[p1++];
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= right) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[left + i] = help[i];
        }
    }

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        int size = arr.length;
        swap(arr, 0, --size);
        while (size > 0) {
            heapify(arr, 0, size);
            swap(arr, 0, --size);
        }
    }

    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    // size 是长度
    public static void heapify(int[] arr, int index, int size) {
        int left = index * 2 + 1;
        while (left < size) {
            int largerIndex = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
            if (arr[index] >= arr[largerIndex]) {
                break;
            }
            swap(arr, index, largerIndex);
            index = largerIndex;
            left = index * 2 + 1;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start >= end) return;
        int num = arr[start];
        int left = start;
        int right = end;
        while (left < right) {
            while (num <= arr[right] && left < right) {
                right--;
            }
            arr[left] = arr[right];
            while (num > arr[left] && left < right) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = num;
        quickSort(arr, start, left-1);
        quickSort(arr, left+1, end);
    }

    public static void quickSort2(int[] arr, int start, int end){
        if (start >= end) return;
        int left = start;
        int right = end;
        int num = arr[left];
        int less = left - 1;
        int more = right + 1;
        while (left < more){
            if(arr[left] < num){
                swap(arr, ++less, left++);
            }else if(arr[left] > num){
                swap(arr, --more, left);
            }else {
                left++;
            }
        }
        quickSort2(arr, start, less);
        quickSort2(arr, more, end);

    }
}
