package Algorithms.MergeSort;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import Algorithms.Sorts.MergeSort.Merge;

class MergeTest {

	@ParameterizedTest
	@MethodSource("getArgs")
	void test(int[] input, int[] expected) {
		int[] res = Merge.sort(input);
		System.out.printf("I: %s\nO: %s\nE: %s\n",Arrays.toString(input),Arrays.toString(res), Arrays.toString(expected));
		assertArrayEquals(expected, input);
	}

	public static Stream<Arguments> getArgs() {
		return Stream.of(
			Arguments.of(new int[] {6,5,4,3,2,1}, new int[] {1,2,3,4,5,6})
		);
	}
}
