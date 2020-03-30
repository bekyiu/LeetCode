package util;

import java.util.Arrays;
import java.util.Scanner;

public class Q3
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		// 长度为n的序列
		int n = sc.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		for (int i = 0; i < n; i++)
		{
			a[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++)
		{
			b[i] = sc.nextInt();
		}
		
		int[] res = new int[n * n];
		int index = 0;
		for(int i = 0; i < a.length; i++)
		{
			for(int j = 0; j < b.length; j++)
			{
				res[index++] = a[i] + b[j];
			}
		}
		
		int xor = res[0];
		
		if(res.length == 1)
		{
			System.out.println(xor);
			return;
		}
		
		for(int i = 1; i < res.length; i++)
		{
			xor = xor ^ res[i];
		}
		System.out.println(xor);
	}
}
