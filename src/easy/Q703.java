package easy;

import java.util.PriorityQueue;

// Page366 第k小
public class Q703
{
	// 小根堆
	private PriorityQueue<Integer> q;
	private int k;
	// nums + 1 >= k
	public Q703(int k, int[] nums)
	{
        q = new PriorityQueue<>(k);
        this.k = k;
        if(nums.length > 0)
        {
            for(int i = 0; i < k && i < nums.length; i++)
            {
                q.add(nums[i]);
            }
            for(int i = k; i < nums.length; i++)
            {
                if(nums[i] > q.peek())
                {
                    q.poll();
                    q.add(nums[i]);
                }
            }
        }
	}

	public int add(int val)
	{
        if(q.size() < k) 
        {
            q.add(val);
        }
        else if(val > q.peek())
		{
			q.poll();
			q.add(val);
		}
		return q.peek();
	}
	public static void main(String[] args)
	{
		PriorityQueue<Integer> qq = new PriorityQueue<>(3);
		qq.add(5);
		qq.add(4);
		qq.add(2);
		qq.add(1);
		System.out.println(qq);
	}
}
