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
				return new int[] {i,map.get(temp)};
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}
	
	/**
	 * 方法三：一遍哈希表
                 事实证明，我们可以一次完成。在进行迭代并将元素插入到表中的同时，我们还会回过头来检查表中是否已经存在当前元素所对应的目标元素。如果它存在，那我们已经找到了对应解，并立即将其返回。
                 
                 复杂度分析：
			时间复杂度：
			O(n),我们只遍历了包含有 n 个元素的列表一次。在表中进行的每次查找只花费 O(1) 的时间。
			空间复杂度：O(n)， 所需的额外空间取决于哈希表中存储的元素数量，该表最多需要存储 n 个元素。
		
	 * @param args
	 */
	public int[] twoSum1(int[] nums, int target) {
	    Map<Integer, Integer> map = new HashMap<>();
	    for (int i = 0; i < nums.length; i++) {
	        int complement = target - nums[i];
	        if (map.containsKey(complement)) {
	            return new int[] { map.get(complement), i };
	        }
	        map.put(nums[i], i);
	    }
	    throw new IllegalArgumentException("No two sum solution");
	}
	
	
	public static void main(String[] args) {
		int[] nums = {2, 7, 11, 15};
		twoSumOptimize(nums,9);
	}
}
