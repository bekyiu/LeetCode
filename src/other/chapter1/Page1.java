package other.chapter1;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * getMin的栈
 */
public class Page1
{
	public static void main(String[] args)
	{
		MyStakc1 stack = new MyStakc1();
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(1);
		stack.push(2);
		stack.push(1);
		//--
		System.out.println(stack.getMin());
		System.out.println(stack.pop());
		System.out.println(stack.getMin());
		System.out.println(stack.pop());
		System.out.println(stack.getMin());
		System.out.println(stack.pop());
		System.out.println(stack.getMin());
	}
}

class MyStakc1
{
	private Deque<Integer> stackData = new ArrayDeque<>();
	private Deque<Integer> stackMin = new ArrayDeque<>();
	
	public void push(Integer num)
	{
		if(stackMin.size() == 0)
		{
			stackData.push(num);
			stackMin.push(num);
			return;
		}
		if(num <= stackMin.peek())
		{
			stackData.push(num);
			stackMin.push(num);
		}
		else
		{
			stackData.push(num);
		}
	}
	
	public Integer pop()
	{
		Integer data = stackData.pop();
		if(data > stackMin.peek())
		{
			return data;
		}
		stackMin.pop();
		return data;
	}
	
	public Integer getMin()
	{
		return stackMin.peek();
	}
}