// Copyright (c) 2015 Financial Engines, Inc.  All Rights Reserved.
//                    Palo Alto, CA 

/*
 * File:		Test9.java
 * Author:	sjambudi
 */

public class Test9
{
	public static void main(String args[])
	{
		//int[] array = new int[]{23, 42, 4, 16, 8, 15};
		//int[] array = new int[]{4,8,15,16,23,42};
		//insertionSort(array);
		//bubbleSort(array);
		//selectionSort(array);
		//quickSort(array, 0, array.length-1);

		int[] arr = new int[]{71,66,71,82};
		dutchFlag("GBGGR");
		printArray();
	}
	
	public static void quickSort(int[] A, int p, int r)
	{
		if(p < r)
		{
			int q = partition(A, p, r);
			quickSort(A, p, q-1);
			quickSort(A, q+1, r);
		}		
	}
	static int partition(int[] A, int p, int r)
	{
		int i = p - 1;
		int j = p;
		int x = A[r];
		
		while(j <= r - 1){
			if(A[j] <= x){
				i++;
				
				int temp = A[j];
				A[j] = A[i];
				A[i] = temp;
			}
			j++;
		}
	
		int temp = A[i+1];
		A[i+1] = A[r];
		A[r] = temp;
		
		return i+1;		
	}
	
	public static void selectionSort(int[] array)
	{
		int n = array.length;
		for(int i = 0; i < n ;i++){
			int currMin = i;
			
			for(int j = i + 1; j < n ; j++){
				
				if(array[currMin] > array[j]){
					currMin = j;
				}
			}
			
			int temp = array[i];
			array[i] = array[currMin];
			array[currMin] = temp;
		}
		//printArray(array);
	}
	public static void bubbleSort(int[] array){
		int n = array.length;
		boolean islistsorted = false;
		
		for(int i = 0; i < n; i++){
			
			if(islistsorted){
				break;
			}		
			islistsorted = true;
			int j = 0;
			
			while(j < n - 1 - i){
				if(array[j] > array[j+1]){
					islistsorted = false;
				int temp = array[j];
				array[j] = array[j+1];
				array[j+1] = temp;
				}
				j++;
			}
		}
		//printArray(array);
	}

	public static void insertionSort(int[] array)
	{


		for(int i = 0; i < array.length; i++){
			int j = 0;
			while(j < i){
				if(array[i] < array[j]){
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
				j++;
			} 
		}

		for(int i = 0; i< array.length; i++){
			System.out.println(array[i]);
		}
	}
	
	public static void printArray()
	{
		String str = "GBGG";
		char[] arr = str.toCharArray();
		for(int i = 0; i < arr.length; i++){
			System.out.println((int) arr[i]);
		}

		/*for(int i = 0; i< array.length; i++){
			System.out.println(array[i]);
		}*/
	}

	public static String dutchFlag(String str){
		char[] charArr = str.toCharArray();

		for(int i = 1; i < charArr.length; i++){
			int key = (int) charArr[i];
			int j = i - 1;

			while(j >= 0 && (int) charArr[j] < key){
				charArr[j+1] = charArr[j];
				j--;
			}
			charArr[j+1] = (char) key;
		}
		return new String(charArr);
	}
}

 