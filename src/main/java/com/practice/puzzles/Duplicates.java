package com.practice.puzzles;
public class Duplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {1, 2, 3, 1, 3, 6, 6};
		
		for(int i = 0; i< a.length ; i++) {
			int index = a[i]%a.length;
			a[index] = a[index] + a.length;
		}
		
		System.out.print("Duplicate Elements are : ");
		
		for(int i = 0; i< a.length; i++) {
			if(a[i]/a.length > 1) {
				System.out.print(i+" ");
			}
		}
	}

}
