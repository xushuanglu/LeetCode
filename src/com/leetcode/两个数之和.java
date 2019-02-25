package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * ����
      �����Ŀ�������������ӣ�����ֻ��Ҫ���������ҵ����������֮�����target��ֵ���ɡ�������������˵�һ���뷨����˫��forѭ����Ҳ��������Ľⷨһ���������ҵķ�ʽ��
 * @author Administrator
 */
public class ������֮�� {

	/**
	 *  �ⷨһ����������
	 *  ��һ�ⷨ�ܼ򵥣�Ҳ�ܷ������ǵ�˼ά��ʽ�����������ڼ������˵�Ͳ���ô�Ѻ��ˡ�����㷨��ʱ�临�Ӷ�ΪO(n2)��
	 *  ��Ȼ��������ͨ�����ԣ���������Ժܴ�����ʱ�Ͳ������ã�����Ӧ�ÿ��Ǹ���Ч�ķ�ʽ��
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] twoSum(int[] nums, int target) {
	    int len = nums.length;
	    for (int i = 0; i < len; i++) {
	        for (int j = i + 1; j < len & j != i; j++) {
	            if (nums[i] + nums[j] == target) {
	            	System.out.println(i);
	            	System.out.println(j);
	                return new int[] { i, j };
	            }
	        }
	    }
	    return null;
	}
	
	/**
	 * �ⷨ����������ϣ��
		���Է��֣���ʹ��������˫��forѭ������Ҫԭ����������֪��ÿ�����ֵ��±꣬���ǲ�֪�����ǵ�ֵ�����鱾����Ǹ����±��ȡֵ���ף������ҽ��ѡ�
		��������ܰ��±��ֵ��Ӧ�������Ϳ��Խ���������һ���⣬���Կ���ʹ�ù�ϣ����ϣ�������ǡǡ���Խ�������ѯ�������⣬�����������´��룺
	 * @param args
	 */
	public static int[] twoSumOptimize(int[] nums,int target) {
		int len = nums.length;
		Map<Integer,Integer> map =new HashMap(len);
		for(int i = 0; i< len; i++) {
			map.put(nums[i], i);
		}
		for(int i = 0; i< len; i++) {
			//��ʱֵ  target=9  nums[i] = 2  0201
			int temp = target - nums[i];
			if(map.containsKey(temp) && map.get(temp) != i) {
				System.out.println(i);
				System.out.println(map.get(temp));
				return new int[] {i,map.get(temp)};
			}
		}
		return null;
	}
	
	
	public static void main(String[] args) {
		int[] nums = {2, 7, 11, 15};
//		twoSum(nums,9);
		twoSumOptimize(nums,9);
	}
}
