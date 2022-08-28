package leetcode.AllSolve.LinkedList;

/**
 * @author JJChen
 * @version 1.0
 */
public class ReverseDoubleList {
    public static void main(String[] args) {
        DoubleNode head = new DoubleNode(1);
        DoubleNode node2 = new DoubleNode(2);
        DoubleNode node3 = new DoubleNode(3);
        DoubleNode node4 = new DoubleNode(4);
        DoubleNode node5 = new DoubleNode(5);
        head.next = node2;
        node2.prev = head;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node3.prev = node2;
        node4.prev = node3;
        node5.prev = node4;
        head = reverseDoubleLink(head);
        DoubleNode cur = head;
        while (cur!=null){
            System.out.print(cur.value);
            cur = cur.next;
        }
        System.out.println("\n================");
        cur = node5;
        while (cur != null){
            System.out.print(cur.value);
            cur = cur.prev;
        }
    }

    public static DoubleNode reverseDoubleLink(DoubleNode head){
        DoubleNode prev = null;
        DoubleNode next = null;
        while (head != null){
            next = head.next;
            head.next = prev;
            head.prev = next;
            prev = head;
            head = next;
        }
        return prev;
    }
}
