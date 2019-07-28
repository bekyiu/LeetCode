package other.chapter4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Page210
{
	public static void main(String[] args)
	{
		Page210 obj = new Page210();
		int[] arr = new int[] {2, 1, 5, 3, 6, 4, 8 ,9, 7};
		int[] dp = obj.getdp1(arr);
		
		int[] res = obj.generateLIS(arr, dp);
		System.out.println(Arrays.toString(res));
	}

	public int[] getdp1(int[] arr)
	{
		// dp[i]表示 以arr[i]这个数结尾的的情况下, arr[0..i]中的最大递增子序列的长度
		int[] dp = new int[arr.length];
		dp[0] = 1;
		for (int i = 1; i < dp.length; i++)
		{
			dp[i] = 1;
			for (int j = i - 1; j >= 0; j--)
			{
				if (arr[j] < arr[i])
				{
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		return dp;
	}

	// 根据dp数组生成LIS
	public int[] generateLIS(int[] arr, int[] dp)
	{
		int max = 0;
		int index = 0;
		// 找到dp数组中的最大值以及他的下标
		for (int i = 0; i < dp.length; i++)
		{
			if (dp[i] > max)
			{
				max = dp[i];
				index = i;
			}
		}
		List<Integer> list = new ArrayList<>();
		// 以arr[index]为尾的递增子序列是最长的, 所以他作为LIS的倒数第一个位置
		list.add(0, arr[index]);
		// 检查index位置左边的数, 假设是i位置
		// 如果arr[i]小于倒数第一个数 即arr[index]
		// 并且dp[i] == dp[index] - 1, 则说明arr[i]可以作为倒数第二个数, 以此类推
		for (int i = index - 1; i >= 0; i--)
		{
//			System.out.println("max: " + max + ", index: " + index + ", i: " + i + ", " + "arr[i]: " + arr[i] + ", dp[i]: " + dp[i] + ", dp[index] - 1: " + (dp[index] - 1));
			if (arr[i] < arr[index] && dp[i] == dp[index] - 1)
			{
				list.add(0, arr[i]);
				arr[index] = arr[i];
				index = i;
			}
		}
		Object[] res = list.toArray();
		int[] z = new int[res.length];
		for(int i = 0; i < z.length; i++)
		{
			z[i] = (int)res[i];
		}
		return z;
	}
	
	public int[] getdp2(int[] arr)
	{
		// dp[i]表示 以arr[i]这个数结尾的的情况下, arr[0..i]中的最大递增子序列的长度
		int[] dp = new int[arr.length];
		// ends[l] = arr[i]表示众多长度为l+1的LIS中, 结尾为arr[i]的那一个LIS, 且arr[i]是结尾数最小的那一个 
		// 也就是说以arr[i]结尾的LIS的长度是 l + 1, 即dp[i] = l + 1
		int[] ends = new int[arr.length];
		ends[0] = arr[0];
		dp[0] = 1;
		int l = 0;
		int r = 0;
		int m = 0;
		int right = 0;
		for(int i = 1; i < arr.length; i++)
		{
			// 以二分的方式查找有效区中最左边的比arr[i]大的数
			// 当然可能arr[i]是最大的, 找不到
			l = 0;
			r = right;
			while(l <= r)
			{
				m = (l + r) / 2;
				if(arr[i] > ends[m])
				{
					l = m + 1;
				}
				else
				{
					r = m - 1;
				}
			}
			// 经过上面的查询之后, l要么指向的是有效区中最左边比arr[i]大的数(找到的情况)
			// 要么指向的是right + 1的位置(没有找到的情况)
			right = Math.max(right, l);
			ends[l] = arr[i];
			dp[i] = l + 1;
		}
		return dp;
	}

}
