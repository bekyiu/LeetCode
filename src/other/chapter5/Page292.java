package other.chapter5;

import java.util.ArrayDeque;
import java.util.Deque;

public class Page292
{
	public static void main(String[] args)
	{
		int[] r = value("(9-10*5-(-2-5))/2".toCharArray(), 0);
		System.out.println("========");
		System.out.println(r[0]);
	}
	
	public static int[] value(char[] chs, int i)
	{
		Deque<String> stack = new ArrayDeque<>();
		int pre = 0;
		int[] bra = null;
		while(i < chs.length && chs[i] != ')')
		{
			if(chs[i] >= '0' && chs[i] <= '9')
			{
				pre = pre * 10 + (chs[i++] - '0');
			}
			else if(chs[i] != '(')
			{
				addNum(stack, pre);
				stack.addLast(String.valueOf(chs[i++]));
				pre = 0;
			}
			else
			{
				bra = value(chs, i + 1);
				pre = bra[0];
				i = bra[1] + 1;
			}
		}
		addNum(stack, pre);
		return new int[] {getNum(stack), i};
	}
	
	public static void addNum(Deque<String> stack, int num)
	{
		if(!stack.isEmpty())
		{
			String op = stack.peekLast();
			if(op.equals("*") || op.equals("/"))
			{
				stack.pollLast();
				int num2 = Integer.valueOf(stack.pollLast());
				num = op.equals("*") ? (num * num2) : (num2 / num);
			}
		}
		System.out.println("push: " + num);
		stack.addLast(String.valueOf(num));
	}
	
	public static int getNum(Deque<String> stack)
	{
		int res = 0;
		boolean add = true;
		String cur = null;
		int num = 0;
		while(!stack.isEmpty())
		{
			// 注意是 pollFirst 
			cur = stack.pollFirst();
			System.out.println(cur);
			if(cur.equals("+"))
			{
				add = true;
			}
			else if(cur.equals("-"))
			{
				add = false;
			}
			else
			{
				num = Integer.valueOf(cur);
				res += add ? num : (-num);
			}
		}
		return res;
	}
}
