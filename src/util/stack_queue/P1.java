package util.stack_queue;

import java.util.Deque;
import java.util.LinkedList;

/*
 * 给定数组arr和整数num, 返回有多少字子数组满足如下情况
 * max(arr[i...j]) - min(arr[i...j]) <= num
 * 要求时间复杂度O(n)
 * 
 * 思路:
 *  如果一个子数组L到R达标 则他内部的子数组一定达标
	如果一个子数组L到R不达标, 则这LR扩大一定不达标
	
	一开始LR都指向0, 然后R往右扩, 一直扩到再往右多扩一下就不达标了的这个位置
	可以根据窗口内最大值的更新结构可以求出最大值 同理求出最小值, 这样就可判断是否达标
	比如R扩到x位置, 那么以0开头的达标的子数组一共就有x + 1个
	因为0到x达标, 所以0到x内的所有子数组达标, 而这之中的子数组以0开头的就有x + 1个
	为什么不可能更多? 因为R扩到x + 1位置LR就不达标了所以以0开头 x + 1结尾的数组是不达标的, 而再扩也一定不会达标
	所以以0开头达标的数组就找到了x + 1个
	然后, L缩一个, 这导致了R也许还能向右括 因为可能是弹出去一个最小的, 所以再加入一个比最大还大的数也可能可以
	所以R继续向右括一直扩到再往右多扩一下就不达标了的这个位置, 譬如y
	那么以1开头的达标数组一共就有y个
	以此类推...直到把 以每个数开头的达标子数组的个数全部的得到
 */
public class P1
{
	
	public static Integer fun(int[] arr, int num)
	{
		int L = 0;
		int R = 0;
		int res = 0;
		Deque<Integer> qmax = new LinkedList<>();
		Deque<Integer> qmin = new LinkedList<>();
		while(L < arr.length)
		{
			while(R < arr.length)
			{
				//窗口最大值
				while(!qmax.isEmpty() && qmax.peekLast() <= arr[R])
				{
					qmax.pollLast();
				}
				qmax.addLast(R);
				//窗口最小值
				while(!qmin.isEmpty() && qmin.peekLast() >= arr[R])
				{
					qmin.pollLast();
				}
				qmin.addLast(R);
				//如果不达标
				if(arr[qmax.peekFirst()] - arr[qmin.peek()] > num)
				{
					break;
				}
			}
			//注意, 此时R指向的位置是刚好不达标的那个位置
			
			//判断如果当L缩一个之后, 是否过期
			//注意, 此时L并没缩, 只不过是复用一下变量
			if(qmax.peekFirst() == L)
			{
				qmax.pollFirst();
			}
			if(qmin.peekFirst() == L)
			{
				qmin.pollFirst();
			}
			res += R - L; //x + 1 - 0 = x + 1
			L--; //L缩
		}
		return res;
	}
	
	public static void main(String[] args)
	{
		
	}
}
