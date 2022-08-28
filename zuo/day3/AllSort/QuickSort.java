package leetcode.zuo.day3.AllSort;

/**
 * @author JJChen
 * @version 1.0
 */
public class QuickSort extends Sort{
    public QuickSort() {
    }

    @Override
    public void sort() {
        if(arr == null || arr.length < 2) return;
        quickSortMethod2(0, arr.length - 1);
    }
    public void quickSortMethod2(int start, int end){
        if(start >= end) return;
        int left = start;
        int less = start - 1;
        int more = end;
        int randomIndex = left + (int)((end - start + 1)*Math.random());
        swap(randomIndex, end);
        int num = arr[end];
        while(left < more){
            if(arr[left] > num){
                swap(left, --more);
            }else if(arr[left] < num){
                swap(left++,++less);
            }else {
                left++;
            }
        }
        swap(end, more);
        quickSortMethod2(start, less);
        quickSortMethod2(more+1,end);

    }



    public void quickSortMethod1(int start, int end){
        if(start >= end) return;
        int left =  start;
        int right = end;
        int num = arr[left];
        while (left < right){
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
        quickSortMethod1(start, left -1);
        quickSortMethod1(left+1, end);
    }


}
