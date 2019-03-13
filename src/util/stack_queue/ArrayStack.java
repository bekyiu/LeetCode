package util.stack_queue;

public class ArrayStack
{
	private int[] arr = new int[10];
	private int top = 0;
	public ArrayStack(int initSize)
	{
		this.arr = new int[initSize];
	}
	
	public void push(int num) throws Exception
	{
		if(top == arr.length)
		{
			throw new Exception("stackoverflow!");
		}
		arr[top++] = num;
	}
	
	public int pop() throws Exception
	{
		if(top == 0)
		{
			throw new Exception("stack is empty");
		}
		return arr[--top];
	}
	public int peek() throws Exception
	{
		if(top == 0)
		{
			throw new Exception("stack is empty");
		}
		return arr[top - 1];
	}
	
	public static void main(String[] args)
	{
		ArrayStack stack = new ArrayStack(5);
		try
		{
			stack.push(0);
			stack.push(1);
			stack.push(2);
			stack.push(3);
			stack.push(4);
			

			System.out.println(stack.peek());
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}
