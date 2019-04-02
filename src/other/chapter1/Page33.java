package other.chapter1;

import java.util.ArrayDeque;
import java.util.Deque;

//可见的山峰对的数量
public class Page33
{
	public static void main(String[] args)
	{
		int[] arr = {4, 2, 4, 5, 3, 4, 5, 2, 3, 5, 4};
		System.out.println(getVisibleNum(arr)); //22
//		int[] arr = {3, 1, 2, 4, 5};
//		System.out.println(getVisibleNumNoRepeat(arr)); //7
	}

	// 如果数组每个元素都不一样, 可以做到O(1)
	public static int getVisibleNumNoRepeat(int[] arr)
	{
		if (arr.length == 0 || arr.length == 1)
		{
			return 0;
		}
		if (arr.length == 2)
		{
			return 1;
		}
		return (arr.length - 2) * 2 + 1;
	}

	// --------------------------进阶问题-----------------------------
	// 如果数组元素可以重复, 单调栈解法O(N)
	public static int getVisibleNum(int[] arr)
	{
		if (arr.length < 2)
		{
			return 0;
		}
		//找出arr中的最大值
		int size = arr.length;
		int maxIndex = 0;
		for(int i = 0; i < size; i++)
		{
			maxIndex = arr[maxIndex] < arr[i] ? i : maxIndex;
		}
		int res = 0;
		Deque<Record> stack = new ArrayDeque<Record>();
		//先把最大值压栈
		stack.push(new Record(arr[maxIndex]));
		int index = getNextIndex(maxIndex, size);
		//从下一个索引开始遍历, 如果遇到maxIndex, 说明遍历完一圈了
		while(index != maxIndex)
		{
			while(stack.peek().value < arr[index])
			{
				//出栈(X, K)
				int k = stack.pop().times;
				res += getInternalSum(k) + 2 * k;
			}
			if(stack.peek().value == arr[index])
			{
				stack.peek().times++;
			}
			else
			{
				stack.push(new Record(arr[index]));
			}
			index = getNextIndex(index, size);
		}
		
		//清算阶段
		//第一阶段
		while(stack.size() > 2)
		{
			int k = stack.pop().times;
			res += getInternalSum(k) + 2 * k;
		}
		//清算第二阶段
		if(stack.size() == 2)
		{
			int k = stack.pop().times;
			if(stack.peek().times == 1)
			{
				res += getInternalSum(k) + k;
			}
			else
			{
				res += getInternalSum(k) + 2 * k;
			}
		}
		//清算第三阶段
		res += getInternalSum(stack.pop().times);
		return res;
	}
	
	public static int getNextIndex(int cur, int size)
	{
		return cur < (size - 1) ? (cur + 1) : 0;
	}
	
	//计算对内的山峰数量
	public static int getInternalSum(int k)
	{
		return k == 1 ? 0 : (k * (k - 1)) / 2;
	}
}

class Record
{
	public int value;
	public int times;

	public Record(int value)
	{
		this.value = value;
		this.times = 1;
	}
}
