package other.chapter9;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
// 思路是用双向链表来表示优先级
public class Page465
{
	public static void main(String[] args)
	{
		LRUCache<String, Integer> cache = new LRUCache<>(3);
		cache.set("A", 1);
		cache.set("B", 1);
		cache.set("C", 1);
		cache.set("D", 1);
		System.out.println(cache.getK2n());
	}
}

class LRUCache<K, V>
{
	@Getter
	private Map<K, Node<V>> k2n = new HashMap<>();
	private Map<Node<V>, K> n2k = new HashMap<>();
	private DoubleLinkedList<V> list = new DoubleLinkedList<V>();
	private int capacity;
	public LRUCache(int capacity)
	{
		this.capacity = capacity;
	}
	
	// 返回value并调整优先级
	public V get(K key)
	{
		if(k2n.containsKey(key))
		{
			Node<V> node = k2n.get(key);
			list.moveNodeToTail(node);
			return node.vaule;
		}
		return null;
	}
	
	// 如果有就修改, 没有就添加, 记得修改优先级
	public void set(K key, V value)
	{
		Node<V> node = null;
		if(k2n.containsKey(key))
		{
			node = k2n.get(key);
			node.vaule = value;
			list.moveNodeToTail(node);
		}
		else
		{
			node = new Node<V>(value);
			k2n.put(key, node);
			n2k.put(node, key);
			list.add(node);
			if(k2n.size() > capacity)
			{
				removeMostUnused();
			}
		}
	}
	
	public void removeMostUnused()
	{
		Node<V> node = list.removeHead();
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
			if(newNode == null)
			{
				return;
			}
			// 说明链表中没有元素
			if(head == null)
			{
				head = newNode;
				tail = newNode;
			}
			else
			{
				tail.next = newNode;
				newNode.last = tail;
				tail = newNode;
			}
		}
		
		// 此时的node默认是一定在链表中的, 把他移动到链表的尾部
		public void moveNodeToTail(Node<V> node)
		{
			if(node == tail)
			{
				return;
			}
			if(node == head)
			{
				head = node.next;
				head.last = null;
			}
			else
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
			if(head == null)
			{
				return null;
			}
			Node<V> temp = head;
			if(head == tail)
			{
				head = null;
				tail = null;
			}
			else
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

