/**
 * A:力扣
 * B:两数相加(II)
 * C:栈、链表
 * D:两个数存储在链表中，正序存储
 * E:input 7,5 9 output:8,4
 * F:逆序的时候一定要想到栈！！
 */

import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        Stack<Integer> s1=new Stack<>();
        Stack<Integer> s2=new Stack<>();
        while(l1!=null){
            s1.push(l1.val);
            l1=l1.next;
        }
        while(l2!=null){
            s2.push(l2.val);
            l2=l2.next;
        }
        int carry=0;
        ListNode res=null;
        while(!s1.isEmpty() || !s2.isEmpty() || carry>0 ){
            int r1=s1.isEmpty()?0:s1.pop();
            int r2=s2.isEmpty()?0:s2.pop();
            ListNode now=new ListNode((r1+r2+carry)%10);
            carry=(r1+r2+carry)/10;
            now.next=res;
            res=now;
        }
        return res;

    }
}