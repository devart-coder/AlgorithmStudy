package Algorithms.Sorts;

import java.util.Arrays;

public class SortByMerge{
	public static int[] sort(int[] array) {
		int l=0;
		int r = array.length;
		int m = r/2;
		System.out.printf("I:%s\n",Arrays.toString(array));
		
		Arrays.sort(array,l,m);
		Arrays.sort(array,m,r);
		
		System.out.printf("S: %s\n",Arrays.toString(array));
		System.out.println();
		return merge(array,l,m,r);
	}
	private static int[] merge(int[] array, int l, int m, int r) {
		int i=l;
		int j=m+1;
		int[] aux = new int[r];
		for(int k=l; k<r; ++k)
			aux[k]=array[k];
		for(int k=l;k<=r;++k) {
			if(i>m) {
				array[k]=aux[j++];
			}else if(j>r) {
				array[k]=aux[i++];
			}else if( Integer.compare(aux[i], aux[j])<0) {
				array[k]=aux[j++];
			}else {
				array[k]=aux[i++];
			}
		}
		return aux;
	}
}
