package com.datastructure.search;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String args[]) {

		int n, search, array[];

		Scanner in = new Scanner(System.in);
		System.out.println("Please provide the array size:");
		n = in.nextInt();
		array = new int[n];

		System.out.println("Enter " + n + " integers:");

		for (int i = 0; i < n; i++) {
			array[i] = in.nextInt();
		}

		System.out.println("Enter the value to find:");
		search = in.nextInt();
		in.close();
		//Let´s sort the array using java collections
		Arrays.sort(array);
		System.out.println("##########Array Values Sorted###############");
		printArrayValues(array);
		System.out.println("##########Binary Search Using Iteration Method###############");
		int result = binarySearch(search, array);
		if (result < 0) {
			System.out.println(search + " is not present in the list.\n");
		} else {
			System.out.println(search + " found at location " + result);
		}
		
		System.out.println("##########Binary Search Using Recursive Method###############");
		int recursiveResult = binarySearchRecursive(search, array, 0, array.length-1);
		if (recursiveResult < 0) {
			System.out.println(search + " is not present in the list.\n");
		} else {
			System.out.println(search + " found at location " + recursiveResult);
		}

		System.out.println("##########Binary Search Using Java Collections###############");
		System.out.println(search + " found at location " + Arrays.binarySearch(array, search));
	}

	public static int binarySearch(int search, int[] array) {

		int start = 0;
		int end = array.length - 1;

		while (start <= end) {
			
			int middle = (start + end) / 2;
			
			if (search < array[middle]) {
				end = middle - 1;
			}

			if (search > array[middle]) {
				start = middle + 1;
			}
			
			if (search == array[middle]) {
				return middle;
			}
		}
		return -1;

	}

	public static int binarySearchRecursive(int search, int[] array, int start, int end){
				
		int middle = (start + end)/2;
		
		if(end < start){
			 return -1;
		} 
		
		
		if (search < array[middle]){
			return binarySearchRecursive(search, array, start, middle - 1);
		}
		
		if (search > array[middle]){
			return binarySearchRecursive(search, array, middle + 1, end);
		}
		
		if (search == array[middle]){
			return middle;
		}
		
		return -1;
	}
	
	public static void printArrayValues(int[] array){
		String coma = "";
		for (int value : array){
			System.out.print(coma + value);
			coma = ", ";
		}
		System.out.println();
	}
}