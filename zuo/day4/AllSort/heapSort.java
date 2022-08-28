package leetcode.zuo.day4.AllSort;

/**
 * @author JJChen
 * @version 1.0
 */
public class heapSort extends Sort {
    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        heapSort01(arr);

//        heapSort01(arr);
    }
    // heapInsert + heapify
    public static void heapSort01(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        int size = arr.length;
        while(size>0){
            swap(arr, 0, --size);
            heapify(arr, 0, size);
        }
    }

    public static void heapSort02(int[] arr){
        for (int i = arr.length - 1; i >= 0 ; i--) {
            heapify(arr, i, arr.length);
        }
        int size = arr.length;
        while(size>0){
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
        while (left < size) {
            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
            if (arr[index] > arr[largest]) {
                break;
            }
            swap(arr, index, largest);
            index = largest;
            left = index * 2 + 1;
        }
    }
}
