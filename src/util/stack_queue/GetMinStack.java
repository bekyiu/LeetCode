package util.stack_queue;

import java.util.ArrayDeque;

/*
 * 实现一个可以随时返回栈内最小元素的栈 O(1)
 */
public class GetMinStack
{
	private ArrayDeque<Integer> dataStack = new ArrayDeque<>();
	private ArrayDeque<Integer> helpStack = new ArrayDeque<>();
	
	public void push(int num)
	{
		if(helpStack.size() == 0)
		{
			helpStack.push(num);
		}
		else
		{
			int min = Math.min(helpStack.peek(), num);
			helpStack.push(min);
		}
		dataStack.push(num);
	}
	
	public int pop()
	{
		helpStack.pop();
		return dataStack.pop();
	}
	
	public int getMin()
	{
		return helpStack.peek();
	}

	@Override
	public String toString()
	{
		return "GetMinStack [dataStack=" + dataStack + ", helpStack=" + helpStack + "]";
	}
	
	public static void main(String[] args)
	{
		GetMinStack s = new GetMinStack();
		s.push(1);
		s.push(2);
		s.push(10);
		s.push(50);
		s.push(0);
		System.out.println(s);
		System.out.println(s.getMin());
	}
}
