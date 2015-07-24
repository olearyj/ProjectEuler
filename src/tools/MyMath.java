package tools;

import java.util.ArrayList;
import java.util.List;

public class MyMath {

	public static List<Integer> properDivisors(int num){
		
		List<Integer> pd = new ArrayList<Integer>();
		
		for(int i=1; i<num; i++)
			if(num % i == 0)
				pd.add(i);
		
		return pd;
	}
	
}
