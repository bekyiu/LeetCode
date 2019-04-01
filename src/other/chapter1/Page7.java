package other.chapter1;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * 如何仅用递归函数和栈操作逆序一个栈
 */
public class Page7
{
	public static void main(String[] args)
	{
		Deque<Integer> stack = new ArrayDeque<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		System.out.println(stack);
		reverse(stack);
		System.out.println(stack);
		
	}
	
	//这个递归函数 实现得到并且移除栈底元素
	public static Integer getAndRemoveLastElement(Deque<Integer> stack)
	{
		Integer result = stack.pop();
		if(stack.isEmpty())
		{
			return result;
		}
		Integer num = getAndRemoveLastElement(stack);
		stack.push(result);
		return num;
	}
	
	//这个递归函数实现了栈的逆序
	public static void reverse(Deque<Integer> stack)
	{
		if(stack.isEmpty())
		{
			return;
		}
		//传进去的stack.size()一定大于0
		Integer num = getAndRemoveLastElement(stack);
		reverse(stack);
		stack.push(num);
	}
}
