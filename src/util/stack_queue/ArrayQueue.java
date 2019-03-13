package util.stack_queue;

import java.util.Arrays;

public class ArrayQueue
{
	private int[] arr;
	//指向将要出队的元素的位置
	private int start;
	//指向新元素要入队的位置
	private int end;
	//队列中一共有对少个元素
	private int size;
	
	public ArrayQueue(int initSize)
	{
		arr = new int[initSize];
		start = 0;
		end = 0;
		size = 0;
	}
	
	public void push(int num)
	{
		if(size == arr.length)
		{
			System.out.println("full");
			return;
		}
		arr[end] = num;
		end = end == arr.length - 1 ? 0 : end + 1;
		size++;
	}
	
	public int poll()
	{
		if(size == 0)
		{
			System.out.println("empty");
			System.exit(0);
		}
		int temp = start;
		size--;
		start = start == arr.length - 1 ? 0 : start + 1;
		return arr[temp];
	}
	
	public String toString()
	{
		return Arrays.toString(arr);
	}
	
	public static void main(String[] args)
	{
		ArrayQueue queue = new ArrayQueue(3);
		queue.push(1);
		queue.push(2);
		queue.push(3);

		System.out.println(queue.poll());
		queue.push(100);
		System.out.println(queue);
		System.out.println(queue.poll());
		System.out.println(queue.poll());
	}
}
