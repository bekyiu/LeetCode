package easy;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Q1114_2
{
	private ReentrantLock lock = new ReentrantLock();
	private Condition c1 = lock.newCondition();
	private Condition c2 = lock.newCondition();
	private Condition c3 = lock.newCondition();
	private int number = 1;

	public static void main(String[] args)
	{
		Q1114_2 obj = new Q1114_2();

		new Thread(() ->
		{
			for (int i = 0; i < 5; i++)
			{
				try
				{
					obj.first(() -> System.out.println("a"));
				} catch (InterruptedException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}).start();

		new Thread(() ->
		{
			for (int i = 0; i < 5; i++)
			{
				try
				{
					obj.second(() -> System.out.println("b"));
				} catch (InterruptedException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();

		new Thread(() ->
		{
			for (int i = 0; i < 5; i++)
			{
				try
				{
					obj.third(() -> System.out.println("c"));
				} catch (InterruptedException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}).start();
	}

	public void first(Runnable printFirst) throws InterruptedException
	{
		lock.lock();
		while (number != 1)
		{
			c1.await();
		}
		// printFirst.run() outputs "first". Do not change or remove this line.
		printFirst.run();
		number = 2;
		c2.signal();
		lock.unlock();
	}

	public void second(Runnable printSecond) throws InterruptedException
	{
		lock.lock();
		while (number != 2)
		{
			c2.await();
		}

		// printSecond.run() outputs "second". Do not change or remove this line.
		printSecond.run();
		number = 3;
		c3.signal();
		lock.unlock();
	}

	public void third(Runnable printThird) throws InterruptedException
	{
		lock.lock();
		while (number != 3)
		{
			c3.await();
		}
		// printThird.run() outputs "third". Do not change or remove this line.
		printThird.run();
		number = 1;
		c1.signal();
		lock.unlock();
	}
}
