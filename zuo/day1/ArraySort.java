package leetcode.zuo.day1;

import java.util.Arrays;

/**
 * @author JJChen
 * @version 1.0
 */
public class ArraySort {
    public static void main(String[] args) {
        int[] arr = {3,2,1,5,6,7,1,2,3,8,7,2,11,12,31,13};
//        selectSort(arr);
//        bubbleSort(arr);
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    // 从数组中挑选出最大/最小的数放在前面
    public static void selectSort(int[] arr){
        if (arr == null || arr.length < 2 ) return;
        int minIndex;
        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++){
                if (arr[j] < arr[minIndex]){
                   minIndex = j;
                }
            }
            if ( minIndex != i){
                swap(arr, i, minIndex);
            }
        }
    }
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    //遍历数组，前一个比后一个小或者大就交换
    public static void bubbleSort(int[] arr){
        if (arr == null || arr.length < 2 ) return;
        for (int i = 0; i < arr.length - 1 ; i++) {
            int count = 0;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if(arr[j] > arr[j + 1]){
                    swap(arr, j , j + 1);
                    count++;
                }
            }
            if (count == 0) {
                break;
            }
        }
    }

    public static void insertSort(int[] arr){
        if(arr == null || arr.length < 2) return;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0 ; j--) {
                if (arr[j] < arr[j - 1]){
                    swap(arr, j, j - 1);
                }else {
                    break;
                }
            }
        }
    }


}


