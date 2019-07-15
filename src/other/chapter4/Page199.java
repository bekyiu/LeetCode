package other.chapter4;

import java.util.HashMap;
import java.util.Map;


public class Page199
{
	public static Map<String, Integer> cache = new HashMap<>();
	public static void main(String[] args)
	{
		long t1 = System.nanoTime();
		int res = dpMethod(new int[] {5, 10, 25, 1}, 50, 0);
		long t2 = System.nanoTime();
		System.out.println(res + ", time: " + (t2 - t1));
	}
	
	public static int dpMethod(int[] arr, int aim, int start)
	{
		int[][] dp = new int[arr.length + 1][aim + 1];
		dp[arr.length][0] = 1;
		for(int i = arr.length - 1; i >= 0; i--)
		{
			for(int j = 0; j < dp[0].length; j++)
			{
				int sum = 0;
				int k = 0;
				do
				{
					sum += dp[i + 1][j - arr[i] * k];
					k++;
				}while(j - arr[i] * k >= 0);
				dp[i][j] = sum;
			}
		}
		return dp[0][aim];
	}
	
	
	// 记忆搜索
	public static int fun(int[] arr, int aim, int start)
	{
		int sum = 0;
		if(start >= arr.length)
		{
			return aim == 0 ? 1 : 0;
		}
		// i <= aim / arr[start]
		for(int i = 0; i * arr[start] <= aim; i++)
		{
			String key = (start + 1) + "_" + (aim - arr[start] * i);
			if(!cache.containsKey(key))
			{
				cache.put(key, fun(arr, aim - arr[start] * i, start + 1));
			}
			sum += cache.get(key);
		}
		return sum;
	}
	
	// 纯暴力递归
	// 利用从start位置(数组的索引)开始的钱, 凑出aim
	public static int fun0(int[] arr, int aim, int start)
	{
		int sum = 0;
		if(start >= arr.length)
		{
			return aim == 0 ? 1 : 0;
		}
		// i <= aim / arr[start]
		for(int i = 0; i * arr[start] <= aim; i++)
		{
			sum += fun0(arr, aim - arr[start] * i, start + 1);
		}
		return sum;
	}
}
