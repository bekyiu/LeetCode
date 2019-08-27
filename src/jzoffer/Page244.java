package jzoffer;

public class Page244
{
	public static void main(String[] args)
	{
		Page244 obj = new Page244();
//		System.out.println(obj.solution(16));
		for(int i = 0; i < 1000; i++)
		{
			System.out.println("第" + i + "位: " + obj.solution(i));
		}
	}

	public int solution(int n)
	{
		int count = 0;
		// 第n位数字一定在num中
		int num;
		for (int i = 0; ; i++)
		{
			int w = getW(i);
			count += w;
			// 当前是数字i, count是[0, i]数字位数的总和, 再减一就是索引
			if(count - 1 >= n)
			{
				num = i;
				break;
			}
		}
		// 倒数第k位数(从零开始)就是结果
		int k = count - 1 - n;
		int res = 0;
		while(k >= 0)
		{
			res = num % 10;
			num /= 10;
			k--;
		}
		return res;
	}
	
	// 求一个数有多少位
	public int getW(int k)
	{
		if(k == 0)
		{
			return 1;
		}
		int res = 0;
		while(k != 0)
		{
			k /= 10;
			res++;
		}
		return res;
	}
}
