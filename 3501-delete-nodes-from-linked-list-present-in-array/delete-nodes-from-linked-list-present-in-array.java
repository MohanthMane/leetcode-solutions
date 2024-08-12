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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> toRemove = new HashSet<>();
        for (int num: nums) toRemove.add(num);

        ListNode dummy = new ListNode(0);
        ListNode current = head;
        ListNode prev = dummy;

        while (current != null) {
            if (toRemove.contains(current.val)) {
                current = current.next;
            } else {
                prev.next = new ListNode(current.val);
                prev = prev.next;
                current = current.next;
            }
        }

        return dummy.next;
    }
}