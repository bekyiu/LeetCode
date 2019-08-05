package other.chapter5;

import java.util.Arrays;

public class Page267
{
	public static void main(String[] args)
	{
		char[] chas = "you are stupid".toCharArray();
		Page267.rotateWord(chas);
//		Page267.reverse(chas, 0, chas.length - 1);
		System.out.println(Arrays.toString(chas));
		String s = "a v c  d";
		System.out.println(Arrays.toString(s.split(" ")));
		System.out.print(" ".trim());
		System.out.print("zzz");
	}
	public static void rotateWord(char[] chas)
	{
		// 先把整个数组逆序
		reverse(chas, 0, chas.length - 1);
		// 再对单词逆序
		int l = 0;
		int r = 0;
		for(int i = 0; i < chas.length; i++)
		{
			if(chas[i] == ' ')
			{
				r = i - 1;
				reverse(chas, l, r);
				l = i + 1;
			}
			if(i + 1 == chas.length)
			{
				reverse(chas, l, i);
			}
		}
	}
	// 对[start, end]上的数组逆序
	public static void reverse(char[] chas, int start, int end)
	{
		int i = start;
		int j = end;
		while(i < j)
		{
			char temp = chas[j];
			chas[j] = chas[i];
			chas[i] = temp;
			i++;
			j--;
		}
	}
}
