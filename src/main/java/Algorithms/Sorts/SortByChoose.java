package Algorithms.Sorts;

public class SortByChoose {
	public static void sort(int[] array) {
		if(array.length<2) 
			return;
		for(int i=0; i<array.length;++i) {
			for(int j=i;j<array.length;++j)
				if(array[i]>array[j])
					swap(array, i, j);
		}
	}

	private static void swap(int[] array, int i, int j) {
		int temp=array[i];
		array[i]=array[j];
		array[j]=temp;
	}
}