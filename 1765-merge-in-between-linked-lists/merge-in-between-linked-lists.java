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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int t1=0;
        int t2=0;
        ListNode temp1=list1;
        ListNode temp2=list1;
        while (t1<a-1){
            temp1=temp1.next;
            t1++;
        }
        while(t2<b){
            temp2=temp2.next;
            t2++;
        }
        temp1.next=list2;
        ListNode temp3=list2;
        while(temp3.next != null){
            temp3=temp3.next;
        }
        temp3.next=temp2.next;
        return list1;
    }

}