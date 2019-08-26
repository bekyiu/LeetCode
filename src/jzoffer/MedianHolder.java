package jzoffer;

import java.util.Comparator;
import java.util.PriorityQueue;
/*
 * 用大根堆存储较小的n / 2个元素
 * 小根堆存储较大的n / 2个元素
 */
public class MedianHolder
{
	private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>()
	{
		@Override
		public int compare(Integer o1, Integer o2)
		{
			return o2 - o1;
		}
	});
	private PriorityQueue<Integer> minHeap = new PriorityQueue<>();

	public void insert(Integer num)
	{
		if(maxHeap.isEmpty() || num <= maxHeap.peek())
		{
			maxHeap.add(num);
		}
		else
		{
			minHeap.add(num);
		}
		balance();
	}

	// 使两个堆size的差值 <= 1
	private void balance()
	{
		if(maxHeap.size() - minHeap.size() > 1)
		{
			minHeap.add(maxHeap.poll());
		}
		if(minHeap.size() - maxHeap.size() > 1)
		{
			maxHeap.add(minHeap.poll());
		}
	}
	
	public Double getMedian()
	{
		if(maxHeap.size() == 0)
		{
			return null;
		}
		if(maxHeap.size() == minHeap.size())
		{
			return (maxHeap.peek() + minHeap.peek()) / 2.0;
		}
		return maxHeap.size() > minHeap.size() ? Double.valueOf(maxHeap.peek()) : Double.valueOf(minHeap.peek());
	}
}
