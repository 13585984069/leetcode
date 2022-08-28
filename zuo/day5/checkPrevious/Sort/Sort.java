package leetcode.zuo.day5.checkPrevious.Sort;


import java.util.Arrays;

/**
 * @author JJChen
 * @version 1.0
 */
public class Sort {
    public static void main(String[] args) {
        System.out.println(isEqual());
    }

    public static boolean isEqual(){
        int maxSize = 100;
        int maxValue = 100;
        int testTime = 500000;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArr(arr1);
            BubbleSort.sort(arr1);
            RadixSort.sort(arr2);
//            System.out.println(Arrays.toString(arr2));
            if(!(checkEqual(arr1, arr2))){
                return false;
            }
        }
        return true;
    }

    public static int[] copyArr(int[] arr){
        int[] copyArr = new int[arr.length];
        for (int i = 0; i < copyArr.length; i++) {
            copyArr[i] = arr[i];
        }
        return copyArr;
    }
    public static boolean checkEqual(int[] arr1, int[] arr2){
        if(arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if(arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }

    public static int[] generateRandomArray(int maxSize, int maxValue){
        int[] arr = new int[(int)((1+maxSize)*Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)((1+maxValue)*Math.random());
        }
        return arr;
    }
}
