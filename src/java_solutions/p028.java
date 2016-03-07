package java_solutions;

public class p028 {

	static int gridSize = 1001;	// Must be an odd number
	static int numsCount = (int) Math.pow(gridSize, 2);
	static int[][] nums = new int[gridSize][gridSize];
	
	public static void main(String[] args) {

		populateGrid();
		
		//printGrid();
		
		System.out.println("the sum of the numbers on the diagonals in a " + 
				"1001 by 1001 spiral formed in the same way is " + getAnswer());
		
	}

	public static void populateGrid(){
		int row = (gridSize-1)/2;
		int col = row;
		
		// Set first number
		nums[row][col] = 1;
		
		int moves = 1;	// now many moves in one direction
		int moveCount = 0;
		Direction dir = Direction.right;
		
		for(int i=2; i<numsCount+1; i++){
			
			row = dir.moveRow(row);
			col = dir.moveCol(col);
			nums[row][col] = i;
			moveCount++;
			
			if(moveCount == moves){
				if(dir == Direction.down || dir == Direction.up)
					moves++;
				moveCount = 0;
				dir = dir.next();
			}
			
		}
	}
	
	public static int getAnswer(){
		int answer = 0;
		answer -= 1; 	// Don't add the middle value twice    nums[gridSize/2][gridSize/2]
		
		for(int i=0; i<gridSize; i++){
			answer += nums[i][i];
			answer += nums[(gridSize-1)-i][i];
		}
		
		return answer;		
	}
	
	public static void printGrid(){
		for(int row = 0; row<nums.length; row++){
			for(int col = 0; col<nums[row].length; col++)
				System.out.printf("%2d ", nums[row][col]);
			System.out.println();
		}
	}
	
	static enum Direction{
		
		right, down, left, up;
		
		private static Direction[] vals = values();
		
	    public Direction next()
	    {
	        return vals[(this.ordinal()+1) % vals.length];
	    }
	    
	    public int moveRow(int row){
	    	switch(vals[this.ordinal()]){
		    	case right:
		    		return row + 0;
		    	case down:
		    		return row + 1;
		    	case left:
		    		return row + 0;
		    	case up:
		    		return row - 1;
	    	}
	    	return 0;
	    }
	    
	    public int moveCol(int col){
	    	switch(vals[this.ordinal()]){
		    	case right:
		    		return col + 1;
		    	case down:
		    		return col + 0;
		    	case left:
		    		return col - 1;
		    	case up:
		    		return col + 0;
	    	}
	    	return 0;
	    }
	    
	}
	
}
