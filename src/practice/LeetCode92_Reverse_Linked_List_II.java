package practice;

import utils.ListNode;

public class LeetCode92_Reverse_Linked_List_II {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) {
            return reverseList(head, right - left);
        }
        ListNode cursor = head;
        for (int i = 1; i < left - 1; i++) {
            cursor = cursor.next;
        }
        cursor.next = reverseList(cursor.next, right - left);
        return head;
    }

    private ListNode reverseList(ListNode head, int count) {
        if (count == 0) {
            return head;
        }
        ListNode cur = head;
        for (int i = 0; i < count; i++) {
            ListNode tmp = cur.next;
            cur.next = tmp.next;
            tmp.next = head;
            head = tmp;
        }
        return head;
    }
}
