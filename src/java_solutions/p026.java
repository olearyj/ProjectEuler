package java_solutions;

import java.math.BigDecimal;
import java.math.MathContext;

public class p026 {

	// Max denominator
	public static final int D_MAX = 1000;

	// For better readability
	public static final BigDecimal one = BigDecimal.ONE;

	public static MathContext mc;
	public static final MathContext mcU = MathContext.UNLIMITED;
	
	public static void main(String[] args) {

		mc = new MathContext(10000);	// 10000 digit big decimals
		
		int ans = 0;
		int biggest = 0;
		
		for(int i=2; i<D_MAX; i++){
			if(isRecurring(i)){
				//System.out.println("(1/" + i + ") = " + getFraction(i).toString().substring(0, 100));
				int recurring = getRecurring(getFraction(i)).length();
				if(recurring > biggest){
					biggest = recurring;
					ans = i;
				}
			}
		}
		
		System.out.println("The value of d < 1000 for which 1/d contains the " +
				"longest recurring cycle in its decimal fraction part is " + ans);
		
		System.out.println("The longest recurring cycle is " + biggest + " numbers long");
	}
	
	/**
	 * Takes a non-terminating big decimal and returns a String of the recurring cycle
	 * 
	 * @param num - non-terminating big decimal
	 * @return the recurring cycle
	 */
	public static String getRecurring(BigDecimal num){
		
		String str = num.toString().substring(2);
		String temp = "";
		String recur;

		// Iterate through the entire decimal
		for(int i=0; i<str.length(); i++){
			int loc = temp.indexOf(str.charAt(i));	// Location of the current number in the temp string
			// The current number could also be in the prefix. Check all locations of this num
			while(loc != -1){
				recur = temp.substring(loc);
				
				// Check if it is recurring
				int cycles = 4;	// How many cycles to check
				for(int j=1; j<=cycles; j++){
					String next = str.substring(i + recur.length()*j, i + recur.length()*(j+1));
					if(j==cycles){
						return recur;
					}
					if(!recur.equals(next)){
						j=cycles+1;
					}
				}
				
				loc = temp.indexOf(str.charAt(i), loc+1);
			}
			temp += str.charAt(i);
		}
		
		return "";
	}

	/**
	 * divides one by the divisor parameter
	 * @param divisor
	 * @return 1/divisor
	 */
	public static BigDecimal getFraction(int divisor){
		return one.divide(new BigDecimal(divisor), mc);
	}
	
	private static boolean isRecurring(int divisor){
		try{
			one.divide(new BigDecimal(divisor), mcU);
		} // The exception it thrown when the fraction is non-terminating
		catch(ArithmeticException e){
			return true;
		}
		return false;
	}
	
}
