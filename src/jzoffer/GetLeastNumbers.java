package jzoffer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class GetLeastNumbers
{
	
	public static void main(String[] args)
	{
	}
    public ArrayList<Integer> getLeastNumbers_Solution(int[] input, int k) 
    {
    	ArrayList<Integer> list = new ArrayList<>();
    	if(input == null || input.length == 0 || k <= 0 || k > input.length)
    	{
    		return list;
    	}
    	// 构造大根堆, PriorityQueue默认是小根堆
    	PriorityQueue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>()
		{
			@Override
			public int compare(Integer o1, Integer o2)
			{
				return o2 - o1;
			}
		});
    	for(int i = 0; i < k; i++)
    	{
    		queue.add(input[i]);
    	}
    	for(int i = k; i < input.length; i++)
    	{
    		if(queue.peek() > input[i])
    		{
    			// 直接add queue会扩容
    			queue.poll();
    			queue.add(input[i]);
    		}
    	}
    	while(!queue.isEmpty())
    	{
    		list.add(queue.poll());
    	}
    	return list;
    	
    }
}
