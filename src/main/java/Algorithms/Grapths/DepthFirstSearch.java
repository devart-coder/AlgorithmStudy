package Algorithms.Grapths;

import Algorithms.Grapths.Interfaces.Search;

public class DepthFirstSearch implements Search {
	private boolean[] marked;
	private int count=0;
	public DepthFirstSearch(Graph g, int s) {
		marked=new boolean[g.getV()];
		dfs(g,s);
	}
	
	private void dfs(Graph g, int s) {
		marked[s]=true;
		++count;
		for(int w:g.getAdj(s)) {
			if(!marked[w])
				dfs(g,w);
		}
	}

	@Override
	public boolean marked(int v) {
		return marked[v];
	}

	@Override
	public int count() {
		return count;
	}
}

