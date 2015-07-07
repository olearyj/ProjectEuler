package java_solutions;
import java.util.Date;

public class p019 {

	@SuppressWarnings("deprecation")
	public static void main(String[] args){
		
		Date start = new Date(1, 0, 1);
		Date end = new Date(100, 11, 31);
		int count = 0;	// Sundays fell on the first of the month

		System.out.println("The state date is " + start);
		System.out.println("The end date is " + end);
		
		Date temp = (Date) start.clone();
		while(temp.before(end)){
			// Change date to the next day
			temp = new Date(temp.getTime() + (1000 * 60 * 60 * 24));
			if(temp.getDate() == 1 && temp.getDay() == 0)
				count++;
		}
		
		System.out.println("Sundays fell on the first of the month is " + count);
		
	}
	
}
