package leetcode.zuo.day2.practice1;

import java.util.Arrays;

/**
 * @author JJChen
 * @version 1.0
 */
public class Sort {
    public static void main(String[] args) {
        System.out.println(Comparator());
    }
    public static boolean Comparator(){
        int maxSize = 10;
        int maxValue = 100;
        int testTimes = 500000;
        boolean succeed = true;
        for (int i = 0; i < testTimes; i++) {
            int[] arr1 = generator(maxSize, maxValue);
            int[] arr2 = Arrays.copyOf(arr1, arr1.length);
            System.out.println(Arrays.toString(arr1));
            barrelSort(arr1);
            System.out.println(Arrays.toString(arr1));
            quickSort(arr2);
            if(!Arrays.equals(arr1,arr2)){
                succeed = false;
                break;
            }
        }
        return succeed;
    }
    public static int[] generator(int maxSize, int maxValue){
        int[] arr= new int[(int)((maxSize+1)*Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)((maxValue+1)*Math.random());
        }
        return arr;
     }


    public static void mergeSort(int[] arr){
        if(arr == null || arr.length <2)return;
        mergeSort(arr, 0, arr.length -1 );

    }
    public static void mergeSort(int[] arr, int left, int right){
        if(left == right) return;
        int mid = left + ((right - left) >>1);
        mergeSort(arr, left , mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, right, mid);
    }
    public static void merge(int[] arr, int left, int right , int mid ){
        int[] help = new int[right - left + 1];
        int i = 0;
        int p1 = left;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= right){
            help[i++] = arr[p1] < arr[p2]? arr[p1++]:arr[p2++];
        }
        while (p1<= mid){
            help[i++] = arr[p1++];
        }
        while (p2<=right){
            help[i++] = arr[p2++];
        }
        for ( i = 0; i < help.length; i++) {
            arr[left + i] = help[i];
        }
    }

    public static void heapSort(int[] arr){
        if(arr == null || arr.length < 2)return;
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        int size = arr.length;
        while (size > 0){
            swap(arr, 0, --size);
            heapify(arr, 0, size);
        }
    }

    public static void heapInsert(int[] arr, int index){
        while (arr[index] > arr[(index - 1)/2]){
            swap(arr, index, (index-1)/2);
            index = (index - 1)/ 2;
        }
    }

    public static void heapify(int[] arr, int index, int size){
        int left = 2 * index +1;
        while(left < size){
            left = left + 1<size && arr[left + 1] > arr[left]? left+1:left;
            if(arr[index] > arr[left]){
                break;
            }
            swap(arr, index, left);
            index = left;
            left = 2 * index + 1;
        }
    }
    public static void bubbleSort(int[] arr){
        if(arr == null || arr.length <2) return;
        for (int i = 0; i < arr.length - 1; i++) {
            int count = 0;
            for (int j = 0; j < arr.length - 1 -i; j++) {
                if(arr[j] >= arr[j+1]){
                    swap(arr, j, j+ 1);
                    count++;
                }
            }
            if(count==0){
                break;
            }
        }
    }

    public static void  swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void quickSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        quickSort1(arr, 0, arr.length -1 );

    }
    public static void quickSort1(int[] arr, int start, int end){
        if(start>=end)return;
        int num = arr[start];
        int left = start;
        int right = end;
        while(left < right){
            while(arr[right] >= num && left < right){
                right--;
            }
            arr[left] = arr[right];
            while (arr[left] < num && left < right){
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = num;
        quickSort1(arr, start, left -1);
        quickSort1(arr, left+ 1, end);
    }
    public static void quickSort2(int[] arr, int start, int end){
        if(start >= end) return;
        int num = arr[start];
        int left = start;
        int less = start - 1;
        int more = end + 1;
        while (left < more){
            if(arr[left] > num){
                swap(arr, left, --more);
            }else if (arr[left] < num){
                swap(arr, left++, ++less);
            }else {
                left++;
            }
        }
        quickSort2(arr, start, less);
        quickSort2(arr, left, end);
    }

    public static void barrelSort(int[] arr){
        if(arr == null || arr.length < 2) return;
        int digit = getMaxDigit(arr);
        int[] help = new int[arr.length];
        int d = 0;
        for (int i = 0; i < digit; i++){
            int[] barrels = new int[10];
            for (int j = 0; j < arr.length; j++) {
                d = getDigit(arr[j], i+1);
                barrels[d]++;
            }
            for (int j = 1; j < barrels.length; j++) {
                barrels[j] += barrels[j-1];
            }
            // 从后往前取, 第一次排其实无所谓从前还是从后开始， 但是个位数排好以后，就有了个位数顺序即大的在后面，
            // 此时必须从后开始往前排，因为先排的能占据后面的坑位（十位相同，个位大的在后面），即能继续保持个位数大小的顺序
            for (int j = arr.length-1; j >= 0 ; j--) {
                d = getDigit(arr[j], i + 1);
                help[barrels[d] - 1] = arr[j];
                barrels[d]--;
            }

            for (int j = 0; j < arr.length; j++) {
                arr[j] = help[j];
            }
        }
    }
    public static int getDigit(int num, int d){
        for (int i = 0; i < d -1; i++) {
            num /= 10;
        }
        num %= 10;
        return num;
    }

    public static int getMaxDigit(int[] arr){
        int max = arr[0];
        for (int i = 1; i < arr.length ;i ++){
            max = max > arr[i]? max:arr[i];
        }
        int digit = 0;
        while (max != 0){
            digit++;
            max /= 10;
        }
        return digit;
    }

}
