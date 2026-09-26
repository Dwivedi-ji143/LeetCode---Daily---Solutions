class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode temp = head;
        ListNode curr = head.next;

        while (curr != null) {
            if (curr.val != 0) {
                temp.val += curr.val;
            } else {
                if (curr.next == null) {
                    temp.next = null;
                    break;
                }
                temp = temp.next;
                temp.val = 0;
            }
            curr = curr.next;
        }

        return head;
    }
}