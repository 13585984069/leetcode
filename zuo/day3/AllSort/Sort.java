package leetcode.zuo.day3.AllSort;

/**
 * @author JJChen
 * @version 1.0
 */
public abstract class Sort {
    public int[] arr = null;

    public Sort() {
    }

    public Sort(int[] arr) {
        this.arr = arr;
    }
    public void swap(int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    public abstract void sort();
}
