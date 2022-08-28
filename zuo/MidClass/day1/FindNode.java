package leetcode.zuo.MidClass.day1;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * @author JJChen
 * @version 1.0
 */
public class FindNode {
    public static boolean  find (DoubleNode p1, DoubleNode p2){
        if(p1 == null && p2 == null) return  true;

        DoubleNode prev = p1.prev;
        DoubleNode next = p1;
        int i = 0;
        while (next != prev && prev != p1){
            i++;
            if(prev.val != p2.val && next.val != p2.val){
                next = next.next;
                prev = prev.prev;
            }else {
                System.out.println(i);
                return true;
            }
        }

        return prev.val == p2.val || prev.val == p1.val;
    }

    public static void main(String[] args) {
        DoubleNode head = new DoubleNode(1);
//        head.prev = head;
//        head.next = head;
        DoubleNode node2 = new DoubleNode(2);
        DoubleNode node3 = new DoubleNode(3);
        DoubleNode node4 = new DoubleNode(4);
        head.prev = node4;
        head.next = node2;
        node2.prev= head;
        node2.next = node3;
        node3.next =node4;
        node3.prev = node2;
        node4.next = head;
        node4.prev = node3;
        DoubleNode findNode = new DoubleNode(5);
        System.out.println(find(head, findNode));
        HashSet<Integer> map = new HashSet<>();
    }
}
