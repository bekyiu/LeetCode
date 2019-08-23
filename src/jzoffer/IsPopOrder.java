package jzoffer;

import java.util.ArrayDeque;
import java.util.Deque;

public class IsPopOrder
{
	public static void main(String[] args)
	{
		IsPopOrder o = new IsPopOrder();
		System.out.println(o.isPopOrder(new int[] {1, 2, 3, 4 ,5}, new int[] {4, 5, 3, 2, 1}));
	}
    public boolean isPopOrder(int [] pushA,int [] popA) 
    {
        int popIndex = 0;
        int pushIndex = 0;
        Deque<Integer> stack = new ArrayDeque<Integer>();
        while(popIndex < popA.length)
        {
        	// 当前期望的出栈值
        	int expectPop = popA[popIndex];
        	// 如果栈为空, 或者栈顶的值不等于期望值
        	while(stack.isEmpty() || stack.peek() != expectPop)
        	{
        		// 就一直push, 知道栈顶是期望值为止
        		if(pushIndex < pushA.length)
        		{
        			stack.push(pushA[pushIndex++]);
        		}
        		else
        		{
        			// 如果所有的值都push完了, 但是栈顶还是不是期望值, 就返回false
        			return false;
        		}
        	}
        	// pop期望值
        	stack.pop();
        	// 下一个期望值
        	popIndex++;
        }
        return true;
    }
}
