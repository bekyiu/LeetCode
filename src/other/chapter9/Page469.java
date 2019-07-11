package other.chapter9;

import java.util.HashMap;
import java.util.Map;

// LFU, 笔试遇到基本可以放弃
public class Page469
{
	class Node
	{
		public Integer key;
		public Integer value;
		public Integer times; // 被set和get的次数
		public Node up; // 桶内的双向链表指针
		public Node down;
		public Node(Integer key, Integer value, Integer times)
		{
			this.key = key;
			this.value = value;
			this.times = times;
			up = null;
			down = null;
		}
	}
	
	// 桶
	class NodeList
	{
		// 每个桶都是一个双向链表
		public Node head;
		public Node tail;
		// 桶与桶之间也是双向链表
		public NodeList last;
		public NodeList next;
		
		public NodeList(Node node)
		{
			this.head = node;
			this.tail = node;
		}
		// 新的结点加在桶的头部
		public void addHead(Node newHead)
		{
			newHead.down = head;
			head.up = newHead;
			head = newHead;
		}
		// 判断桶空不空
		public boolean isEmpty()
		{
			return head == null;
		}
		// 删除桶中存在的node结点
		public void deleteNode(Node node)
		{
			// 只有一个结点
			if(head == tail)
			{
				head = null;
				tail = null;
			}
			else // 被删除的节点的位置
			{
				if(node == head)
				{
					head = node.down;
					head.up = null;
				}
				else if(node == tail)
				{
					tail = node.up;
					tail.down = null;
				}
				else
				{
					node.up.down = node.down;
					node.down.up = node.up;
				}
				
			}
			node.down = null;
			node.up = null;
		}
		
	}
	class LFUCache
	{
		private int capacity;
		private int size;
		// get(key) 根据key找到对应的node
		private Map<Integer, Node> records = new HashMap<>();
		// node 在哪个桶里
		private Map<Node, NodeList> heads = new HashMap<>();
		// 指向最左边的桶
		private NodeList headList = null;
		
		public LFUCache(int k)
		{
			capacity = k;
			size = 0;
		}
		/*
		 * removeNodeList刚刚减少了一个node, 那么有可能这个list就没有节点了, 那她就应该消失
		 * 1) 如果桶不为空, 什么都不做 返回false
		 * 2) 如果空, 并且removeNodeList还是最左边的桶, 记得重置headList指针
		 * 3) 如果空, 且不是最左的, 重置removeNodeList左右的指针
		 */
		private boolean modifyHeadList(NodeList removeNodeList)
		{
			if(removeNodeList.isEmpty())
			{
				if(removeNodeList == headList)
				{
					headList = removeNodeList.next;
					if(headList != null)
					{
						headList.last = null;
					}
				}
				else
				{
					removeNodeList.last.next = removeNodeList.next;
					if(removeNodeList.next != null) // removeNodeList可能是最后一个桶
					{
						removeNodeList.next.last = removeNodeList.last;
					}
				}
				return true;
			}
			return false;
		}
		/*
		 * node的次数已经加一了, 现在还在oldNodeList里, 应该把它移到对应的新的List
		 * 
		 */
		private void move(Node node, NodeList oldNodeList)
		{
			oldNodeList.deleteNode(node);
			// preList表示的是新的List的前一个应该是谁
			NodeList preList = modifyHeadList(oldNodeList) ? oldNodeList.last : oldNodeList;
			NodeList nextList = oldNodeList.next;
			// oldNodeList可能是最后一个桶
			if(nextList == null)
			{
				NodeList newList = new NodeList(node);
				if(preList != null)
				{
					preList.next = newList;
				}
				newList.last = preList;
				if(headList == null)
				{
					headList = newList;
				}
				heads.put(node, newList);
			}
			else
			{
				if(nextList.head.times.equals(node.times))
				{
					nextList.addHead(node);
					heads.put(node, nextList);
				}
				else
				{
					// 这个newList应该放在 preList和nextList之间
					NodeList newList = new NodeList(node);
					if(preList != null)
					{
						preList.next = newList;
					}
					newList.last = preList;
					newList.next = nextList;
					nextList.last = newList;
					// 有可能oldNodeList是第一个List, 删完节点过后就没了
					// 所以headList指向了nextList
					if(headList == nextList)
					{
						headList = newList;
					}
					heads.put(node, newList);
				}
			}
		}
		
		public void set(int key, int value)
		{
			if(records.containsKey(key))
			{
				Node node = records.get(key);
				node.value = value;
				node.times++;
				NodeList curList = heads.get(node);
				move(node, curList);
			}
			else
			{
				if(size == capacity)
				{
					Node node = headList.tail;
					headList.deleteNode(node);
					modifyHeadList(headList);
					records.remove(node.key);
					heads.remove(node);
					size--;
				}
				Node node = new Node(key, value , 1);
				if(headList == null)
				{
					headList = new NodeList(node);
				}
				else
				{
					if(headList.head.times.equals(node.times))
					{
						headList.addHead(node);
					}
					else // 如果不等于1, 那么一定比1大
					{
						NodeList newList = new NodeList(node);
						newList.next = headList;
						headList.last = newList;
						headList = newList;
					}
				}
				records.put(key, node);
				heads.put(node, headList);
				size++;
			}
		}
		
		public Integer get(int key)
		{
			if(!records.containsKey(key))
			{
				return null;
			}
			Node node = records.get(key);
			node.times++;
			move(node, heads.get(node));
			return node.value;
		}
	}
}


