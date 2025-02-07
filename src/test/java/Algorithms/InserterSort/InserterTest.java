package Algorithms.InserterSort;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import Algorithms.Sorts.ChooserSort.Choose;
import Algorithms.Sorts.InserterSort.Inserter;

class InserterTest {
	@ParameterizedTest
	@MethodSource("getArgs")
	void test(int[] data, int[] expected) {
		int[] input = data;
		Inserter.sort(input);
		System.out.println(Arrays.toString(input));
		assertArrayEquals(expected, data);
	}
	public static Stream<Arguments> getArgs() {
		return Stream.of(
			Arguments.of(new int[] {5,4,3,2,1},new int[] {1,2,3,4,5}),
			Arguments.of(new int[] {},new int[] {}),
			Arguments.of(new int[] {1},new int[] {1}),
			Arguments.of(new int[] {2,1},new int[] {1,2})
		);
	}

}
