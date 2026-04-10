/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        HashMap<ListNode,Integer>mpp=new HashMap<>();
        while(head!=null){
            if(mpp.containsKey(head))
            return true;
            mpp.put(head,1);
            head=head.next;
        }
        return false;

    }
}