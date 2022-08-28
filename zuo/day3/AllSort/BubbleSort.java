package leetcode.zuo.day3.AllSort;

/**
 * @author JJChen
 * @version 1.0
 */
public class BubbleSort extends Sort{

    public BubbleSort() {
    }

    public void sort(){
        if(arr == null || arr.length < 2) return;
        for (int i = 0; i < arr.length - 1; i++) {
            int count = 0;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if(arr[j] > arr[j+1]){
                    swap(j, j + 1);
                    count++;
                }
            }
            if(count == 0){
                break;
            }
        }
    }
}
