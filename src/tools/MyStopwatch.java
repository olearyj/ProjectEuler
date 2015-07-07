package tools;

/**
 * This class will help keep track of how long something takes
 * 
 * @author James O'Leary
 *
 */
public class MyStopwatch {

	private long startTime, stopTime;
	
	public MyStopwatch(){
		startTime = 0;
		stopTime = -1;
	}
	
	/**
	 * Start the timer
	 * 
	 * @return this
	 */
	public MyStopwatch start(){
		startTime = System.currentTimeMillis();
		return this;
	}
	
	/**
	 * Stop the timer
	 * 
	 * @return this
	 */
	public MyStopwatch stop(){
		stopTime = System.currentTimeMillis();
		return this;
	}
	
	/**
	 * @return the difference of the start time and the stop time
	 */
	public long diff(){
		if(stopTime == -1)
			throw new RuntimeException("MyStopwatch: I was never stopped!");
		return startTime - stopTime;
	}
	
	public String diffFormatted(){
		long diff = diff();
		long second = (diff / 1000) % 60;
		long minute = (diff / (1000 * 60)) % 60;
		long hour = (diff / (1000 * 60 * 60)) % 24;
		long millis = diff % 1000;

		return String.format("%02d:%02d:%02d.%03d", hour, minute, second, millis);
	}
	
	public void print(){
		//System.out.println("Time duration(ms): " + diff());
		System.out.println("Time duration(HH:mm:ss.SSS): " + diffFormatted());
	}
	
}