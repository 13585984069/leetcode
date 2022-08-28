package leetcode.zuo.day3.AllSort;

/**
 * @author JJChen
 * @version 1.0
 */
public class MergeSort extends Sort{
    @Override
    public void sort() {
        if(arr == null || arr.length < 2)return;
        mergeSort(0, arr.length-1);
    }

    public void mergeSort(int left, int right){
        if(left == right) return;
        int mid = left +((right - left) >> 1);
        mergeSort(left, mid);
        mergeSort(mid + 1, right);
        merge(left, right, mid);
    }

    public void  merge(int left, int right, int mid){
        int[] help = new int[right - left + 1];
        int i = 0;
        int p1 = left;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= right){
            help[i++] = arr[p1] <= arr[p2]? arr[p1++]: arr[p2++];
        }
        while (p1 <= mid){
            help[i++] = arr[p1++];
        }
        while (p2 <= right){
            help[i++] = arr[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            arr[left+j] = help[j];
        }
    }

    public MergeSort() {
    }


}
