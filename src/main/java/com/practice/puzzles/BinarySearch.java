package com.practice.puzzles;

public class BinarySearch {
	
	public boolean binarySearch(int arr[], int startIndex, int endIndex, int searchElement) {
		
		if(endIndex >= startIndex) {
		
			int midIndex = startIndex + (endIndex - startIndex)/2;
			
			if(arr[midIndex] == searchElement) {
				return true;
			}
			
			else if(arr[midIndex] > searchElement) {
				return binarySearch(arr, startIndex, midIndex - 1, searchElement);
			}
			else {
				return binarySearch(arr, midIndex + 1, endIndex, searchElement);
			}
		}
		
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = {2, 3, 4, 10, 40 , 60};
		int searchElement = 61;
		int arrayLength = arr.length;
		
		BinarySearch bs = new BinarySearch();
		boolean isFound = bs.binarySearch(arr, 0, arrayLength - 1, searchElement);
		
		System.out.println("Is Element found : "+isFound);
	}

}
