package util.tree;

//leetcode 208 实现Trie
public class Trie
{
	class Node
	{
		//有多少个字符串经过当前节点
		private int path = 0;
		//有多少个字符串以当前节点结尾
		private int end = 0;
		//假设输入都是a~z, 初始nexts[i] = null
		private Node[] nexts = new Node[26];
	}
    private Node root;

    public Trie() {
    	root = new Node();
    }
    
    public void insert(String word) {
        if(word == null)
        {
        	return;
        }
        Node cur = root;
        char[] chs = word.toCharArray();
        for (int i = 0; i < chs.length; i++)
		{
			int index = chs[i] - 'a';
			if(cur.nexts[index] == null)
			{
				cur.nexts[index] = new Node();
			}
			cur = cur.nexts[index];
			cur.path++;
		}
        cur.end++;
    }
    
    public boolean search(String word) {
        if(word == null)
        {
        	return false;
        }
        Node cur = root;
        char[] chs = word.toCharArray();
        for (int i = 0; i < chs.length; i++)
		{
			int index = chs[i] - 'a';
			if(cur.nexts[index] == null)
			{
				return false;
			}
			cur = cur.nexts[index];
		}
        return cur.end != 0;
    }
    
    public boolean startsWith(String prefix) {
        if(prefix == null)
        {
        	return false;
        }
        Node cur = root;
        char[] chs = prefix.toCharArray();
        for (int i = 0; i < chs.length; i++)
		{
			int index = chs[i] - 'a';
			if(cur.nexts[index] == null)
			{
				return false;
			}
			cur = cur.nexts[index];
		}
        return true;
    }
    
    public void delete(String word) {
    	if(search(word))
    	{
            Node cur = root;
            char[] chs = word.toCharArray();
            for (int i = 0; i < chs.length; i++)
    		{
    			int index = chs[i] - 'a';
    			if(--cur.nexts[index].path == 0)
    			{
    				cur.nexts[index] = null;
    				return;
    			}
    			cur = cur.nexts[index];
    		}
            cur.end--;
    	}
    }
    
    public static void main(String[] args)
	{
		A a = new A();
		System.out.println(a.a);
		++a.a;
		System.out.println(a.a);
	}
    
}

class A
{
	public int a = 10;
}
