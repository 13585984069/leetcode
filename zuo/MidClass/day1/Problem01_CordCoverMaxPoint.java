package leetcode.zuo.MidClass.day1;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author JJChen
 * @version 1.0
 */
public class Problem01_CordCoverMaxPoint {
        //    给定一个有序数组arr，代表数轴上从左到右有n个点arr[0]、arr[1]...arr[n－1]，
        //    给定一个正数L，代表一根长度为L的绳子，求绳子最多能覆盖其中的几个点
    public static void main(String[] args) {
        int[] arr = { 0, 13, 24, 35, 46, 57, 60, 72, 87 };
        int L = 6;

        System.out.println(maxPoint(arr, L));
        System.out.println(maxPoint1(arr, L));
        System.out.println(maxPoint2(arr, L));
    }

    public static int maxPoint2(int[] arr, int len){
        int l = 0;
        int r = 0;
        int res = 1;
        while(r < arr.length){
            if(arr[r] - arr[l] < len){
                r++;
            }else {
                l++;
            }
            res = Math.max(res, r-l);
        }
        return res;
    }


    // 贪心算法
    public static int maxPoint(int[] arr, int L){
        int res = 1;
        for (int i = 0; i < arr.length; i++) {
            int near = nearestIndex(arr, i, arr[i] - L);
            res = Math.max(res, i - near + 1);
        }
        return res;
    }

    public static int nearestIndex(int[] arr, int R, int value){
        int L = 0;
        int mid;
        int index = R;
        while(L <= R){
            mid = (L+R) / 2;
            if(arr[mid] >= value){
                index = mid;
                R = mid - 1;
            }else {
                L = mid + 1;
            }
        }
        return index;
    }

    public static int maxPoint1(int[] arr, int L) {
        int res = 1;
        for (int i = 0; i < arr.length; i++) {
            int nearest = nearestIndex1(arr, i, arr[i] - L);
            res = Math.max(res, i - nearest + 1);
        }
        return res;
    }

    // 在arr[0..R]范围上，找满足>=value的最左位置
    public static int nearestIndex1(int[] arr, int R, int value) {
        int L = 0;
        int index = R;
        while (L < R) {
            int mid = L + ((R - L) >> 1);
            if (arr[mid] >= value) {
                index = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return index;
    }
}
