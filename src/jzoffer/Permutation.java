package jzoffer;

import java.util.ArrayList;
import java.util.Collections;

public class Permutation
{
	public static void main(String[] args)
	{
		Permutation p = new Permutation();
		p.p("abc".toCharArray(), 0);
	}

	private ArrayList<String> res = new ArrayList<>();

	public ArrayList<String> permutation(String str)
	{
        if(str == null || str.equals(""))
        {
            return res;
        }
		p(str.toCharArray(), 0);
		// 字典序...
		Collections.sort(res);
		return res;
	}

	// 从start位置开始, 和数组中start位置及其后面的每一个元素进行交换
	// 使得数组中的每一个元素都在start位置出现一次
	public void p(char[] chs, int start)
	{
		if (start == chs.length)
		{
			res.add(new String(chs));
			return;
		}
		for (int i = start; i < chs.length; i++)
		{
			// 去重
			// 在start位置和i位置交换之前, 先判断一下, i位置之后, 是否存在一个位置k
			// 使得chs[k] == chs[i], 如果存在, 就不交换, 因为交换的话必定会重复
			if (isSwap(chs, i))
			{
				swap(chs, i, start);
				p(chs, start + 1);
				swap(chs, i, start);
			}
		}
	}

	public boolean isSwap(char[] arr, int i)
	{
		// 判断在i位置后面是否还有和i位置相等的字符
		for (int j = i + 1; j < arr.length; j++)
		{
			if (arr[i] == arr[j])
			{
				return false;
			}
		}
		return true;
	}

	public void swap(char[] arr, int a, int b)
	{
		char temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
