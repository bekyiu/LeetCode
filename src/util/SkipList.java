package util;

import java.util.Random;

/**
 * 作者：pcwl_java 来源：CSDN
 * 原文：https://blog.csdn.net/pcwl1206/article/details/83512600
 * 版权声明：本文为博主原创文章，转载请附上博文链接！
 */
// 跳表中存储的是正整数，并且存储的数据是不重复的
public class SkipList
{
	// 整个跳表最大的层数, random出来最大也就是16
	// 在构造node的时候给next数组都构造成大小为MAX_LEVEL的
	// 就不用考虑突然random出来一个很大的数, 然后扩展head的next数组
	private static final int MAX_LEVEL = 16;

	//整个跳表当前有多少层
	private int levelCount = 1;

	//头, 指向最左侧的node
	private Node head = new Node();

	private Random random = new Random();

	// 查找操作
	// 先往右侧走, 走到走不动了再往下走
	public Node find(int value)
	{
		Node p = head;
		// 从最顶层开始查
		for (int i = levelCount - 1; i >= 0; --i)
		{
			while (p.next[i] != null && p.next[i].data < value)
			{
				p = p.next[i];
			}
		}

		if (p.next[0] != null && p.next[0].data == value)
		{
			return p.next[0]; // 找到，则返回原始链表中的结点
		} 
		else
		{
			return null;
		}
	}

	// 插入操作
	// 先找到每一层待插入位置的前一个node, 放入update[]中, 然后再插入
	public void insert(int value)
	{
		int level = randomLevel();
		Node newNode = new Node();
		newNode.data = value;
		newNode.maxLevel = level; // 通过随机函数改变索引层的结点布置
		Node update[] = new Node[level];
		// 每一层都从左向右开始找
		for (int i = 0; i < level; ++i)
		{
			update[i] = head;
		}

		Node p = head;
		for (int i = level - 1; i >= 0; --i)
		{
			// 向右走走到不能再走
			while (p.next[i] != null && p.next[i].data < value)
			{
				p = p.next[i];
			}
			// 应该在p后面插入, 所以记录下来
			update[i] = p;
		}

		// 遍历update[], 重连指针, 完成插入
		for (int i = 0; i < level; ++i)
		{
			newNode.next[i] = update[i].next[i];
			update[i].next[i] = newNode;
		}
		// 如果当前node的level是最大的, 就要更新整个表的level
		if (levelCount < level)
		{
			levelCount = level;
		}
	}

	// 删除操作
	// 类似于插入操作, 找到每一层待删除节点的前一个node, 记录到update[]中
	public void delete(int value)
	{
		// 从最顶层开始找
		Node[] update = new Node[levelCount];
		Node p = head;
		for (int i = levelCount - 1; i >= 0; --i)
		{
			while (p.next[i] != null && p.next[i].data < value)
			{
				p = p.next[i];
			}
			update[i] = p;
		}

		// 如果找到
		if (p.next[0] != null && p.next[0].data == value)
		{
			for (int i = levelCount - 1; i >= 0; --i)
			{
				// 重连指针, 完成删除操作
				if (update[i].next[i] != null && update[i].next[i].data == value)
				{
					update[i].next[i] = update[i].next[i].next[i];
				}
			}
		}
	}

	// 随机函数, 最大就是MAX_LEVEL
	private int randomLevel()
	{
		int level = 1;
		for (int i = 1; i < MAX_LEVEL; ++i)
		{
			if (random.nextInt() % 2 == 1)
			{
				level++;
			}
		}

		return level;
	}

	// Node内部类
	public class Node
	{
		private int data = -1;
		// 不管这个node是多少层的, 一律赋予MAX_LEVEL, 方便操作
		private Node next[] = new Node[MAX_LEVEL];
		// 当前这个node有多少层
		private int maxLevel = 0;

		// 重写toString方法
		@Override
		public String toString()
		{
			StringBuilder builder = new StringBuilder();
			builder.append("{data:");
			builder.append(data);
			builder.append("; leves: ");
			builder.append(maxLevel);
			builder.append(" }");
			return builder.toString();
		}
	}

	// 显示跳表中的结点
	public void display()
	{
		Node p = head;
		while (p.next[0] != null)
		{
			System.out.println(p.next[0] + " ");
			p = p.next[0];
		}
		System.out.println();
	}
}
