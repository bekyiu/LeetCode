package util;

import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		// 测试用例的组数
		int n = sc.nextInt();
		Object[][] arr = new Object[n][2];
		for (int i = 0; i < n; i++)
		{

				Integer len = sc.nextInt();
				String str = sc.next();
				arr[i][0] = len;
				arr[i][1] = str;
			
		}
		for (int i = 0; i < n; i++)
		{
			fun((Integer) arr[i][0], (String) arr[i][1]);
			
		}
	}

	public static void fun(Integer len, String str)
	{
		if (len < 11)
		{
			System.out.println("NO");
			return;
		}
		if (len == 11 && !str.startsWith("8"))
		{
			System.out.println("NO");
			return;
		}
		if (len >= 11 && str.startsWith("8"))
		{
			System.out.println("YES");
			return;
		}
		int index = str.indexOf("8");
		if (index == -1)
		{
			System.out.println("NO");
			return;
		}
		str = str.substring(index);
		if (str.length() >= 11)
		{
			System.out.println("YES");
			return;
		}
		System.out.println("NO");
		return;
	}
}
