package leetcode.zuo.day1.practice1;

import java.util.Arrays;

/**
 * @author JJChen
 * @version 1.0
 */
public class ArraySort {
    public static void main(String[] args) {
        int testTimes = 500000;
        int maxSize =100;
        int maxValue = 100;
        boolean succeed = true;
//        for (int i = 0; i < testTimes; i++) {
//            int[] arr1 = generateArr(maxSize, maxValue);
//            int[] arr2 = Arrays.copyOf(arr1, arr1.length);
////            selectSort(arr1);
//            insertSort(arr1);
//            bubbleSort(arr2);
//            if(!Arrays.equals(arr1,arr2)){
//                succeed = false;
//                break;
//            }
//        }
//        System.out.println(succeed);



    }
    public static int[] generateArr(int size, int value){
        int[] arr = new int[(int)((1+size) *Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)((1+value)*Math.random()-(1+value)*Math.random());
        }
        return arr;
    }
    public static void selectSort(int[] arr){
        if(arr == null || arr.length < 2) return;
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
            if (minIndex != i){
                swap(arr, minIndex, i);
            }
        }
    }
    public static void bubbleSort(int[] arr) {
        if(arr == null || arr.length < 2) return;

        for (int i = 0; i < arr.length - 1; i++) {
            int count = 0;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
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
                if(arr[j] < arr[j -1 ]){
                    swap(arr, j, j -1 );
                }else{
                    break;
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
