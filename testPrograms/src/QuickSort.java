// Copyright (c) 2015 Financial Engines, Inc.  All Rights Reserved.
//                    Palo Alto, CA 

/*
 * File:		Test14.java
 * Author:	sjambudi
 */


public class QuickSort
{
	public static void main(String args[]){
		int[] A = new int[]{54, 5, 55, 6, 7, 56, 120, 560, 540, 505, 9, 57, 0, 1, 45, 65};
	
		System.out.println(findMax(A, 0, A.length - 1));
		//sortNums();
	}
	public static void sortNums(){
		int[] A = new int[]{1,3,2,4};
		
		quickSort(A, 0, A.length - 1);
		for(int i : A){
			System.out.println(i);
		}
	}
	private static void quickSort(int[] A, int p, int r)
	{
		if(p < r){
			int q = partition(A, p, r);
			quickSort(A, p , q-1);
			quickSort(A, q+1, r-1);	
		}
	}
	public static int partition(int[] A, int p, int r)
	{
		int i = p - 1;
		int j = p;
		int x = A[r];
		
		while(j <= r-1){
			if(A[j] >= x){
				i = i + 1;
				
				int temp = i;
				i = j;
				j = temp;
			}
			j++;
		}
		i = i + 1;
		
		int temp = A[i];
		A[i] = A[r];
		A[r] = temp;
		
		return i;
	}
	public static String findMax(int[] A, int startIndex, int endIndex){
		int i = startIndex;
		int n = endIndex;
		int max = startIndex;
				
		if(n > A.length || i >= n){
			return A[max]+"";
		}
		
		for(int i1 = i + 1; i1 <= n; i1++){
			if(A[i1] > A[max]){
				max = i1;
			}
		}	
		
		//swap startIndex with maxIndex
		if(max != startIndex){
			int temp = A[startIndex];
			A[startIndex] = A[max];
			A[max] = temp;
		}
		
		return A[startIndex] + findMax(A, startIndex + 1, endIndex);		
	}
}

