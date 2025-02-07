package Algorithms.CollectionsImplements.PriorityQueue;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.stream.Stream;

import javax.management.RuntimeErrorException;

import org.hamcrest.core.CombinableMatcher;

public class MaxPQByHeap <Key extends Comparable<Key>> implements Queue<Key>{
	private Key[] keys;
	private int N=0;
	MaxPQByHeap(int max){
		keys=(Key[])new Comparable[max+1];
	}
	private void swap(int i, int j) {
		Key temp = keys[i];
		keys[i]=keys[j];
		keys[j]=temp;
	}
	private boolean less(int i, int j) {
		return keys[i].compareTo(keys[j])<0;
	}
	private void swim(int i) {
		for(int k=i; k>1 && less(k/2,k); k/=2) {
			swap(k, k/2);
		}
	}
	private void sink(int i) {
		while(2*i<N) {
			int k=2*i;
			if(k<N&&less(k,k+1) )
				++k;
			if(!less(i,k))
				break;
			swap(k,i);
			i=k;
		}
	}
	@Override
	public boolean addAll(Collection<? extends Key> arg0) {
		keys=Arrays.copyOf(keys, N+arg0.size());
		//TODO::CastToCollectionsProblems
		for(Key key:arg0) 
			keys[N++]=key;
		Arrays.sort(keys);
		return true;
	}

	@Override
	public void clear() {
		N=0;
		keys=(Key[])new Comparable[N];
	}

	@Override
	public boolean contains(Object arg0) {
		Key value = (Key)arg0;
		for(Key key : keys)
			if(key==value)
				return true;
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		var res = arg0
		.stream()
		.filter(i->!this.contains(i))
		.toArray();
		return res.length==0 ? true : false;
	}

	@Override
	public boolean isEmpty() {
		return N==0;
	}

	@Override
	public Iterator<Key> iterator() {
		return new Iterator<Key>() {
			private int i=0;
			@Override
			public boolean hasNext() {
				return i==N;
			}

			@Override
			public Key next() {
				return keys[i++];
			}
		};
	}

	@Override
	public boolean remove(Object arg0) {
		int index=0;
		for(; index<keys.length-1 && keys[index]!=arg0; ++index);
		for(; index<keys.length-1; ++index)
			keys[index]=keys[index+1];
		if(index == keys.length)
			return false;
		keys=Arrays.copyOf(keys, keys.length-1);
		return true;
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		if(!containsAll(arg0))
			return false;
		for(Object key : arg0) 
			remove((Key)key);
		return true;
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		if(!containsAll(arg0))
			return false;
		for(Key key : keys) 
			if(!arg0.contains(key)) 
				remove(key);
		return true;
	}

	@Override
	public int size() {
		return N;
	}

	@Override
	public Object[] toArray() {
		return keys;
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		//TODO::MakeNormalMethod"ToArray"
		for(int i=0;i<arg0.length; ++i)
			arg0[i]=(T)keys[i];
		return null;
	}

	@Override
	public boolean add(Key arg0) {
		var res=offer(arg0);
		if(res == false)
			throw new RuntimeErrorException(new Error(), "Can't add to MaxPQByArray");
		return res;
	}

	@Override
	public Key element() {
		return poll();
	}

	@Override
	public boolean offer(Key value) {
		++N;
		if(N+1>=keys.length)
			keys=Arrays.copyOf(keys, N+1);
		keys[N]=value;
		swim(N);
		return true;
	}

	@Override
	public Key peek() {
		return keys[1];
	}

	@Override
	public Key poll() { //getMax
		var max=peek();
		keys[1]=keys[N];
		keys=Arrays.copyOf(keys, N);
		sink(1);
		return max;
	}

	@Override
	public Key remove() {
		var max =poll();
		if(max == null)
			throw new RuntimeErrorException(new Error(), "Can't add to MaxPQByArray");
		return max;
	}

	@Override
	public String toString() {
		return  Arrays.toString(keys);
	}
}
