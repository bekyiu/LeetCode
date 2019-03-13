package medium;

import java.util.HashMap;
import java.util.Map;

/*
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 * 思路: 用hashmap存节点和节点的拷贝
 */
public class Q138
{
    public RandomListNode copyRandomList(RandomListNode head) 
    {
        if(head == null)
        {
        	return null;
        }
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode cur = head;
        while(cur != null)
        {
        	map.put(cur, new RandomListNode(cur.label));
        	cur = cur.next;
        }
        cur = head;
        while(cur != null)
        {
        	RandomListNode copyNode = map.get(cur);
        	copyNode.next = map.get(cur.next);
        	copyNode.random = map.get(cur.random);
        	cur = cur.next;
        }
        return map.get(head);
    }
    
	public static void main(String[] args)
	{

	}

	class RandomListNode
	{
		int label;
		RandomListNode next, random;

		RandomListNode(int x)
		{
			this.label = x;
		}
	}
}
