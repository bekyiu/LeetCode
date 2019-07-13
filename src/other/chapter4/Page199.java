package other.chapter4;

import java.util.HashMap;
import java.util.Map;


public class Page199
{
	public static Map<String, Integer> cache = new HashMap<>();
	public static void main(String[] args)
	{
		long t1 = System.nanoTime();
		int res = fun(new int[] {5, 10, 25, 1}, 2000, 0);
		long t2 = System.nanoTime();
		System.out.println(res + ", time: " + (t2 - t1));
	}
	
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
				int count = fun(arr, aim - arr[start] * i, start + 1);
				cache.put(key, count);
			}
			sum += cache.get(key);
		}
		return sum;
	}
	//
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
