package com.leetcode;

public class 整数翻转 {

	    public static int reverse(int x) {
	        int rev = 0;
	        while (x != 0) {
	            int pop = x % 10;
	            x /= 10;
	            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
	            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
	            rev = rev * 10 + pop;
	        }
	        System.out.println(rev);
	        return rev;
	    }
	
	public static void main(String[] args) {
		reverse(123);
	}
	
	/**
	 * 思路：我们可以一次构建反转整数的一位数字。在这样做的时候，我们可以预先检查向原整数附加另一位数字是否会导致溢出。
	 * 算法：
	 * 1、反转整数的方法可以与反转字符串进行类比。
	 * 2、
	 */
}
