package Algorithms.Collections.PriorityQueue;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Algorithms.Collections.PriorityQueue.MaxPQBySortedArray;

class MaxPQBySortedArrayTest {
	private MaxPQBySortedArray<Integer> pq;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("======Tests_Begin_======");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("======Tests_End_======");
	}

	@BeforeEach
	void setUp() throws Exception {
		pq=new MaxPQBySortedArray<>(0);
		pq.addAll(List.of(1,2,3,4,5,6));
		System.out.printf("    Before: %s\n",pq);
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.printf("    Become: %s\n\n",pq);
		pq.clear();
	}

	@Test
	void addAll() {
		var list = List.of(2,3,5);
		System.out.printf("    AddAll: %s\n",list);
		pq.addAll(list);
		assertArrayEquals(pq.toArray(), List.of(1,2,2,3,3,4,5,5,6).toArray());
	}
	@Test
	void contains() {
		System.out.printf("    Contains? True : False\n");
		System.out.printf("    [1] = true\n");
		assertTrue(pq.contains(1));
		System.out.printf("    [2] = true\n");
		assertTrue(pq.contains(2));
		System.out.printf("    [6] = true\n");
		assertTrue(pq.contains(6));
		System.out.printf("    [9] = false\n");
		assertFalse(pq.contains(9));
	}
	@Test
	void containsAll() {
		System.out.printf("    ContainsAll? True : False\n");
		var list = List.of(3,4,5);
		var flag = pq.containsAll(list);
		System.out.printf("    %s in %s -> %b \n",list,pq,flag);
		assertTrue(flag);
		
		list = List.of(3,4,5,9);
		flag = pq.containsAll(list);
		System.out.printf("    %s in %s -> %b \n",list,pq,flag);
		assertTrue(!flag);
	}
	@Test
	void remove() {
		for(Integer number : List.of(6,4,3,1)) {
			System.out.printf("    Remove: [%d]\n",number);
			pq.remove(number);
		}
			assertArrayEquals(List.of(2,5).toArray(), pq.toArray());
	}
	@Test
	void removeAll() {
			var number = List.of(6,4,3,1);
			System.out.printf("    RemoveAll: %s\n",number);
			var bool=pq.removeAll(number);
			assertArrayEquals(List.of(2,5).toArray(), pq.toArray());
			assertTrue(bool);
			
			number = List.of(6,2,1);
			System.out.printf("    RemoveAll: %s\n",number);
			bool=pq.removeAll(number);
			assertArrayEquals(List.of(2,5).toArray(), pq.toArray());
			assertFalse(bool);
	}
	@Test
	void retainAll() {
		var list = List.of(1,2,3);
		System.out.printf("    RetainAll:%s\n",list);
		var bool=pq.retainAll(list);
		assertArrayEquals(list.toArray(), pq.toArray() );
		assertTrue(bool);
		list=List.of(2,3,4);
		bool=pq.retainAll(list);
		assertArrayEquals(List.of(1,2,3).toArray(), pq.toArray() );
		assertFalse(bool);
	}
	@Test
	void peek() {
		int number=6;
		int peek = pq.peek();
		boolean bool=(peek==number);
		System.out.printf("    Peek:%d == %d -> %b\n",number,peek,bool);
		assertTrue(bool);
	}
	@Test
	void poll() {
		for(int number : IntStream.iterate(6, x->--x).limit(6).toArray()) {
			var poll=pq.poll();
			var bool=(number==poll);
			System.out.printf("    Poll:[%d]->[%d]->[%b]\n",number,poll,bool);
			assertArrayEquals(IntStream.range(1, number).boxed().toArray(), pq.toArray());
			assertTrue(bool);
		}
	}
}

