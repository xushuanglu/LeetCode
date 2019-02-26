package com.leetcode;

public class ������ת {

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
	 * ˼·�����ǿ���һ�ι�����ת������һλ���֡�����������ʱ�����ǿ���Ԥ�ȼ����ԭ����������һλ�����Ƿ�ᵼ�������
	 * �㷨��
	 * 1����ת�����ķ��������뷴ת�ַ���������ȡ�
	 * 2��
	 */
}
