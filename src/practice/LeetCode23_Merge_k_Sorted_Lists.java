package practice;

import utils.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LeetCode23_Merge_k_Sorted_Lists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ansHead = new ListNode();
        PriorityQueue<ListNode> pq = new PriorityQueue(new NodeComparator());
        for (int i = 0; i < lists.length; i++) {
            ListNode head = lists[i];
            if (head != null) {
                pq.offer(head);
            }
        }
        ListNode cur = ansHead;
        while(!pq.isEmpty()) {
            ListNode node = pq.poll();
            cur.next = node;
            cur = node;
            if (node.next != null) {
                pq.add(node.next);
            }
        }
        return ansHead.next;
    }

    private class NodeComparator implements Comparator<ListNode> {
        public int compare(ListNode a, ListNode b) {
            return a.val - b.val;
        }
    }
}
