package hby;

public class StatisticInfo {
	
	private static int count = 1;
	
	public static synchronized int getCount(){
	
		return count++; 
	}

}