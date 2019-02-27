package com.leetcode;

public class 整数翻转 {
	
	/**
	 * 思路：我们可以一次构建反转整数的一位数字。在这样做的时候，我们可以预先检查向原整数附加另一位数字是否会导致溢出。
	 * 算法：
	 * 1、反转整数的方法可以与反转字符串进行类比。
	 * 2、我们想重复“弹出” x 的最后一位数字，并将它“推入”到 rev 的后面。最后，rev 将与 x 相反。
	 * 3、为了便于解释，我们假设rev是正数：
		 1、如果temp = rev.10+pop导致溢出，那么一定有rev≥INTMAX/10
	     2、如果rev > INTMAX/10,那么temp=rev.10+pop一定会溢出
	     3、如果rev==INTMAX/10，那么只要pop>7，temp=rev.10+pop就会溢出
​	   
		复杂度分析
		时间复杂度：O(log(x))，x 中大约有 log⁡10(x) 位数字。
		空间复杂度：O(1)	
	 */
	public static int reverse(int x) {
		int rev = 0;
		while (x != 0) {
			int pop = x % 10;
			x /= 10;
			//官方给出的溢出判断是因为MAX_VALUE : 2147483647 MIN_VALUE : -2147483648 他要判断最后一位不要大于 7 和 不要小于8
			if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7))
				return 0;
			if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8))
				return 0;
			rev = rev * 10 + pop;
		}
		return rev;
	}

	public static void main(String[] args) {
		reverse(123);
	}

}
