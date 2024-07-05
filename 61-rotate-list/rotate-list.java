/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0 || head.next == null) return head;
        int n = getLength(head);
        k = k % n;
        if (k == 0) return head;
        ListNode firstNode = getNthNode(head, n - k);
        ListNode lastNode = getNthNode(head, n);
        ListNode result = firstNode.next;
        lastNode.next = head;
        firstNode.next = null;
        return result;
    }

    private ListNode getNthNode(ListNode head, int n) {
        ListNode curr = head;
        int idx = 1;
        while (curr != null) {
            if (idx == n) {
                return curr;
            }
            curr = curr.next;
            idx++;
        }
        return null;
    }

    private int getLength(ListNode head) {
        ListNode curr = head;
        int count = 0;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }
}