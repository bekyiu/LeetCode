package util.stack_queue;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * 用队列实现栈
 * 
 */
public class QueueStack
{
	private Deque<Integer> dataQueue = new ArrayDeque<>();
	private Deque<Integer> helpQueue = new ArrayDeque<>();
	
	public void push(int num)
	{
		dataQueue.add(num);
	}
	
	public int pop()
	{
		while(dataQueue.size() > 1)
		{
			helpQueue.add(dataQueue.remove());
		}
		
		int result = dataQueue.remove();
		swap();
		return result;
	}
	//交换引用
	public void swap()
	{
		Deque<Integer> temp = dataQueue;
		dataQueue = helpQueue;
		helpQueue = temp;
	}
	public static void main(String[] args)
	{
		QueueStack s = new QueueStack();
		s.push(1);
		s.push(2);
		s.push(3);
		System.out.println(s.pop());
		System.out.println(s.pop());
		s.push(3);
		System.out.println(s.pop());
		System.out.println(s.pop());
	}
}
