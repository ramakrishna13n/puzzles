package com.practice.puzzles;	
public class LargestSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a[] = {-2, -3, 4, -1, -2, 1, 5, -3};
		
		//implement Kadane's Algorithm
		
		int max_reach = a[0];
		int max_sofar = a[0];
		
		for(int i=1; i< a.length; i++) {
			max_reach = Math.max(max_reach + a[i], a[i]);
			max_sofar = Math.max(max_reach, max_sofar);
		}
		
		System.out.println("Largest Sum "+ max_sofar);

	}

}
