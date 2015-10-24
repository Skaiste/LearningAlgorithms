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
}
