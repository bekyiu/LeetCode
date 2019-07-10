package medium;

import java.util.HashMap;
import java.util.Map;


// Q146
public class LRUCache
{
	private Map<Integer, Node<Integer>> k2n = new HashMap<>();
	private Map<Node<Integer>, Integer> n2k = new HashMap<>();
	private DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
	private int capacity;

	public LRUCache(int capacity)
	{
		this.capacity = capacity;
	}

	public int get(int key)
	{
		if (k2n.containsKey(key))
		{
			Node<Integer> node = k2n.get(key);
			list.moveNodeToTail(node);
			return node.vaule;
		}
		return -1;
	}

	public void put(int key, int value)
	{
		Node<Integer> node = null;
		if (k2n.containsKey(key))
		{
			node = k2n.get(key);
			node.vaule = value;
			list.moveNodeToTail(node);
		} else
		{
			node = new Node<Integer>(value);
			k2n.put(key, node);
			n2k.put(node, key);
			list.add(node);
			if (k2n.size() > capacity)
			{
				removeMostUnused();
			}
		}
	}

	public void removeMostUnused()
	{
		Node<Integer> node = list.removeHead();
		k2n.remove(n2k.get(node));
		n2k.remove(node);
	}

	class DoubleLinkedList<V>
	{
		private Node<V> head;
		private Node<V> tail;

		public DoubleLinkedList()
		{
			head = null;
			tail = null;
		}

		// 在尾部添加节点
		public void add(Node<V> newNode)
		{
			if (newNode == null)
			{
				return;
			}
			// 说明链表中没有元素
			if (head == null)
			{
				head = newNode;
				tail = newNode;
			} else
			{
				tail.next = newNode;
				newNode.last = tail;
				tail = newNode;
			}
		}

		// 此时的node默认是一定在链表中的, 把他移动到链表的尾部
		public void moveNodeToTail(Node<V> node)
		{
			if (node == tail)
			{
				return;
			}
			if (node == head)
			{
				head = node.next;
				head.last = null;
			} else
			{
				node.last.next = node.next;
				node.next.last = node.last;
			}
			node.next = null;
			tail.next = node;
			node.last = tail;
			tail = node;
		}

		// 移除并返回head
		public Node<V> removeHead()
		{
			if (head == null)
			{
				return null;
			}
			Node<V> temp = head;
			if (head == tail)
			{
				head = null;
				tail = null;
			} else
			{
				head = head.next;
				head.last = null;
				temp.next = null;
			}
			return temp;

		}
	}

	class Node<V>
	{
		public V vaule;
		public Node<V> last;
		public Node<V> next;

		public Node(V value)
		{
			this.vaule = value;
			this.last = null;
			this.next = null;
		}
	}
}
