package com.pranit.sorting;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] input = {8,9,2,5,6,4,56,4,1,3,55,6,645,1};
		sort(input);
		System.out.println("Sorted Array - ");
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i]+" ");
		}
	}
	
	public static void sort(int[] input){
		sort(input, 0, input.length-1);
	}
	
	private static void sort(int[] input, int start, int end){
		if(start >= end) return;
		
		int mid = (start + end) /2;
		sort(input, start, mid);
		sort(input, mid+1, end);
		merge(input, start, end, mid);
	}
	
	/**
	 * Precondition is input from start - mid and mid+1 - end are sorted
	 */
	private static void merge(int[] input, int start, int end, int mid){
		int[] aux = Arrays.copyOf(input, input.length);
		
		int i = start;
		int j = mid + 1;
		
		for(int k=start ; k <= end; k++){
			if(i > mid) 
				input[k] = aux[j++];
			else if (j > end)
				input[k] = aux[i++];
			else if(aux[i] > aux[j])
				input[k] = aux[j++];
			else
				input[k] = aux[i++];
		}
	}

}
