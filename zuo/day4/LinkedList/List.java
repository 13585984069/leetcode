package leetcode.zuo.day4.LinkedList;

/**
 * @author JJChen
 * @version 1.0
 */
public class List {
    public static ListNode createList(int num){
        if (num == 0) return null;
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for (int i = 1; i < num ; i++) {
            cur.next = new ListNode(i+1);
            cur = cur.next;
        }
        return head;
    }
    public static void printList(ListNode head){
        while (head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static ListNode createList(int[] nums){
        if (nums == null || nums.length == 0) return null;
        ListNode head = new ListNode(nums[0]);
        ListNode cur = head;
        for (int i = 1; i < nums.length; i++) {
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
        }
        return head;
    }
}
