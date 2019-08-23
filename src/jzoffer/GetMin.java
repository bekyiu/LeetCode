package jzoffer;

import java.util.ArrayDeque;
import java.util.Deque;

public class GetMin
{
	private Deque<Integer> dataStack = new ArrayDeque<>();
	private Deque<Integer> minStack = new ArrayDeque<>();

	// 压入规则: datastack无脑压
	// minstack为空压, 不为空判断当前要压入的数是不是比minstack的栈顶还小
	// 是的话就压
	public void push(int node)
	{
		dataStack.push(node);
		if (minStack.isEmpty())
		{
			minStack.push(node);
		}
		else
		{
			if (node <= minStack.peek())
			{
				minStack.push(node);
			}
		}
	}
	// 出栈规则, dataStack无脑出
	// 如果pop的数比minstack栈顶大, 就完事, 说明这一次dataStack的pop没有影响到当前栈的最小值
	// 如果等于栈顶, 就把minStack也pop一次, 表示当前栈的最小值出去了
	public void pop()
	{
		Integer num = dataStack.pop();
		if(num == minStack.peek())
		{
			minStack.pop();
		}
	}
	
	// 怪异
	public int top()
	{
		return dataStack.peek();
	}

	public int min()
	{
		return minStack.peek();
	}
}
