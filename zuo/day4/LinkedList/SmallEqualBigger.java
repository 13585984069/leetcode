package leetcode.zuo.day4.LinkedList;

/**
 * @author JJChen
 * @version 1.0
 * 【题目】给定一个单链表的头节点head，节点的值类型是整型，再给定一个整数pivot。
 * 实现一个调整链表的函数，将链表调整为左部分都是值小于pivot的节点，中间部分都是值等于pivot的节点，右部分都是值大于pivot的节点。
 * 【进阶】在实现原问题功能的基础上增加如下的要求
 * 【要求】调整后所有小于pivot的节点之间的相对顺序和调整前一样
 * 【要求】调整后所有等于pivot的节点之间的相对顺序和调整前一样
 * 【要求】调整后所有大于pivot的节点之间的相对顺序和调整前一样
 * 【要求】时间复杂度请达到O(N)，额外空间复杂度请达到O(1)。
 */

public class SmallEqualBigger {
    public static void main(String[] args) {
        ListNode head = List.createList(new int[]{5,4,3,2,1,7,1,5,4,8,9,10,3});
        List.printList(head);
        head = partitionGoodMethod(head,5);
        List.printList(head);
    }
    // 用六个变量完成
    public static ListNode partitionGoodMethod(ListNode head, int pivot){
        ListNode sH = null;
        ListNode sT = null;
        ListNode eH = null;
        ListNode eT = null;
        ListNode bH = null;
        ListNode bT = null;
        ListNode cur = head;
        while(cur != null){
            if(cur.val < pivot){
                if(sH == null){
                    sH = cur;
                    sT = cur;
                }else {
                    sT.next = cur;
                    sT = cur;
                }
            }else if(cur.val == pivot){
                if(eH ==null){
                    eH = cur;
                    eT = cur;
                }else {
                    eT.next = cur;
                    eT = cur;
                }
            }else {
                if(bH ==null){
                    bH = cur;
                    bT = cur;
                }else {
                    bT.next = cur;
                    bT = cur;
                }
            }
            cur = cur.next;
        }
        // 连起来
        if(sT != null) {
            sT.next = eH;
            eT = eT == null? sT: eT;
        }
        if(eT != null){
            eT.next = bH;
        }
        if(bT != null){
            bT.next = null;
        }

        return sH != null? sH: eH != null? eH:bH;


    }



    // 基于快排的partition用了额外空间并且还不能保持原有顺序
    public static ListNode partition(ListNode head, int pivot){
        if(head == null || head.next == null) return head;
        ListNode cur = head;
        int count = 0;
        while (cur != null){
            count++;
            cur = cur.next;
        }
        ListNode[] nodes = new ListNode[count];
        cur = head;
        count = 0;
        while (cur != null){
            nodes[count++] = cur;
            cur = cur.next;
        }
        partition(nodes,pivot);
        cur = nodes[0];
        head = cur;
        for (int i = 1; i < nodes.length; i++) {
            cur.next = nodes[i];
            cur = cur.next;
        }
        cur.next = null;
        return head;

    }
    public static void partition(ListNode[] nodes, int pivot){
        int left = 0;
        int less = -1;
        int more = nodes.length;
        while(left < more){
            if(nodes[left].val < pivot){
                swap(nodes, left++, ++less);
            }else if(nodes[left].val > pivot){
                swap(nodes, left, --more);
            }else {
                left++;
            }
        }
    }

    public static void swap(ListNode[] nodes, int i, int j){
        ListNode temp = nodes[i];
        nodes[i] = nodes[j];
        nodes[j] = temp;
    }
}
