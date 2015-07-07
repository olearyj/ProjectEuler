package java;

import tools.MyStopwatch;


public class p017 {

	public static void main(String[] args) {

		MyStopwatch sw = new MyStopwatch().start();

		int total = 0;
		
		String num;
		for(int i=1; i<=1000; i++){
			num = numInWords(i);
			System.out.printf("[%02d] " + num + "\n", num.replaceAll("[- ]", "").length());
			total += num.replaceAll("[- ]", "").length();
		}

		System.out.println("If all the numbers from 1 to 1000 (one thousand) " +
				"inclusive were written out in words, how many letters would be " +
				"used? " + total);
		
		sw.stop().print();
		
	}
	
	static String[] s1to9 = {"one", "two", "three", "four", "five", "six", "seven",
			"eight", "nine"};
	static String[] s11to19 = {"eleven", "twelve", "thirteen", "fourteen", "fifteen",
			"sixteen", "seventeen", "eighteen", "nineteen"};
	static String[] sTens = {"ten", "twenty", "thirty", "forty", "fifty", "sixty",
			"seventy", "eighty", "ninety"};
	static String hundred = "hundred", thousand = "thousand", sp = " ", hi = "-";
	
	public static String numInWords(int num){
		String str = "";
		int m = num%100, n = num%10;
		
		if(num == 1000)
			return "one " + thousand;
		if(num>99)
			str += s1to9[(num/100)-1] + sp + hundred + (m==0 ? "" : " and ");
		if(m != 0){
			if(m>10 && m<20)
				str += s11to19[m-11];
			else{
				if(m>9)
					str += sTens[(m/10)-1] + (n==0 ? "" : hi);
				if(n!=0)
					str += s1to9[n-1];
			}
		}
			
		
		
		return str;
	}
	
}