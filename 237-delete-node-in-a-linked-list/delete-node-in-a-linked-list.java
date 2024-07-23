/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        // Copy the nextNode val to curr node and delete the next node
        ListNode nextNode = node.next;
        node.val = nextNode.val;
        node.next = node.next.next;
    }
}