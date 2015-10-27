package testing;

import org.junit.Test;

import sorting.*;

import static org.junit.Assert.*;

public class TestingSorting {

	@Test
	public void testInsertionSortIntArr() {
		testIntArray(new InsertionSort());
	}
	
	@Test
	public void testMergeSortIntArr() {
		testIntArray(new MergeSort());
	}
	
	@Test
	public void testHeapSortIntArr() {
		testIntArray(new HeapSort());
	}
	@Test
	public void testHeapify() {

		int[] array = {4,1, 3, 2, 16, 9, 10, 14, 8, 7};
		int[] heapifiedArray = {16, 14, 10, 8, 7, 9, 3, 2, 4, 1};
		
		HeapSort heap = new HeapSort();
		heap.heapifyIntArray(array);
		assertArrayEquals("Heapifying integer array has failed", array, heapifiedArray);
	}
	
	private void testIntArray(Sorting sorting){
		
		int[] array = {31, 41, 59, 26, 41, 58};
		int[] sortedArray = {26, 31, 41, 41, 58, 59};
		
		// testing sorting of an unsorted array
		sorting.sortIntArray(array);
		assertArrayEquals("Sorting integer array has failed", array, sortedArray);
		
		// testing sorting of sorted array
		array = sortedArray.clone();
		sorting.sortIntArray(array);
		assertArrayEquals("Sorting integer array has failed", array, sortedArray);
	}
	
	private void printIntArray(int[] a){
		for (int i:a)
			System.out.print(i + " ");
		System.out.println();
	}
}
