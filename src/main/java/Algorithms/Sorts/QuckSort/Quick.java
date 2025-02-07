package Algorithms.Sorts.QuckSort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class Quick {
	static int count =1;
	public static void sort(Integer[] array) {
		sort(array,0,array.length-1);
	}
	private static void sort(Integer[] array, int l, int r) {
		if(r<=l) return;
		int j=groupBy(array,l,r);
//		System.out.printf("%s < [%d] > %s \n",Arrays.toString(array), array[j] ,Arrays.toString(array));
		System.out.printf("|%d| %s [%d] %s => %s\n",
				count++,
				Arrays.toString(Arrays.copyOfRange(array,l,j)),
				array[j] ,
				Arrays.toString(Arrays.copyOfRange(array,j+1,r+1)),
				Arrays.toString(array)
		);
		sort(array,l,j-1);
		sort(array,j+1,r);
	}
	private static int groupBy(Integer[] array, int leftPoint, int rightPoint) {
		int left=leftPoint;
		int right=rightPoint+1;
		Integer value = array[leftPoint];
		while(true) {
			while(array[++left]<value)
				if(left==rightPoint)
					break;
			while(array[--right]>value)
				if(right==leftPoint)
					break;
			if(left>=right)
				break;
			System.out.printf("[%d]->{%d} [%d]->{%d} %s\n", left, array[left], right, array[right], Arrays.toString(array));
			swap(array,right,left);
		}
		System.out.printf("[%d]->{%d} [%d]->{%d} %s\n", left, array[left], right, array[right], Arrays.toString(array));
		swap(array,leftPoint,right);
		return right;
	}
 	private static void swap(Integer[] a, int f, int s) {
		var temp = a[f];
		a[f]=a[s];
		a[s]=temp;
	}
}
