package Algorithms.Grapth;

import java.util.ArrayList;
import java.util.List;
/* Classic base class for Graph implementation */
public class Grapth {
	private int V;
	private int E;
	private List<List<Integer>> adj;
	public Grapth(int v) {
		V=v;//Vertices
		E=0;//EdgesCounter
		adj=new ArrayList<>(v);
		for(int i=0; i<v; ++i)
			adj.add(new ArrayList<>());
	}
	public int getV() {
		return V;
	}
	public int getE() {
		return E;
	}
	public void addEdge(int v, int w) {
		outOfBoundsCheck(v);
		outOfBoundsCheck(w);
		adj.get(v).add(w);
		adj.get(w).add(v);
		++E;
	}
	public Iterable<Integer> getAdj(int v){
		return adj.get(v);
	}
	private void outOfBoundsCheck(int v) {
		if(v > adj.size())
			throw new ArrayIndexOutOfBoundsException();
	}
}
