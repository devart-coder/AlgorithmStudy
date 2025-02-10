package Algorithms.Grapths;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstPaths extends DepthFirstPath {
	public BreadthFirstPaths(Graph g, int s) {
		super(g, s);
		bfs(g,s);
	}
	private void bfs(Graph g, int s2) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(s2);
		while(!queue.isEmpty()) {
			int back = queue.poll();
			for(int w : g.getAdj(back)) {
				if(!marked[w]) {
					marked[w]=true;
					edgeTo[w]=back;
					queue.add(w);
				}
			}
		}
		
	}
}
