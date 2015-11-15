package sorting;

import java.util.ArrayList;

public class InsertionSort implements Sorting{

	public void sortIntArray(ArrayList<Integer> a) {
		if (a == null || a.size() < 2)
			return;
		
		// sorting begins
		for (int j = 1; j < a.size(); j++) {
			
			int key = a.get(j);
			int i = j - 1;
			
			while (i >= 0 && a.get(i) > key) {
				a.set(i + 1, a.get(i));
				i -= 1;
			}
			a.set(i + 1, key);
		}
		// sorting ends
		
	}
	
	public String toString(){
		return "Insertion sort";
	}

}
