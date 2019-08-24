package jzoffer;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomListNode
{
	class RandomListNode
	{
		int label;
		RandomListNode next = null;
		RandomListNode random = null;
		RandomListNode(int label)
		{
			this.label = label;
		}
	}
	// 空间复杂O(n)
    public RandomListNode clone(RandomListNode pHead)
    {
    	// key是原来得节点, value是对应拷贝的新节点
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode cur = pHead;
        while(cur != null) 
        {
        	map.put(cur, new RandomListNode(cur.label));
        	cur = cur.next;
        }
        cur = pHead;
        // 通过原来节点的关系可以找到next和random指向的老节点
        // 再把老节点作为key找到对应的拷贝节点
        // 再连接即可
        while(cur != null)
        {
        	RandomListNode nextNode = cur.next;
        	RandomListNode randomNode = cur.random;
        	RandomListNode copyNextNode = map.get(nextNode);
        	RandomListNode copyRandomNode = map.get(randomNode);
        	
        	RandomListNode copyCur = map.get(cur);
        	copyCur.next = copyNextNode;
        	copyCur.random = copyRandomNode;
        	cur = cur.next;
        }
        return map.get(pHead);
    }
    
    // 空间复杂度O(1)
    public RandomListNode clone1(RandomListNode pHead)
    {
    	if(pHead == null)
    	{
    		return null;
    	}
    	
    	RandomListNode cur = pHead;
    	RandomListNode next = null;
    	// copy
    	while(cur != null)
    	{
    		next = cur.next;
    		RandomListNode node = new RandomListNode(cur.label);
    		cur.next = node;
    		node.next = next;
    		cur = next;
    	}
    	// 重连random
    	cur = pHead;
    	while(cur != null)
    	{
    		RandomListNode randomNode = cur.random;
    		cur.next.random = randomNode != null ? randomNode.next : null;
    		cur = cur.next.next;
    	}
    	// 分离
    	cur = pHead;
    	RandomListNode head = pHead.next;
    	RandomListNode curCopy = null;
    	while(cur != null)
    	{
    		next = cur.next.next;
    		curCopy = cur.next;
    		cur.next = next;
    		curCopy.next = next != null ? next.next : null;
    		cur = next;
    	}
    	return head;
    }
}
