package practice;

import utils.ListNode;

public class LeetCode2_Add_Two_Numbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode prevCur = null;
        int temp = 0;
        while (cur1 != null && cur2 != null) {
            cur1.val += cur2.val + temp;
            temp = cur1.val / 10;
            cur1.val = cur1.val % 10;
            prevCur = cur1;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        if (cur1 == null) {
            prevCur.next = cur2;
        }
        while(prevCur.next != null) {
            prevCur.next.val += temp;
            temp = prevCur.next.val / 10;
            prevCur.next.val = prevCur.next.val % 10;
            prevCur = prevCur.next;
        }
        if (temp != 0) {
            prevCur.next = new ListNode(temp);
        }
        return l1;
    }
}
