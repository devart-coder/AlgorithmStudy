package Algorithms.Grapths;

import java.util.Stack;

import Algorithms.Grapths.Interfaces.Paths;

public class DepthFirstPath implements Paths{
	private boolean[] marked;
	private int[] edgeTo;
	private final int s;
	
	public DepthFirstPath(final Graph g, int s) {
		marked=new boolean[g.getV()];
		edgeTo=new int[g.getV()];
		this.s=s;
		dfs(g,s);
	}
	
	private void dfs(final Graph g, int v) {
		marked[v]=true;
		for(int w : g.getAdj(v)) {
			if(!marked[w]) {
				edgeTo[w]=v;
				dfs(g,w);
			}
		}
		
	}

	@Override
	public boolean hasPathTo(int v) {
		return marked[v];
	}

	@Override
	public Iterable<Integer> pathTo(int v) {
		if(!hasPathTo(v))
			return null;
		var path = new Stack<Integer>();
		for(int i=v; i!= s;i=edgeTo[i])
			path.push(i);
		path.push(s);
		return path;
	}
	
}
