package tools;

import java.math.BigInteger;

/**
 * Too bad there's no operator overloading in Java like there is in C++
 * 
 * This is a helper class for me
 * 
 * @author Owner
 *
 */
public class BigInt {

	/**
	 * Method to see if x is greater than y
	 */
	public static boolean gt(BigInteger x, BigInteger y){
		return (x.compareTo(y) == 1 ? true : false);
	}
	
	/**
	 * Method to see if x is less than y
	 */
	public static boolean lt(BigInteger x, BigInteger y){
		return (x.compareTo(y) == -1 ? true : false);
	}
	
	/**
	 * Method to check if x is numerically equal to y
	 */
	public static boolean eq(BigInteger x, BigInteger y){
		return (x.compareTo(y) == 0 ? true : false);
	}
	
	public static BigInteger add1(BigInteger x){
		return x.add(BigInteger.ONE);
	}
	
	public static BigInteger sub1(BigInteger x){
		return x.subtract(BigInteger.ONE);
	}

}
