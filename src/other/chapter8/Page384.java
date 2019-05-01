package other.chapter8;

import java.util.HashMap;
import java.util.Map;

public class Page384
{
	public static void main(String[] args)
	{
		int a = new Page384().maxLength(new int[] {7, 3 ,2, 1, 1, -6, -1, 7}, 7);
		System.out.println(a);
	}
	public int maxLength(int[] arr, int k)
	{
		//key: 累加和, value: 累加和最先出现的位置
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		int sum = 0;
		int len = 0;
		for(int i = 0; i < arr.length; i++)
		{
			sum += arr[i];
			int temp = sum - k;
			if(map.containsKey(temp))
			{
				len = Math.max(len, i - (map.get(temp) + 1) + 1);
			}
			if(!map.containsKey(sum))
			{
				map.put(sum, i);
			}
		}
		return len;
	}
}
