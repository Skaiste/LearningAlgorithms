package sorting;

import java.util.ArrayList;

public class StoogeSort implements Sorting {

	@Override
	public void sortIntArray(ArrayList<Integer> a) {
		sortIntArray(a, 0, a.size() - 1);
	}
	
	private void sortIntArray(ArrayList<Integer> a, int i, int j){
		if (a.get(i) > a.get(j))
			swap(a, i, j);
		
		if (i + 1 >= j)
			return;
		
		int k = (j - i + 1) / 3;
		sortIntArray(a, i, j - k);
		sortIntArray(a, i + k, j);
		sortIntArray(a, i, j - k);
	}
	
	private void swap(ArrayList<Integer> a, int i, int j){
		int tmp = a.get(i);
		a.set(i, a.get(j));
		a.set(j, tmp);
	}

	public String toString(){
		return "Stooge sort";
	}
}
