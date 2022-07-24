package practice;

import utils.ListNode;

public class LeetCode86_Partition_List {
    public ListNode partition(ListNode head, int x) {
        ListNode helperHead = new ListNode();
        helperHead.next = head;
        ListNode cur1 = helperHead;
        ListNode newHead = new ListNode();
        ListNode cur2 = newHead;
        while (cur1.next != null) {
            if (cur1.next.val < x) {
                cur1 = cur1.next;
            }
            else {
                cur2.next = cur1.next;
                cur1.next = cur1.next.next;
                cur2 = cur2.next;
                cur2.next = null;
            }
        }
        cur1.next = newHead.next;
        return helperHead.next;
    }
}
