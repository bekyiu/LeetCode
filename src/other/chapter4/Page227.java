package other.chapter4;

import java.util.HashMap;
import java.util.Map;

public class Page227
{
	public static void main(String[] args)
	{
//		int a = new Page227().mostXOR(new int[] {3, 2, 1, 0, 3, 2, 1, 0});
		int a = new Page227().mostXOR(new int[] {6, 3, 2, 1});
		System.out.println(a);
	}
	public int mostXOR(int[] arr)
	{
		//arr[0..i]的异或和
		int xor = 0;
		//key: 异或和, value: 这个异或和上次(最晚)出现的位置
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		//arr[0..i]的最大异或和为0的子数组最多能有dp[i]个
		int[] dp = new int[arr.length];
		xor ^= arr[0];
		dp[0] = arr[0] == 0 ? 1 : 0;
		map.put(xor, 0);
		for(int i = 1; i < arr.length; i++)
		{
			xor ^= arr[i];
			if(map.containsKey(xor))
			{
				int pre = map.get(xor);
				dp[i] = pre == -1 ? 1 : (dp[pre] + 1);
			}
			dp[i] = Math.max(dp[i - 1], dp[i]);
			map.put(xor, i);
		}
		return dp[dp.length - 1];
	}
}
