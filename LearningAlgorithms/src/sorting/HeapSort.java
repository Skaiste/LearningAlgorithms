package sorting;

public class HeapSort implements Sorting{

	@Override
	public void sortIntArray(int[] a) {
		// building heap
		heapifyIntArray(a);
		
		int size = a.length;
		
		for (int i = a.length - 1; i >= 1; i--){
			swap(a, i, 0);
			size--;
			heapifyIntArray(a, size, 0);
		}
		
	}
	
	public void heapifyIntArray(int[] a){
		for(int i = (a.length-1) / 2; i >= 0; i--){
			heapifyIntArray(a, a.length, i);
		}
	}
	private void heapifyIntArray(int[] a, int size, int i){
		int l = left(i);
		int r = right(i);
		int largest = i;
		
		if (l < size && a[l] > a[largest])
			largest = l;
		if (r < size && a[r] > a[largest])
			largest = r;
		
		if (largest != i){
			swap(a, i, largest);
			heapifyIntArray(a, size, largest);
		}
	}
	
	private void swap(int[] a, int i, int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	private int left(int i){
		int j = i + 1;
		return j*2 - 1;
	}
	private int right(int i){
		int j = i + 1;
		return j*2;
	}
	private int parent(int i){
		int j = i + 1;
		return j/2 - 1;
	}
}
