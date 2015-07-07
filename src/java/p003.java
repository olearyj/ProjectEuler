package java;
import java.math.BigInteger;

import tools.MyStopwatch;


public class p003{

	public static final BigInteger num = new BigInteger("600851475143");

	public static void main(String args[]){

		MyStopwatch sw = new MyStopwatch().start();

		BigInteger q = BigInteger.ZERO;
		for(BigInteger i=new BigInteger("2"); i.compareTo( num.divide(new BigInteger("2")) ) == -1; i = i.add(BigInteger.ONE)){
			//System.out.println(i);
			if(isZero( num.mod(i) )){
				q = num.divide(i);
				if(isPrime(q)){
					i = new BigInteger("99999999999999999");
				}
			}
		}

		
		System.out.println("The largest prime factor of the number of " + num +
				" is " + q);
		sw.stop().print();

	}

	public static boolean isPrime(BigInteger big){
		for(BigInteger i=new BigInteger("2"); i.compareTo( big.divide(new BigInteger("2")) ) == -1; i = i.add(BigInteger.ONE)){
			if(isZero( big.mod(i) ))
				return false;
			//System.out.println("isPrime" + i);
		}
		return true;
	}

	public static boolean isZero(BigInteger big){
		return big.equals(BigInteger.ZERO);
	}

	public static boolean isNO(BigInteger big){
			return big.equals(new BigInteger("-1"));
	}

}