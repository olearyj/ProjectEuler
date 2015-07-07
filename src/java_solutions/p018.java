package java_solutions;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class p018 {

	static String filename = "p018.txt";
	
	public static void main(String[] args){
		
		System.out.println("The maximum total from top to bottom of the triangle is " + findMax());
		
		// The rest didn't work, refer to findMax method
		
		Node head = makeTree();
		int max = 0;

		System.out.println("Depth is " + head.getDepth());

		Node node = head;
		while(node.left != null){
			max += node.getVal();
			node = (node.left.getVal() > node.right.getVal() ? node.left : node.right);
		}
		
	}
	
	private static int findMax() {
		
		int max = 0;

		try {
			Scanner sc = new Scanner(new File(filename));
			
			int row = 0;
			int[] lastRow = new int[++row];
			lastRow[0] = sc.nextInt();
			int[] thisRow;
			
			while(sc.hasNextInt()){
				
				// Fill the row with values
				thisRow = new int[++row];
				int col = 0;
				while(col < row){
					thisRow[col] = sc.nextInt();
					if(col == 0)
						thisRow[col] += lastRow[col];
					else if(col+1 == row)
						thisRow[col] += lastRow[col-1];
					else
						thisRow[col] += (lastRow[col-1] > lastRow[col] ? 
								lastRow[col-1] : lastRow[col]);
					col++;
				}
				
				lastRow = thisRow;
			}
			
			for(int i=0; i<lastRow.length; i++)
				if(lastRow[i] > max)
					max = lastRow[i];
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return max;
	}

	public static Node makeTree(){
		
		Node head = null;
		
		try {
			Scanner sc = new Scanner(new File(filename));
			head = new Node(sc.nextInt());
			
			int row = 0;
			Node[] lastNodeRow;
			Node[] nodeRow = new Node[++row];
			nodeRow[0] = head;
			
			while(sc.hasNextInt()){
				lastNodeRow = nodeRow;
				
				// Fill the node row
				nodeRow = new Node[++row];
				int col = 0;
				while(col < row)
					nodeRow[col++] = new Node(sc.nextInt());
				
				// Set left and right nodes for last row of nodes
				for(int i = 0; i<lastNodeRow.length; i++){
					lastNodeRow[i].left = nodeRow[i];
					lastNodeRow[i].right = nodeRow[i+1];					
				}
				
			}
			
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return head;
	}
	
	static class Node {
		
		public Node left;
		public Node right;

		private int value;
		
		public Node(int value){
			this.value = value;
		}
		
		public int getVal(){
			return value;
		}
		
		public int getDepth(){
			return 1 + (left != null ? left.getDepth() : 0);
		}
		
	}
	
}
