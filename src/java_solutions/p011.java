package java_solutions;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import tools.MyStopwatch;

// Gives right answer

public class p011 {

	public static void main(String[] args) {

		final int n = 4;	// nth adjacent digits
		int[][] grid = new int[20][20];
		
		MyStopwatch sw = new MyStopwatch().start();
		
		long max = 0;
		long maxArray[] = new long[4];
		populateGrid(grid);
		
		maxArray[0] = upDown(grid, n);
		maxArray[1] = leftRight(grid, n);
		maxArray[2] = diagonal(grid, n);
		maxArray[3] = diagonal2(grid, n);
		
		max = arrayMax(maxArray);
				
		System.out.println("The greatest product of four adjacent numbers " +
				"in the same direction (up, down, left, right, or diagonally) " +
				"in the 20�20 grid is " + max);
		
		sw.stop().print();
		
	}
	
	public static long leftRight(int[][] grid, int n){
		long maxProd = 0;
		int count = 0;
		
		int[] x = new int[n];
		long prod;
		for(int yFirst = 0; yFirst < grid.length; yFirst++)
			for(int xFirst = 0; xFirst+n <= grid[yFirst].length; xFirst++){

				System.out.print("leftRight count[" + (++count) + "] = ");
				// Get the n numbers
				for(int i = 0; i < n; i++){
					x[i] = grid[yFirst][xFirst + i];
					System.out.print(x[i] + (i == n-1 ? "\n" : " x "));
				}
				
				// Multiply all the elements the array
				prod = arrayProd(x);
				
				if(prod>maxProd)
					maxProd = prod;
				
			}
		
		return maxProd;
	}

	public static long upDown(int[][] grid, int n){
		long maxProd = 0;
		int count = 0;
		
		int[] x = new int[n];
		long prod;
		for(int yFirst = 0; yFirst+n <= grid.length; yFirst++)
			for(int xFirst = 0; xFirst < grid[yFirst].length; xFirst++){
				
				System.out.print("upDown count[" + (++count) + "] = ");
				// Get the n numbers
				for(int i = 0; i < n; i++){
					x[i] = grid[i + yFirst][xFirst];
					System.out.print(x[i] + (i == n-1 ? "\n" : " x "));
				}
				
				// Multiply all the elements the array
				prod = arrayProd(x);
				
				if(prod>maxProd)
					maxProd = prod;
				
			}
				
		return maxProd;
	}

	public static long diagonal(int[][] grid, int n){
		long maxProd = 0;
		int count = 0;
		
		int[] x = new int[n];
		long prod;
		for(int yFirst = 0; yFirst+n <= grid.length; yFirst++)
			for(int xFirst = 0; xFirst+n <= grid[yFirst].length; xFirst++){

				System.out.print("diag count[" + (++count) + "] = ");
				// Get the n numbers
				for(int i = 0; i < n; i++){
					x[i] = grid[yFirst + i][xFirst + i];
					System.out.print(x[i] + (i == n-1 ? "\n" : " x "));
				}
				
				// Multiply all the elements the array
				prod = arrayProd(x);
				
				if(prod>maxProd)
					maxProd = prod;
				
			}
		
		return maxProd;
	}
	
	public static long diagonal2(int[][] grid, int n){
		long maxProd = 0;
		int count = 0;
		
		int[] x = new int[n];
		long prod;
		for(int yFirst = 3; yFirst < grid.length; yFirst++)
			for(int xFirst = 0; xFirst+n <= grid[yFirst].length; xFirst++){

				System.out.print("diag2 count[" + (++count) + "] = ");
				// Get the n numbers
				for(int i = 0; i < n; i++){
					x[i] = grid[yFirst - i][xFirst + i];
					System.out.print(x[i] + (i == n-1 ? "\n" : " x "));
				}
				
				// Multiply all the elements the array
				prod = arrayProd(x);
				
				if(prod>maxProd)
					maxProd = prod;
				
			}
		
		return maxProd;
	}
	
	public static long arrayProd(int[] x){
		long prod = 1;
		for(int i=0; i<x.length; i++)
			prod *= x[i];
		return prod;
	}
	
	public static long arrayMax(long[] x){
		long max = Long.MIN_VALUE;
		for(int i=0; i<x.length; i++){
			System.out.println("arrayMax[" + i + "] = " + x[i]);
			if(x[i]>max)
				max = x[i];
		}
		return max;
	}

	public static void populateGrid(int[][] grid){
		try {
			
			Scanner sc = new Scanner(new File("p011.txt"));
			for(int i = 0; i < grid.length; i++){
				for(int j = 0; j < grid[i].length; j++){
					grid[i][j] = sc.nextInt();
					//System.out.printf("%02d ",grid[i][j]);
				}
				//System.out.println();
			}
			sc.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}	
	}
	
}
