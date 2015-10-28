package sorting;

import java.util.ArrayList;

public class QuickSort implements Sorting {

	@Override
	public void sortIntArray(ArrayList<Integer> a) {
		sortIntArray(a, 0, a.size() - 1);
		
	}
	
	private void sortIntArray(ArrayList<Integer> a, int p, int r){
		if (p >= r)
			return;
		
		int q = partitionIntArr(a, p, r);
		sortIntArray(a, p, q);
		sortIntArray(a, q + 1, r);
	}
	
	private int partitionIntArr(ArrayList<Integer> a, int p, int r){
		int pivot = getPivot(a, p, r);
		int i = p - 1, j = r + 1;
		
		while(true){
			
			do j--; while (a.get(j) > pivot);
			do i++; while (a.get(i) < pivot);
			
			if (i < j)
				swap(a, i, j);
			else
				return j;
		}
	}
	
	private void swap(ArrayList<Integer> a, int i, int j){
		int tmp = a.get(i);
		a.set(i, a.get(j));
		a.set(j, tmp);
	}
	private int getPivot(ArrayList<Integer> a, int p, int r){
		// getting approximate middle
		double middle = middle(a, p, r);
		
		// Initializing pivot as minimum value
		int pivot = a.get(p);
		
		// searching for a pivot that could be closest to the middle
		for (int i = p; i <= r; i++)
			if (Math.abs(middle - a.get(i)) < Math.abs(middle - pivot))
				pivot = a.get(i);
		
		return pivot;
	}
	
	private double middle(ArrayList<Integer> a, int p, int r) {
		// if array is empty return zero
		if (p >= r)
			return 0;
		
		// summing all elements from begining to end
		int sum = a.get(p);
		for (int i = p + 1; i <= r; i ++)
				sum += a.get(i);
		
		// returning average
		return (double) sum / a.size();
	}
}
