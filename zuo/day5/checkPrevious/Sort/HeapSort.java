package leetcode.zuo.day5.checkPrevious.Sort;

/**
 * @author JJChen
 * @version 1.0
 */
public class HeapSort {
    public static void sort(int[] arr){
        method02(arr);
    }
    public  static void method01(int[] arr){
        if(arr == null || arr.length < 2) return;
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        int size = arr.length;

        while (size > 0){
            SortUtility.swap(arr, 0, --size);
            heapify(arr, 0, size);
        }
    }
    public static void method02(int[] arr){
        if(arr ==null || arr.length < 2) return;
        for (int i = arr.length - 1; i >=0 ; i--) {
            heapify(arr, i ,arr.length);
        }
        int size = arr.length;
        while(size>0){
            SortUtility.swap(arr, 0 ,--size);
            heapify(arr, 0, size);
        }
    }


    public static void heapInsert(int[] arr, int index){
        while(arr[index] > arr[(index - 1)/2]){
            SortUtility.swap(arr, index,(index - 1)/2);
            index = (index -1)/2;
        }
    }
    public static void heapify(int[] arr, int index, int size){
        int left = 2 * index + 1;
        while (left < size){
            int larger = left + 1 < size && arr[left + 1]> arr[left] ? left + 1: left;
            if(arr[larger] < arr[index]){
                break;
            }
            SortUtility.swap(arr, index, larger);
            index = larger;
            left = 2 * index + 1;

        }
    }
}
