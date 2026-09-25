class Solution {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode temp = head;

        while (temp != null && temp.next != null) {
            int gcd = findGCD(temp.val, temp.next.val);

            ListNode newnode = new ListNode(gcd);
            newnode.next = temp.next;
            temp.next = newnode;

            temp = newnode.next;
        }

        return head;
    }

    public int findGCD(int a, int b) {
        while (b != 0) {
            int rem = a % b;
            a = b;
            b = rem;
        }
        return a;
    }
}