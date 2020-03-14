package com.tryout.other.interview.leetCode;

import com.tryout.other.interview.helpers.ListNode;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 *
 * @author: Mohit Garg (mohit.garg2905@gmail.com)
 * @createdAt: 2019-Jul-08 9:27 PM
 */
public class ReverseLinkedList206 {

    public ListNode reverseList(ListNode head) {
        if(head==null)
            return head;
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
