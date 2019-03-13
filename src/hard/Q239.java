package hard;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/*
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口 k 内的数字。滑动窗口每次只向右移动一位。
 * 返回滑动窗口最大值。
 * 思路:
 * 准备一个双向队列, 队列中保存的是数组的索引, 这些索引所代表的数都是从大到小有序的
 * 遍历数组, cur指向当前位置
 * 往队列加数的逻辑:
 * 		当往窗口向右扩一个的时候
 * 		如果arr[cur] < arr[deque.last], 加入
 * 		否则, pop deque.last, 然后再看能不能加进去, 如果不能继续poll, 直到队列为空, 把cur加进去 
 * 	队列出数的逻辑:
 * 		当窗口向右缩一个的时候, 那么原来在窗口中最左边的那个值就过期了
 * 		现在去队列中观察队首是否是那个过期的值的索引, 如果是, 就从队首弹出 
 *  窗口内的最大值就是队列中的最大值
 */
public class Q239
{
    public int[] maxSlidingWindow(int[] nums, int k) 
    {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> queue = new LinkedList<>();
        int index = 0;
        for(int cur = 0; cur < nums.length; cur++)
        {
        	while(!queue.isEmpty() && nums[cur] >= nums[queue.peekLast()])
        	{
        		queue.pollLast();
        	}
        	queue.addLast(cur);
        	//cur - k 就是窗口缩小时去掉的那个数的索引
        	if(queue.peekFirst() == cur - k)
        	{
        		//如果cur - k和队首一样, 就弹出
        		//因为队首一定是窗口内最大值, 如果他们相等的话, 因为nums[cur - k]过期了
        		//所以对首的那个值也不能要了
        		//如果不相等, 说明nums[cur - k]不是窗口最大值
        		//因为后面加进去的数比他大, 所以在往队列中加数的时候, 他就被poll了, 所以队列中没有他的索引
        		//自然也就不用处理
        		queue.pollFirst();
        	}
        	if(cur >= k - 1)
        	{
        		res[index++] = nums[queue.peekFirst()];
        	}
        }
        return res;
    }
    public static void main(String[] args)
	{
		int[] a = new int[0];
		System.out.println(Arrays.toString(a));
	}
}
