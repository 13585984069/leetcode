package leetcode.zuo.day4.LinkedList;

/**
 * @author JJChen
 * @version 1.0
 */
public class PrintCommonPartList {
    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(6);
        ListNode head2 = new ListNode(3);
        head2.next = new ListNode(4);
        ListNode node1 = new ListNode(9);
        ListNode node2 = new ListNode(11);
        ListNode node3 = new ListNode(12);
        head.next.next = node2;
        node2.next = node3;
        head2.next.next = node1;
        node1.next = node2;
        List.printList(head);
        List.printList(head2);
        print(head, head2);
    }

    public static void print(ListNode head1, ListNode head2){
        while (head1 != null && head2 != null){
            if(head1.val < head2.val){
                head1 = head1.next;
            }else if(head1.val > head2.val){
                head2 = head2.next;
            }else {
                System.out.print(head1.val + " ");
                head1 = head1.next;
                head2 = head2.next;
            }
        }
    }
}
