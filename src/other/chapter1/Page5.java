package other.chapter1;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * 两个栈实现一个队列 实现add poll peek
 */
public class Page5
{
	public static void main(String[] args)
	{
		TwoStackQueue que = new TwoStackQueue();
		que.add(1);
		que.add(2);
		que.add(3);
		System.out.println(que.poll());
		System.out.println(que.poll());
		que.add(10);
		System.out.println(que.poll());
		que.add(5);
		System.out.println(que.poll());
		System.out.println(que.poll());
		System.out.println(que.poll());
	}
}

class TwoStackQueue
{
	private Deque<Integer> stackPush = new ArrayDeque<>();
	private Deque<Integer> stackPop = new ArrayDeque<>();
	
	//把push栈的数据往pop栈中倒
	private void push2pop()
	{
		while(!stackPush.isEmpty())
		{
			stackPop.push(stackPush.pop());
		}
	}
	
	public void add(Integer num)
	{
		stackPush.push(num);
		if(stackPop.isEmpty())
		{
			this.push2pop();
		}
	}
	
	public Integer poll()
	{
		if(stackPop.isEmpty() && stackPush.isEmpty())
		{
			throw new RuntimeException("queue is empty");
		}
		Integer num = stackPop.pop();
		if(stackPop.isEmpty())
		{
			this.push2pop();
		}
		return num;
	}
	
	public Integer peek()
	{
		if(stackPop.isEmpty() && stackPush.isEmpty())
		{
			throw new RuntimeException("queue is empty");
		}
		Integer num = stackPop.peek();
		if(stackPop.isEmpty())
		{
			this.push2pop();
		}
		return num;
	}
}
