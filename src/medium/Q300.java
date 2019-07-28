package medium;

public class Q300
{
    public int lengthOfLIS(int[] nums) 
    {
        if(nums == null || nums.length == 0)
        {
            return 0;
        }
        int[] dp = getdp2(nums);
        int max = 0;
		// 找到dp数组中的最大值以及他的下标
		for (int i = 0; i < dp.length; i++)
		{
			max = Math.max(max, dp[i]);
		}
        return max;
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
