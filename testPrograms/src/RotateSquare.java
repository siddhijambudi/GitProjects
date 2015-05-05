// Copyright (c) 2015 Financial Engines, Inc.  All Rights Reserved.
//                    Palo Alto, CA 

/*
 * File:		RotateSquare.java
 * Author:	sjambudi
 */



public class RotateSquare
{
	public static void main(String args[]){
		
		int[][] matrix = new int[3][3];
		matrix[0][0]= 1;
		matrix[0][1]= 2;
		matrix[0][2]= 3;
		
		matrix[1][0]= 4;
		matrix[1][1]= 5;
		matrix[1][2]= 6;
		
		matrix[2][0]= 7;
		matrix[2][1]= 8;
		matrix[2][2]= 9;
		
		System.out.println("Before rotate :");
		displayMatrix(matrix);
		
		rotate(matrix, 3);
		
		System.out.println("\nAfter rotate :");
		displayMatrix(matrix);
	}
	
	public static void rotate(int [][] matrix, int n){
		for(int layer = 0; layer < n/2; layer++){
			
			int first = layer;
			int last= n-layer-1;
			
			for(int i = first; i < last; i++){
				int offset = i - first;
				
				//save top
				int top = matrix[first][i];
				
				//left -> top
				matrix[first][i] = matrix[last-offset][first];
				
				//bottom -> left
				matrix[last - offset][first] = matrix[last][last-offset];
				
				//right -> bottom
				matrix[last][last-offset] = matrix[i][last];
				
				//top -> right
				matrix[i][last] = top;				
			}
		}
		
		
	}

	private static void displayMatrix(int[][] matrix)
	{
		System.out.print(matrix[0][0] + " " + matrix[0][1] + " " + matrix[0][2] + "\n" +
						 matrix[1][0] + " " + matrix[1][1] + " " + matrix[1][2] + "\n" +
						 matrix[2][0] + " " + matrix[2][1] + " " + matrix[2][2]);
	}
}

