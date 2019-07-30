package easy;

public class Q1114
{
    // synchronized 会保证可见性
    private boolean firstFinished;
    private boolean secondFinished;
    private Object lock = new Object();
    
	public void first(Runnable printFirst) throws InterruptedException
	{
		synchronized(lock)
		{
			// printFirst.run() outputs "first". Do not change or remove this line.
			printFirst.run();
			firstFinished = true;
			lock.notifyAll();
		}
	}

	public void second(Runnable printSecond) throws InterruptedException
	{

		synchronized(lock)
		{
			// 这里的while 可以用if代替
			while (!firstFinished)
			{
				lock.wait();
			}
			// printSecond.run() outputs "second". Do not change or remove this line.
			printSecond.run();
			secondFinished = true;
			lock.notifyAll();
		}

	}

	public void third(Runnable printThird) throws InterruptedException
	{

		synchronized(lock)
		{
			// 这里必须要使用while, 而不是if
			// 考虑一种情况, A线程先执行third, 然后等待, 此时B线程执行first, notifyAll之后唤醒了A线程
			// 此时如果使用if的话, 就会继续打印了 出现 first third second的情况
			while (!secondFinished)
			{
				lock.wait();
			}
			// printThird.run() outputs "third". Do not change or remove this line.
			printThird.run();

		}
	}
}
