package java;

import tools.MyStopwatch;


public class p009 {

	public static void main(String[] args) {

		int d = 1000;	// a + b + c = d
		
		MyStopwatch sw = new MyStopwatch().start();
		
		int prod = find2(d);
		
		System.out.println("There exists exactly one Pythagorean triplet for which a + b + c = 1000." +
				"Find the product abc. " + prod);
		
		sw.stop().print();
		
	}

	public static boolean test(int a, int b, int c, int d){
		if(a + b + c == d && a*a + b*b == c*c && a < c && b < c && a != b)
			return true;
		return false;
	}
	
	public static int find(int d){
		int prod = 0;
		for(int c=d; c>0; c--)
			for(int b=d; c>0; b--)
				for(int a=d; a>0; a--)
					if(test(a,b,c,d)){
						System.out.println("a=" + a + " b=" + b + " c=" + c);
						prod = a*b*c;
						return prod;				
					}
		return prod;
	}
	
	public static int find2(int d){
		int prod = 0;
		for(int a=1; a<d; a++)
			for(int b=1; b<d; b++)
				for(int c=1; c<d; c++)
					if(test(a,b,c,d)){
						System.out.println("a=" + a + " b=" + b + " c=" + c);
						prod = a*b*c;
						return prod;				
					}
		return prod;
	}
	
}
