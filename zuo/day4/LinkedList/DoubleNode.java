package leetcode.zuo.day4.LinkedList;

/**
 * @author JJChen
 * @version 1.0
 */
public class DoubleNode {
    int val;
    DoubleNode next;
    DoubleNode prev;

    public DoubleNode(int val) {
        this.val = val;
    }
    public static DoubleNode createList(int num){
        if (num == 0) return null;
        DoubleNode head = new DoubleNode(1);
        DoubleNode cur = head;
        for (int i = 1; i < num; i++) {
//            DoubleNode node = new DoubleNode(i+1);
            cur.next = new DoubleNode(i+1);
            cur.next.prev = cur;
            cur = cur.next;
        }
        return head;
    }
    public static void printFromHead(DoubleNode head){
        while (head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
    public static void printFromTail(DoubleNode tail){
        while (tail != null){
            System.out.print(tail.val + " ");
            tail = tail.prev;
        }
        System.out.println();
    }

    public static DoubleNode getTail(DoubleNode head){
        while (head.next != null){
            head = head.next;
        }
        return head;
    }
}
