package testing;

import org.junit.Test;

import sorting.*;

import static org.junit.Assert.*;

import java.awt.event.FocusAdapter;
import java.util.ArrayList;

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

		int[] a = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
		int[] hA = {16, 14, 10, 8, 7, 9, 3, 2, 4, 1};
		
		ArrayList<Integer> array = fromArrayToAList(a);
		ArrayList<Integer> heapifiedArray = fromArrayToAList(hA);
		
		HeapSort heap = new HeapSort();
		heap.heapifyIntArray(array);
		assertEquals("Heapifying integer array has failed", array, heapifiedArray);
	}
	@Test
	public void testHeapExtractMax() {
		int[] a = {31, 41, 59, 26, 41, 58};
		ArrayList <Integer> array = fromArrayToAList(a);
		
		HeapSort heap = new HeapSort();
		
		assertEquals("Heap extract max has failed", 59, heap.heapExtractMax(array));
		
	}
	@Test
	public void testHeapInsert() {
		int[] a = {31, 41, 60, 26, 41, 58};
		int[] hA = {60, 41, 59, 26, 41, 31, 58};

		ArrayList<Integer> array = fromArrayToAList(a);
		ArrayList<Integer> heapifiedArray = fromArrayToAList(hA);
		
		HeapSort heap = new HeapSort();
		heap.heapInsert(array, 59);
		
		assertEquals("Heapifying integer array has failed", array, heapifiedArray);
	}
	
	private void testIntArray(Sorting sorting){
		int[] a = {31, 41, 59, 26, 41, 58};
		int[] sA = {26, 31, 41, 41, 58, 59};
		
		ArrayList<Integer> array = fromArrayToAList(a);
		ArrayList<Integer> sortedArray = fromArrayToAList(sA);
		
		// testing sorting of an unsorted array
		sorting.sortIntArray(array);
		assertEquals("Sorting integer array has failed", array, sortedArray);
		
		// testing sorting of sorted array
		a = sA.clone();
		array = fromArrayToAList(a);
		sorting.sortIntArray(array);
		assertEquals("Sorting integer array has failed", array, sortedArray);
	}
	
	private ArrayList<Integer> fromArrayToAList(int[] a){
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		for (int i: a)
			arrayList.add(i);
		return arrayList;
	}
	
	@SuppressWarnings("unused")
	private void printIntArray(int[] a){
		for (int i:a)
			System.out.print(i + " ");
		System.out.println();
	}
}
