package com.leetcode;

import com.leetcode.auxiliary.ListNode;

public class 两个数相加 {

	//ListNode l1  第一列   ListNode l2 第二列
	/*
	 * 第一列： 2 4 3
	 * 第二列： 5 6 4
	 * 结    果： 8 0 7
	 */
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		//定义临时头
	    ListNode dummyHead = new ListNode(0);
	    //进行赋值
	    ListNode p = l1, q = l2, curr = dummyHead;
	    int carry = 0;
	    /*
	     * while (2 4 3 != null || 5 6 4 != null) {
	     * 	int x = 243;
	        int y = 564;
	        int sum = 0 + 243 + 564;
	        carry = 807 / 10;
	        curr.next = new ListNode(80);
	        curr = curr.next;
	        if (p != null) p = p.next;
	        if (q != null) q = q.next;
	     * }
	     */
	    while (p != null || q != null) {
	        int x = (p != null) ? p.val : 0;
	        int y = (q != null) ? q.val : 0;
	        int sum = carry + x + y;
	        carry = sum / 10;
	        curr.next = new ListNode(sum % 10);
	        curr = curr.next;
	        if (p != null) p = p.next;
	        if (q != null) q = q.next;
	    }
	    if (carry > 0) {
	        curr.next = new ListNode(carry);
	    }
	    return dummyHead.next;
	}
	
	public static void main(String[] args) {
		addTwoNumbers(new ListNode(243), new ListNode(564));
	}
	
}
