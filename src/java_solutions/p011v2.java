package java_solutions;

//Gives right answer

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import tools.MyStopwatch;

public class p011v2 {

	public static void main(String args[]){

		MyStopwatch sw = new MyStopwatch().start();
		int[][] nums = getnumbers();
		int biggest = 0;
		
		int temp;
		for(int row=0; row<nums.length; row++){
			for(int col=0; col<nums[row].length; col++){
				
				// Check down
				if(row < 17){
					temp = 1;
					for(int i=0; i<4; i++)
						temp *= nums[row+i][col];
					if(temp > biggest)
						biggest = temp;
				}
				
				// Check right
				if(col < 17){
					temp = 1;
					for(int i=0; i<4; i++) 
						temp *= nums[row][col+i];
					if(temp > biggest)
						biggest = temp;
				}
				
				// Check diagonally down-right
				if(row < 17 && col < 17){
					temp = 1;
					for(int i=0; i<4; i++) 
						temp *= nums[row+i][col+i];
					if(temp > biggest)
						biggest = temp;
				}
				
				// Check diagonally down-left
				if(row < 17 && col > 2){
					temp = 1;
					for(int i=0; i<4; i++) 
						temp *= nums[row+i][col-i];
					if(temp > biggest)
						biggest = temp;
				}
				
			}
		}

		sw.stop().print();
		
		System.out.println("\nThe biggest is " + biggest);
		
	}

	public static int[][] getnumbers(){
		int[][] nums = new int[20][20];
		Scanner sc;
		
		try {
			sc = new Scanner(new File("p011.txt"));
			
			for(int row=0; row<nums.length; row++){
				for(int col=0; col<nums[row].length; col++){
					nums[row][col] = sc.nextInt();
					System.out.printf("%02d ", nums[row][col]);
				}
				System.out.println();
			}
			
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	return nums;
	}
}
