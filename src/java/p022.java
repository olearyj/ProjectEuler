package java;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class p022 {

	public static void main(String[] args) {
		
		long sum = 0;
		
		List<String> names = getNames();
		
		// If this sort method wasn't available, I'd use radix sort
		Collections.sort(names);
		
		int temp;
		String name;
		for(int i=0; i<names.size(); i++){
			temp = 0;
			name = names.get(i);
			for(int y=0; y<name.length(); y++)
				temp += name.charAt(y)-64;
			sum += temp * (i+1);
			
			System.out.print(name + " = (");
			for(int y=0; y<name.length(); y++)
				System.out.print(name.charAt(y)-64 + " + ");
			System.out.println(")* " + (i+1) + " = " + temp * (i+1));
			
		}
		
		System.out.print("The total of all the name scores in the file is " + sum);
		
	}

	private static List<String> getNames() {
		
		List<String> names = new ArrayList<String>();
		
		try {
			Scanner sc = new Scanner(new File("p022.txt"));
			sc.useDelimiter(",");
			
			while(sc.hasNext())
				names.add(sc.next().replaceAll("\"", ""));
			
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return names;
	}

}
