package medium;

/**
 * 用dfs染色判断二分图
 * @author Administrator
 *
 */
public class Q785
{
	private boolean[] visited;
	private int[] color;

	public boolean isBipartite(int[][] graph)
	{
		visited = new boolean[graph.length];
		color = new int[graph.length];

		for (int i = 0; i < graph.length; i++)
		{
			color[i] = -1;
		}

		for (int v = 0; v < graph.length; v++)
		{
			if (!visited[v])
			{
				if (!dfs(v, 0, graph))
				{
					return false;
				}
			}
		}
		return true;
	}

	public boolean dfs(int v, int c, int[][] g)
	{
		visited[v] = true;
		color[v] = c;
		for (int i = 0; i < g[v].length; i++)
		{
			int w = g[v][i];
			if (!visited[w])
			{
				if (!dfs(w, c == 0 ? 1 : 0, g))
				{
					return false;
				}
			} 
			else
			{
				if (color[w] == color[v])
				{
					return false;
				}
			}
		}
		return true;
	}
}
