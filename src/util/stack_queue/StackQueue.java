package util.stack_queue;
/*
 * 用栈实现队列

 */

import java.util.ArrayDeque;
import java.util.Deque;

public class StackQueue
{
	private Deque<Integer> dataStack = new ArrayDeque<>();
	private Deque<Integer> helpStack = new ArrayDeque<>();
	
	public void push(int num)
	{
		dataStack.push(num);
		reverse();
	}
	
	public int poll()
	{
		if(helpStack.isEmpty() && dataStack.isEmpty())
		{
			System.out.println("empty");
			System.exit(0);
		}
		int result = helpStack.pop();
		reverse();
		return result;
	}
	
	public void reverse()
	{
		if(helpStack.isEmpty())
		{
			while(!dataStack.isEmpty())
			{
				helpStack.push(dataStack.pop());
			}
		}
	}
	public static void main(String[] args)
	{
		StackQueue queue = new StackQueue();
		queue.push(1);
		queue.push(2);
		queue.push(3);
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		queue.push(614);
		queue.push(615);
		queue.push(616);
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
	}
}
