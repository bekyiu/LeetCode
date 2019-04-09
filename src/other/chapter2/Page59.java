package other.chapter2;

public class Page59
{
	public static void main(String[] args)
	{

	}

	//这种解法左中右内部的顺序是随机的
	public Node listPartition1(Node head, int pivot)
	{
		Node cur = head;
		int size = 0;
		while (cur != null)
		{
			size++;
			cur = cur.next;
		}
		Node[] nodes = new Node[size];
		cur = head;
		for (int i = 0; i < size; i++)
		{
			nodes[i] = cur;
			cur = cur.next;
		}
		partition(nodes, pivot);
		for (int i = 1; i < size; i++)
		{
			nodes[i - 1].next = nodes[i];
		}
		nodes[size - 1].next = null;
		return nodes[0];
	}

	public void partition(Node[] arr, int pivot)
	{
		int small = -1;
		int big = arr.length;
		int index = 0;
		while (index != big)
		{
			if (arr[index].value < pivot)
			{
				swap(arr, index++, ++small);
			} else if (arr[index].value == pivot)
			{
				index++;
			} else
			{
				swap(arr, index, --big);
			}
		}
	}

	public void swap(Node[] arr, int a, int b)
	{
		Node temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	//现在要求左中右内部的顺序和原链表中相对的顺序一样
	//时间复杂度On, 空间复杂度O1
	//思路根据pivot把值分到三个链表中, 最后在串起来
	
	public Node listPartition2(Node head, int pivot)
	{
		Node sH = null; //小于部分的头
		Node sT = null; //小于部分的尾
		Node eH = null; //equal
		Node eT = null;
		Node bH = null; //big
		Node bT = null;
		//保存下一个节点
		Node next = null;
		//把链表中的节点分到三个链表中
		while(head != null)
		{
			next = head.next;
			head.next = null; //把这个节点取下来
			if(head.value < pivot)
			{
				if(sH == null)
				{
					sH = head;
					sT = head;
				}
				else
				{
					sT.next = head;
					sT = sT.next;
				}
			}
			else if(head.value == pivot)
			{
				if(eH == null)
				{
					eH = head;
					eT = head;
				}
				else
				{
					eT.next = head;
					eT = eT.next;
				}
			}
			else
			{
				if(bH == null)
				{
					bH = head;
					bT = head;
				}
				else
				{
					bT.next = head;
					bT = bT.next;
				}
			}
			head = next;
		}
		//将小于部分和等于部分连起来
		if(sT != null)
		{
			sT.next = eH;
			eT = eT == null ? sT : eT;
		}
		//全部连起来
		if(eT != null)
		{
			eT.next = bH;
		}
		return sH != null ? sH : (eH != null ? eH : bH);
		
		
	}
	class Node
	{
		public int value;
		public Node next;

		public Node(int value)
		{
			this.value = value;
		}
	}
}
