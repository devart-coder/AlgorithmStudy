package Algorithms.Collections.PriorityQueue;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

import Algorithms.Collections.PriorityQueue.MaxPQByArray;

class MaxPQByArrayTest {
	private MaxPQByArray<Integer> pq = new MaxPQByArray<>(3);
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("======_Begin_======");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("=======_End_=======");
	}
	@BeforeEach
	void setUp() throws Exception {
		System.out.println("   =================   ");
		pq.offer(1);
		pq.offer(2);
		pq.offer(3);
		System.out.println("   Input: " + Arrays.toString(pq.toArray()) );
	}
	@AfterEach
	void tearDown() throws Exception {
		System.out.println("   Become: "+Arrays.toString(pq.toArray()));
		pq.clear();
	}
	@Test
	void addAll() {
		System.out.println("   Test:AddAll:");
		var t = new MaxPQByArray<Integer>(3);
		t.offer(4);
		t.offer(5);
		t.offer(6);
		pq.addAll(t);
		var expected = new MaxPQByArray<Integer>(6);
		for(int i=1;i<=6;++i)
			expected.offer(i);
		assertArrayEquals(pq.toArray(),expected.toArray() );
	}
	@Test
	void clear() {
		System.out.println("   Test:Clear:");
		pq.clear();
		assertTrue(pq.toArray() == null);
		assertTrue(pq.size() == 0);
	}
	@Test
	void contains() {
		System.out.println("   Test:Contains:");
		assertTrue(pq.contains(1) == true);
		assertTrue(pq.contains(2) == true);
		assertTrue(pq.contains(3) == true);
	}
	@Test
	void containsAll() {
		System.out.println("   Test:ContainsAll:");
		var t = new PriorityQueue<Integer>(3);
		t.offer(1);
		t.offer(2);
		t.offer(3);
		assertTrue(pq.containsAll(t) == true);
	}
	@Test
	void remove() {
		System.out.println("   Test:Remove:");
		pq.remove(2);
		assertArrayEquals(Arrays.asList(1,3).toArray(), pq.toArray());
	}
	@Test
	void size(){
		System.out.println("   Test:Size:");
		assertEquals( pq.size(), 3);
	}
	@Test
	void removeAll() {
		System.out.println("   Test:removeAll:");
		var temp = new ArrayList<Integer>(2);
		temp.add(2);
		temp.add(1);
		pq.removeAll(temp);
	}
	@Test
	void add() {
		System.out.println("   Test:add:");
		var test = Arrays.copyOf(pq.toArray(), pq.size()+1);
		test[3]=4;
		pq.add(4);
		assertArrayEquals(test, pq.toArray());
	}
	@Test
	void poll() {
		System.out.println("   Test:poll:");
		pq.poll();
		assertArrayEquals(new Integer[]{1,2}, pq.toArray());
	}
	@Test
	void retainAll() {
		System.out.println("   Test:retailAll:");
		var res = new MaxPQByArray<Integer>(2);
		res.add(1);
		var flag=pq.retainAll(res);
		assertArrayEquals(new Integer[]{1}, pq.toArray());
		assertTrue(flag);
	}
}
