package Algorithms.Collections.BinaryTree;

public class BinaryTree<Key extends Comparable<Key>,Value> {
	private Node root;
	private class Node{
		private Key key;
		private Value value;
		private Node left,right;
		private int N;
		public Node(Key key,Value value,int N) {
			this.key=key;
			this.value=value;
			this.N=N;
		}
	}
	//Size
	public int size() {
		return size(root);
	}
	private int size(Node node) {
		if(node==null)
			return 0;
		else
			return node.N;
	}
	//GetMethods
	public Value get(Key key) { 
		return get(root,key);
	}
	private Value get(Node node, Key key) {//get value or null
		if(node==null) return null;
		
		int cmp=key.compareTo(node.key);
		if( cmp < 0 )					//If key < node.key,
			return get(node.left,key);	// goto left 
		else if( cmp > 0 )				//If key > node.key
			return get(node.right,key);	// goto right
		else							// if key == node.key
			return node.value;			//return value;
	}
	//PutMethods
	public void put(Key key,Value value) {
		root=put(root,key,value);
	}
	private Node put(Node node, Key key, Value value) {
		if( node == null )								//If absent 
			return new Node(key, value, 1);				//return new Node
		int cmp=key.compareTo(node.key);
		if( cmp<0 )										//If key<node.key
			node.left=put(node.left, key, value);		//left=(node.left == key)=value or new Node
		else if( cmp>0 ) 								//If key>node.key
			node.right=put(node.right, key, value);		//right=(node.right == key)=value or new Node
		else											//If key == node.key
			node.value=value;							//node.value=value;
		node.N=size(node.left)+size(node.right)+1;		//Node.N=size
		return node;
	}
	public Key min() {
		return min(root).key;
	}
	private Node min(Node node) {
		if(node.left==null) 
			return node;
		return min(node.left);
	}
	
	public Key max() {
		return max(root).key;
	}
	private Node max(Node node) {
		if(node.right==null) 
			return node;
		return max(node.right);
	}
	public Key floor(Key key) {//MaxLine
		Node node = floor(root,key);
		if(node == null) return null;
		return node.key;
	}
	
	private Node floor(Node node, Key key) {
		if(node==null) return null;
		int cmp=key.compareTo(node.key);
		if(cmp==0)
			return node;
		if(cmp<0) 
			return floor(node.left,key);
		Node t = floor(node.right,key);
		if(t!=null) 
			return t;
		else
			return node;
	}
	public Key ceiling(Key key) {
		Node node=ceiling(root,key);
		if(node==null) return null;
		return node.key;
	}
	private Node ceiling(Node node, Key key) {
		if(node==null) return null;
		int cmp=key.compareTo(node.key);
		if(cmp==0)
			return node;
		if(cmp>0) 
			return floor(node.right,key);
		Node t = floor(node.left,key);
		if(t!=null) 
			return t;
		else
			return node;
	}
	//Select
	public Key select(int k) {
		return select(root,k).key;
	}
	private Node select(Node node, int k) {
		if(node==null) return null;
		int t=size(node.left);
		if(t>k) return select(node.left,k);
		else if(t<k) return select(node.right,k-t-1);
		else return node;
	}
	//Delete
	public void deleteMin() {
		root=deleteMin(root);
	}
	private Node deleteMin(Node node) {
		if(node.left==null)
			return node.right;
		node.left=deleteMin(node.left);
		node.N=size(node.left)+size(node.right)+1;
		return node;
	}
	public void delete(Key key) {
		root=delete(root,key);
	}
	private Node delete(Node node, Key key) {
		if(node==null) return null;
		int cmp=key.compareTo(node.key);
		if(cmp<0)
			node.left=delete(node.left,key);
		else if(cmp>0)
			node.right=delete(node.right,key);
		else {
			if(node.right==null) return node.left;
			if(node.left==null) return node.right;
			Node t=node;
			node=min(t.right);
			node.right=deleteMin(t.right);
			node.left=t.left;
		}
		node.N=size(node.right)+size(node.left)+1;
		return node;
	}
	public int rank(Key key) {
		return rank(root,key);
	}
	private int rank(Node node, Key key) {
		if(node==null) return 0;
		int cmp=key.compareTo(node.key);
		if(cmp<0) return rank(node.left,key);
		else if(cmp>0) return 1+size(node.left)+rank(node.right,key);
		else return size(node.left);
	}
	@Override
	public String toString() {
		return "BinaryTree [root=" + root + "]";
	}
}
