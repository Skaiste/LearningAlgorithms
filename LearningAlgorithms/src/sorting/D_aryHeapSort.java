package sorting;

import java.util.ArrayList;

public class D_aryHeapSort implements Sorting {

	private int children;
	
	public D_aryHeapSort(){
		this.children = 2;
	}
	public D_aryHeapSort(int children){
		this.children = children;
	}
	
	@Override
	public void sortIntArray(ArrayList<Integer> a) {
		// building heap
		heapifyIntArray(a);
		
		int size = a.size();
		
		for (int i = a.size() - 1; i >= 1; i--){
			swap(a, i, 0);
			size--;
			heapifyIntArray(a, size, 0);
		}
	}

	public void heapifyIntArray(ArrayList<Integer> a){
		for(int i = (a.size()-1) / 2; i >= 0; i--){
			heapifyIntArray(a, a.size(), i);
		}
	}
	
	private void heapifyIntArray(ArrayList<Integer> a, int size, int i){
		ArrayList <Integer> nodes = new ArrayList<Integer>();
		// collect all children indexes
		for (int k = 0; k < children; k++)
			nodes.add(child(i,k));
		int largest = i;
		
		// go through all children and check which ones value is largest
		for (int k = 0; k < nodes.size(); k++){
			if (nodes.get(k) < size && a.get(nodes.get(k)) > a.get(largest))
				largest = nodes.get(k);
		}
		
		if (largest != i){
			swap(a, i, largest);
			heapifyIntArray(a, size, largest);
		}
	}
	
	public int heapExtractMax(ArrayList<Integer> a) {
		heapifyIntArray(a);
		
		if (a.size() < 1)
			return -1;
		
		int max = a.get(0);
		
		a.set(0, a.get(a.size() - 1));
		a.remove(a.size() - 1);
		
		heapifyIntArray(a, a.size(), 0);
		
		return max;
	}
	
	public void heapInsert(ArrayList<Integer> a, int key){
		heapifyIntArray(a);
		
		// adding space or making array bigger by one
		a.add(0);
		
		int i = a.size() - 1;
		
		while (i > 0 && a.get(parent(i)) < key){
			a.set(i, a.get(parent(i)));
			i = parent(i);
		}
		
		a.set(i, key);
	}

	private void swap(ArrayList<Integer> a, int i, int j){
		int temp = a.get(i);
		a.set(i, a.get(j));
		a.set(j, temp);
	}
	
	private int child(int i, int which){
		return children * i + 2 + which - 1;
	}
	private int parent(int i){
		int j = i + 1;
		return j/children - 1;
	}
	
	public String toString(){
		return "D-ary Heap sort";
	}
}
