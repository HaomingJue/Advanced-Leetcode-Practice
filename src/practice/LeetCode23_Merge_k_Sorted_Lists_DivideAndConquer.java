package practice;

import utils.ListNode;

public class LeetCode23_Merge_k_Sorted_Lists_DivideAndConquer {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        int interval = 1;
        while (interval < lists.length) {
            for (int i = 0; i + interval < lists.length; i += interval*2) {
                mergeTwoLists(lists, i, i + interval);
            }
            interval *= 2;
        }
        return lists[0];
    }

    private void mergeTwoLists(ListNode[] lists, int i, int j) {
        ListNode cur1 = new ListNode();
        ListNode h1 = cur1;
        cur1.next = lists[i];
        ListNode cur2 = lists[j];
        while (cur1.next != null && cur2 != null) {
            if (cur1.next.val < cur2.val) {
                cur1 = cur1.next;
            }
            else {
                ListNode tmp = cur2;
                cur2 = cur2.next;
                tmp.next = cur1.next;
                cur1.next = tmp;

            }
        }
        if (cur2 != null) {
            cur1.next = cur2;
        }
        lists[i] = h1.next;
    }
}
