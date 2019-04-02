package other.chapter2;

//打印两个有序链表的公共部分
//是值相等 不是引用指向同一个Node
public class Page41
{
	public static void main(String[] args)
	{
		
	}
	
	public void printCommonPart(Node head1, Node head2)
	{
		while(head1 != null && head2 != null)
		{
			if(head1.value < head2.value)
			{
				head1 = head1.next;
			}
			else if(head1.value > head2.value)
			{
				head2 = head2.next;
			}
			else
			{
				System.out.println("head1: " + head1.value + ", head2: " + head2.value);
				head1 = head1.next;
				head2 = head2.next;
			}
		}
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
