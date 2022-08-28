package leetcode.zuo.day1.practice2;

import java.util.Arrays;

/**
 * @author JJChen
 * @version 1.0
 */
public class ArraySort {
    public static void main(String[] args) {
        System.out.println(duiShuQi());
//        int[] arr = {5,3,2,1,7,8,4,15,13,11,12};
//        MergeSort(arr, 0, arr.length -1 );
//        System.out.println(Arrays.toString(arr));
    }

    public static void SelectionSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]){
                    min = j;
                }
            }
            if (min != i){
                swap(arr, i, min);
            }
        }
    }
    public static void insertSort(int[] arr){
        for (int i = 0; i < arr.length - 1 ; i++) {
            for (int j = i + 1; j > 0; j--) {
                if(arr[j] < arr[j-1]){
                    swap(arr, j, j - 1);
                }else {
                    break;
                }
            }
        }
    }

    public static void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length -1 ; i++) {
            int count = 0;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if(arr[j] > arr[j+ 1]){
                    swap(arr,j , j+ 1);
                    count++;
                }
            }
            if(count == 0){
                break;
            }
        }
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static boolean duiShuQi(){
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = Arrays.copyOf(arr1, arr1.length);
            SelectionSort(arr1);

            mergeSort(arr2);


            if (!Arrays.equals(arr1,arr2)){
                succeed = false;
                return succeed;
            }
        }
        return succeed;
    }
    public static int[] generateRandomArray(int maxSize, int maxValue){
        int[] arr = new int[(int)((maxSize + 1)*Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)((maxValue + 1)* Math.random());
        }
        return arr;
    }
    public static void mergeSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        MergeSort(arr, 0 , arr.length -1 );
    }

    public static void MergeSort(int[] arr, int left, int right){
        if(left == right) return;
        int mid = left + ((right - left) >> 1);
        MergeSort(arr, left, mid);
        MergeSort(arr, mid + 1 , right);
        merge(arr, left,right,mid);
    }
    public static void merge(int[] arr, int left, int right, int mid){
        int[] help = new int[right - left + 1];
        int i = 0;
        int p0 = left;
        int p1 = mid + 1;
        while(p0 <= mid && p1 <= right ){
            help[i++] = arr[p0] < arr[p1]? arr[p0++]: arr[p1++];
        }
        while (p0 <= mid){
            help[i++] = arr[p0++];
        }
        while (p1 <= right){
            help[i++] = arr[p1++];
        }
        for (i = 0; i < help.length ;i++){
            arr[left++] = help[i];
        }
    }
}
