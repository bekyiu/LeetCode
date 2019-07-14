package other.chapter4;

public class Page245
{
	public static int[] arr = {70, 100, 5, 60, 100};
	
	public static void main(String[] args)
	{
		System.out.println(win(0, arr.length - 1));
	}
	
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
