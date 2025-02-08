package Algorithms.Collections.BinaryTree;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Algorithms.Collections.BinaryTree.BinaryTree;

class BinaryTreeTest {
	private BinaryTree<Integer, String> tree;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("======_START_======");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("=======_END_=======");
	}

	@BeforeEach
	void setUp() throws Exception {
		tree = new BinaryTree<>();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		tree.put(0, "Hello");
		tree.put(1, "World");
		tree.put(2, "!!!");
		for(int i=0;i<tree.size();++i)
			System.out.printf("[%d]:\"%s\"\n",i,tree.get(i));
		System.out.println("Min: "+tree.min());
		System.out.println("Max: "+tree.max());
		System.out.println("Floor: "+tree.floor(100));
		System.out.println("Ceiling: "+tree.ceiling(-100));
		System.out.println("Select: "+tree.select(1));
		System.out.printf("Rank [%d]\n",tree.rank(3));
	}

}
