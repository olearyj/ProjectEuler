package tools;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Fibonacci implements Iterable<BigInteger> {

	/**
	 * Returns the index of the first term in the Fibonacci sequence to contain x digits
	 * 
	 * @param x	Number of digits were looking for
	 */
	public static BigInteger indexOfFirstXDigits(int x){
		BigFibIterator it = (BigFibIterator) new Fibonacci().iterator();
		BigInteger big;
		
		while(it.hasNext()){
			big = it.next();
			if(big.toString().length() >= x)
				return it.getIndex();
		}
		
		return null;
	}

	/**
	 * Unimplemented
	 */
	@Override
	public void forEach(Consumer<? super BigInteger> arg0) {
	}

	@Override
	public Iterator<BigInteger> iterator() {
		return new BigFibIterator();
	}

	/**
	 * Unimplemented
	 */
	@Override
	public Spliterator<BigInteger> spliterator() {
		return null;
	}

}

/**
 * This class uses the BigInteger class
 * 
 * @author Owner
 *
 */
class BigFibIterator implements Iterator<BigInteger> {
	
	private BigInteger index;
	private BigInteger first = BigInteger.ONE;
	private BigInteger second = BigInteger.ONE;
	private BigInteger third;
	
	/**
	 * Index will start at 1 for the first number
	 */
	public BigFibIterator(){
		index = BigInteger.ZERO;
	}

	/**
	 * Unimplemented
	 */
	@Override
	public void forEachRemaining(@SuppressWarnings("rawtypes") Consumer arg0) {
	}

	@Override
	public boolean hasNext() {
		return true;
	}

	@Override
	public BigInteger next() {
		BigInteger next;
		index = BigInt.add1(index);
		
		if( index == BigInteger.ONE || index.equals(new BigInteger("2")) ){
			next = BigInteger.ONE;
		} else if(index.equals(new BigInteger("3"))) {
			third = first.add(second);
			next = third;
		} else {
			first = second;
			second = third;
			third = first.add(second);
			next = third;
		}

		return next;
	}
	
	public BigInteger getIndex(){
		return index;
	}

	/**
	 * Unimplemented
	 */
	@Override
	public void remove() {
	}
	
}
