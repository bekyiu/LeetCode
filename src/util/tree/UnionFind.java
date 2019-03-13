package util.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 并查集
 * 功能1: 现在有若干个集合, 任意给两个元素, 判断这两个元素是否属于同一个集合
 * 功能2: 任意给两个元素, 合并这两个元素所在的集合
 * 实现思路:
 * 		准备两个map, fatherMap的key是当前节点, value是当节点的父节点, 根的父节点指向自己
 * 		sizeMap的key是当前节点, value表示当前节点所在的集合的元素的个数(这个个数只对根结点有效)
 */
//K相当于是Node
public class UnionFind<K>
{
	private Map<K, K> fatherMap;
	private Map<K, Integer> sizeMap;
	
	public UnionFind(List<K> list)
	{
		fatherMap = new HashMap<>();
		sizeMap = new HashMap<>();
		for (K k : list)
		{
			fatherMap.put(k, k); //一开始自己都是根结点
			sizeMap.put(k, 1);	//一开始每个集合都只有一个节点
		}
	}
	
	public K findHead(K node)
	{
		Deque<K> stack = new ArrayDeque<>();
		K cur = node;
		K parent = fatherMap.get(cur);
		while(cur != parent)
		{
			stack.push(cur);
			cur = parent;
			parent = fatherMap.get(cur);
		}
		//优化, 压缩路径
		while(!stack.isEmpty())
		{
			fatherMap.put(stack.pop(), parent);
		}
		return parent;
	}
	
	public boolean isSameSet(K a, K b)
	{
		return findHead(a) == findHead(b);
	}
	
	public void union(K a, K b)
	{
		K aHead = findHead(a);
		K bHead = findHead(b);
		if(aHead != bHead)
		{
			Integer aSize = sizeMap.get(aHead);
			Integer bSize = sizeMap.get(bHead);
			if(aSize <= bSize)
			{
				fatherMap.put(aHead, bHead);
				//只改了根结点b的size, a的size包括a的儿子的size都不用改了
				//因为都用不到了, 每次getSize, 都是get的head的size
				sizeMap.put(bHead, aSize + bSize); 
			}
			else
			{
				fatherMap.put(bHead, aHead);
				sizeMap.put(aHead, aSize + bSize);
			}
		}
	}
//	class Node
//	{
//		
//	}
}