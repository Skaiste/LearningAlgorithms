package sorting;

public class InsertionSort implements Sorting{

	public void sortIntArray(int[] a) {
		if (a == null || a.length < 2)
			return;
		
		// sorting begins
		for (int j = 1; j < a.length; j++) {
			
			int key = a[j];
			int i = j - 1;
			
			while (i >= 0 && a[i] > key) {
				a[i+1] = a[i];
				i -= 1;
			}
			
			a[i + 1] = key;
		}
		// sorting ends
		
	}

}
