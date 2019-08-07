package other.chapter5;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Page281
{
	public Map<String, List<String>> getNexts(List<String> words)
	{
		Set<String> set = new HashSet<>(words);
		Map<String, List<String>> nexts = new HashMap<>();
		for (int i = 0; i < words.size(); i++)
		{
			nexts.put(words.get(i), getNext(words.get(i), set));
		}
		return nexts;
	}

	// word只要改变一个字母, 可以变成set中的哪写字符串
	public List<String> getNext(String word, Set<String> set)
	{
		char[] chs = word.toCharArray();
		List<String> res = new ArrayList<String>();
		for (char cur = 'a'; cur <= 'z'; cur++)
		{
			for (int i = 0; i < chs.length; i++)
			{
				if (chs[i] != cur)
				{
					char temp = chs[i];
					chs[i] = cur;
					if (set.contains(String.valueOf(chs)))
					{
						res.add(String.valueOf(chs));
					}
					chs[i] = temp;
				}
			}
		}
		return res;
	}

	// 计算其他字符串到start的最短距离
	public Map<String, Integer> getDistance(String start, Map<String, List<String>> nexts)
	{
		Map<String, Integer> dis = new HashMap<>();
		// 记录当前字符串是否被处理过
		Set<String> set = new HashSet<>();
		dis.put(start, 0);
		set.add(start);
		Deque<String> queue = new ArrayDeque<String>();
		queue.add(start);
		while (!queue.isEmpty())
		{
			String cur = queue.poll();
			for (String str : nexts.get(cur))
			{
				if(!set.contains(str)) 
				{
					queue.add(str);
					set.add(str);
					dis.put(str, dis.get(cur) + 1);
				}
			}
		}
		return dis;
	}
	
	// solution 用于存储一条最短路径
	// 每找到一条cur到to的最短路劲就放到res中
	private void getShortestPaths(String cur, String to, Map<String, List<String>> nexts, Map<String, Integer> distances,
			LinkedList<String> solution, List<List<String>> res)
	{
		solution.add(cur);
		if(to.equals(cur)) 
		{
			res.add(new LinkedList<>(solution));
		}
		else
		{
			for (String next : nexts.get(cur))
			{
				// 保证每走一步, 都是在往远处走, 而不是兜圈子(环)
				if(distances.get(next) == distances.get(cur) + 1)
				{
					getShortestPaths(next, to, nexts, distances, solution, res);
				}
			}
		}
		// 取出最后一次走到的节点, 为尝试下一次做准备
		solution.pollLast();
	}
	
	public List<List<String>> findMinPaths(String start, String to, List<String> list)
	{
		// 生成nexts信息, nexts表示list中的每一个字符串, 仅改动一个字符, 可以变成哪些(在list中的)字符串
		list.add(start);
		Map<String, List<String>> nexts = getNexts(list);
		// 有了nexts信息之后, 相当于有了一张图, 用bfs得到每一个字符串到start的最短距离
		Map<String, Integer> distances = getDistance(start, nexts);
		// 求出所有start到to的最短路径, 即是答案
		LinkedList<String> path = new LinkedList<>();
		List<List<String>> res = new ArrayList<>();
		getShortestPaths(start, to, nexts, distances, path, res);
		return res;
	}
}
