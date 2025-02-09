package Algorithms.QuckSort;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import Algorithms.Sorts.SortByQuick;

class QuickTest {

	@ParameterizedTest
	@MethodSource("getArgs")
	void test(Integer[] input,Integer[] expected) {
		var temp = input;
		SortByQuick.sort(temp);
		assertArrayEquals(expected,temp);
	}
	public static Stream<Arguments> getArgs(){
		return Stream.of(
			Arguments.of(new Integer[] {5,4,3,2,1},new Integer[] {1,2,3,4,5})
		);
	} 
}
