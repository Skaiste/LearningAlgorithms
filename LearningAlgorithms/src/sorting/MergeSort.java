package sorting;

import java.util.ArrayList;

public class MergeSort implements Sorting{

	@Override
	public void sortIntArray(ArrayList<Integer> a) {
		sortIntArray(a, 0, a.size() - 1);
	}
	
	private void sortIntArray(ArrayList<Integer> a, int p, int r){
		if (p < r) {
			// dividing array and sorting each part
			int q = (p + r) / 2;
			sortIntArray(a, p, q);		// sorts first part
			sortIntArray(a, q + 1, r);	// sorts second part
			
			// merging
			int i = p;		// for first part of array
			int j = q + 1;	// for second part of array
			int k = 0;		// for new array
			int[] tmpArr = new int[r - p + 1];	// new temporary array
			while ((i <= q) && (j <= r)){
				if(a.get(i) < a.get(j))
					tmpArr[k++] = a.get(i++);
				else
					tmpArr[k++] = a.get(j++);
			}
			while (i <= q)				// merging left elements
				tmpArr[k++] = a.get(i++);
			while (j <= r)
				tmpArr[k++] = a.get(j++);
			
			// returning all elements from temporary array
			i = p;
			for (int tmp : tmpArr)
				a.set(i++, tmp);
			
		}
	}
	
	public String toString(){
		return "Merge sort";
	}

}
