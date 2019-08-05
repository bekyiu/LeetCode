package other.chapter5;

import java.util.Arrays;

public class Page265
{
	public static void main(String[] args)
	{
		char[] chas = new char[100];
		chas[0] = 'a';
		chas[1] = ' ';
		chas[2] = 'b';
		chas[3] = ' ';
		Page265.replace(chas);
		System.out.println(Arrays.toString(chas));
	}
	
	public void modify(char[] chas)
	{
		int j = chas.length - 1;
		for(int i = chas.length - 1; i >= 0; i--)
		{
			if(chas[i] != '*')
			{
				chas[j--] = chas[i];
			}
		}
		for(; j >= 0; j--)
		{
			chas[j] = '*';
		}
	}
	
	public static void replace(char[] chas)
	{
		// 左半区的空格数
		int num = 0;
		// 左半区大小
		int len = 0;
		for(len = 0; len < chas.length && chas[len] != 0; len++)
		{
			if(chas[len] == ' ')
			{
				num++;
			}
		}
		// 替换后左半区的大小是 2 * num + len
		int j = len + 2 * num - 1;
		for(int i = len - 1; i >= 0; i--)
		{
			if(chas[i] != ' ')
			{
				chas[j--] = chas[i];
			}
			else
			{
				chas[j--] = '0';
				chas[j--] = '2';
				chas[j--] = '%';
			}
		}
	}
}
