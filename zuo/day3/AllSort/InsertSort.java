package leetcode.zuo.day3.AllSort;

/**
 * @author JJChen
 * @version 1.0
 */
public class InsertSort extends Sort{
    public InsertSort() {
    }



    @Override
    public void sort() {
        if(arr == null|| arr.length < 2) return;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i+1; j > 0 ; j--) {
                if(arr[j] < arr[j-1]){
                    swap(j, j -1);
                }
            }
        }
    }
}
