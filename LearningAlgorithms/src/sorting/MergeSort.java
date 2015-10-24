package sorting;

public class MergeSort implements Sorting{

	@Override
	public void sortIntArray(int[] a) {
		sortIntArray(a, 0, a.length - 1);
	}
	
	private void sortIntArray(int[] a, int p, int r){
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
				if(a[i] < a[j])
					tmpArr[k++] = a[i++];
				else
					tmpArr[k++] = a[j++];
			}
			while (i <= q)				// merging left elements
				tmpArr[k++] = a[i++];
			while (j <= r)
				tmpArr[k++] = a[j++];
			
			// returning all elements from temporary array
			i = p;
			for (int tmp : tmpArr)
				a[i++] = tmp;
			
		}
	}

}
