package other.chapter1;

import java.util.ArrayDeque;
import java.util.Deque;

//用一个栈实现另一个栈的排序
public class Page12
{
	public static void main(String[] args)
	{
		Deque<Integer> stack = new ArrayDeque<>();
		stack.push(6);
		stack.push(6);
		stack.push(1);
		stack.push(4);
		stack.push(4);
		System.out.println(stack);
		sortStackByStack(stack);
		System.out.println(stack);
	}
	
	public static void sortStackByStack(Deque<Integer> stack)
	{
		//help stack
		Deque<Integer> help = new ArrayDeque<>();
		while(!stack.isEmpty())
		{
			Integer cur = stack.pop();
			if(help.isEmpty() || cur <= help.peek())
			{
				help.push(cur);
				continue;
			}
			while(!help.isEmpty() && cur > help.peek())
			{
				stack.push(help.pop());
			}
			//记得最后要把当前值放回去
			help.push(cur);
		}
		while(!help.isEmpty())
		{
			stack.push(help.pop());
		}
	}
}

