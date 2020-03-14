package com.tryout.other.interview.leetCode;

import com.tryout.other.interview.helpers.ListNode;

/**
 * @author: mohit
 * @email: mohit.garg2905@gmail.com
 * @date: 22/6/19
 * @time: 8:01 PM
 */
public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry=0;
        ListNode currNode = null;
        ListNode output = currNode;
        int sum = 0;
        do{
            sum = l1.val + l2.val + carry;
            if(sum>9){
                sum -= 10;
                carry = 1;
            }else{
                carry = 0;
            }
            if(currNode==null) {
                currNode = new ListNode(sum);
                output = currNode;
            }else{
                currNode.next = new ListNode(sum);
                currNode = currNode.next;
            }
            l1=l1.next;
            l2=l2.next;
        }while(l1!=null && l2!=null);

        if(l1!=null){
            do{
                sum = l1.val + carry;
                if(sum>9){
                    sum -=10;
                    carry = 1;
                }else{
                    carry = 0;
                }
                currNode.next = new ListNode(sum);
                currNode = currNode.next;
                l1=l1.next;
            }while(l1!=null);
        }else if(l2!=null){
            do{
                sum = l2.val + carry;
                if(sum>9){
                    sum -=10;
                    carry = 1;
                }else{
                    carry = 0;
                }
                currNode.next = new ListNode(sum);
                currNode = currNode.next;
                l2 = l2.next;
            }while(l2!=null);
        }
        if(carry!=0){
            currNode.next = new ListNode(1);

        }
        return output;
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(7);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        l2.next.next.next = new ListNode(9);

        ListNode output = addTwoNumbers(l1, l2);
        while(output!=null){
            System.out.println(output.val);
            output = output.next;
        }
    }
}
