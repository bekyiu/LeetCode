package other.chapter4;

public class Page245
{
	public static int[] arr = {1000, 70, 100, 5, 60, 100, 200, 300, 2, 1500, 900};
	
	public static void main(String[] args)
	{
		long t1 = System.nanoTime();
		int r1 = win(0, arr.length - 1);
		
		long t2 = System.nanoTime();
		
		int r2 = dpMethod(0, arr.length - 1);
		long t3 = System.nanoTime();
		System.out.println("digui: " + r1 + " " + (t2 - t1));
		System.out.println("dp: " + r2 + " " + (t3 - t2));
	}
	//-------------dp------------------
	public static int dpMethod(int i, int j)
	{
		int[][] dpf = new int[arr.length][arr.length];
		int[][] dps = new int[arr.length][arr.length];
		for(int k = 0; k < dpf.length; k++)
		{
			dpf[k][k] = arr[k];
			dps[k][k] = 0;
		}
		// 从对角线开始往右上角推
		for(int k = 0; k < arr.length - 1; k++)
		{
			for(int m = 0; m < arr.length -1 - k; m++)
			{
				int n = m + 1 + k;
				dpf[m][n] = Math.max(arr[m] + dps[m + 1][n], arr[n] + dps[m][n - 1]);
				dps[m][n] = Math.min(dpf[m + 1][n], dpf[m][n - 1]);
			}
		}
		return Math.max(dpf[i][j], dps[i][j]);
	}
	
	//----------递归方法----------------
	public static int win(int i, int j)
	{
		return Math.max(f(i, j), s(i, j));
	}
	
	public static int f(int i, int j)
	{
		if(i == j)
		{
			return arr[i];
		}
		return Math.max(arr[i] + s(i + 1, j), arr[j] + s(i, j - 1));
	}
	public static int s(int i, int j)
	{
		if(i == j)
		{
			return 0;
		}
		return Math.min(f(i + 1, j), f(i, j - 1));
	}
	
}
