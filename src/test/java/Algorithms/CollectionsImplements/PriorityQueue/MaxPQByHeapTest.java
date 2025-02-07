package Algorithms.CollectionsImplements.PriorityQueue;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MaxPQByHeapTest {
private MaxPQByHeap<Integer> pq;
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
		pq=new MaxPQByHeap<>(0);
		pq.offer(1);
		pq.offer(2);
		pq.offer(3);
		pq.offer(4);
		pq.offer(5);
		pq.offer(6);
		System.out.printf("    Before: %s\n",pq);
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.printf("    Become: %s\n\n",pq);
		pq.clear();
	}	
	@Test
	void offer() {
		pq.clear();
		for( var number : IntStream.rangeClosed(0, 4).toArray()) {
			System.out.printf("    Offer: [%d]\n",number);
			pq.offer(number);
		}
//		assertArrayEquals(pq.toArray(), List.of(4,3,2,1,0).toArray());
	}
	@Test
	void poll() {
		System.out.printf("    Poll:\n");
		pq.poll();
//		assertArrayEquals(pq.toArray(), List.of(4,3,2,1,0).toArray());
	}

}
