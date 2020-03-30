package jzoffer;

import java.util.Arrays;

public class TheCountOfNumToStr
{
	public static void main(String[] args)
	{
		TheCountOfNumToStr obj = new TheCountOfNumToStr();
		System.out.println(obj.solution(12258));
		System.out.println(obj.solution(1321));
		System.out.println(obj.solution(21));
	}
	
	// 12258
	public int solution(int num)
	{
		return p(toArray(num), 0);
	}
	
	// 从start位置开始算, 算到结尾, 一共有几种可能
	public int p(int[] arr, int start)
	{
		if(start == arr.length - 1)
		{
			return 1;
		}
		if(start == arr.length)
		{
//			return 1;
			return g(arr, start - 2, start - 1);
		}
		return p(arr, start + 1) + g(arr, start, start + 1) * p(arr, start + 2);
	}
	// ij可以组合成一个字符
	public int g(int[] arr, int i, int j)
	{
		if(j < arr.length)
		{
			if(arr[i] * 10 + arr[j] <= 25 && arr[i] * 10 + arr[j] >= 10)
			{
				return 1;
			}
		}
		return 0;
	}
	
	public int[] toArray(int num)
	{
		int len = length(num);
		int[] arr = new int[len];
		for(int i = arr.length - 1; i >= 0; i--)
		{
			arr[i] = num % 10;
			num /= 10;
		}
		return arr;
	}
	
	public int length(int num)
	{
		int res = 0;
		while(num != 0)
		{
			num /= 10;
			res++;
		}
		return res;
	}
}
