class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        int count = 1;
        ListNode curr = head, prev = dummy;
        while (count < left) {
            count++;
            prev = curr;
            curr = curr.next;
        }

        ListNode start = prev, end = curr;
        while (count <= right) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            count++;
        }

        start.next = prev;
        end.next = curr;

        return dummy.next;
    }
}