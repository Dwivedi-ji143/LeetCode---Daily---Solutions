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
    public int getDecimalValue(ListNode head) {
        String s="";
        int op=0;
        int count=0;
        ListNode current = head;
        while (current != null){
            s += current.val;
            current = current.next; 
        } 
        for (int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)=='1'){
                op=op+(int)Math.pow(2,count);
            }
            count++;
        }
        return op;
    }
}