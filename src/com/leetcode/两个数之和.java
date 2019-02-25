package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 解析
      这个题目看起来并不复杂，我们只需要在数组中找到两个数相加之后等于target的值即可。可能我们许多人第一个想法就是双重for循环，也就是下面的解法一：暴力查找的方式。
 * @author Administrator
 */
public class 两个数之和 {

	/**
	 *  解法一：暴力查找
	 *  这一解法很简单，也很符合我们的思维方式，但是它对于计算机来说就不那么友好了。这个算法的时间复杂度为O(n2)，
	 *  虽然用它可以通过测试，但是在面对很大数组时就不再适用，我们应该考虑更高效的方式。
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
	 * 解法二：借力哈希表
		可以发现，促使我们适用双重for循环的主要原因在于我们知道每个数字的下标，但是不知道它们的值，数组本身就是根据下标获取值容易，而查找较难。
		如果我们能把下标和值对应起来，就可以解决数组的这一问题，所以考虑使用哈希表。哈希表的特性恰恰可以解决数组查询慢的问题，于是有了以下代码：
	 * @param args
	 */
	public static int[] twoSumOptimize(int[] nums,int target) {
		int len = nums.length;
		Map<Integer,Integer> map =new HashMap(len);
		for(int i = 0; i< len; i++) {
			map.put(nums[i], i);
		}
		for(int i = 0; i< len; i++) {
			//临时值  target=9  nums[i] = 2  0201
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
