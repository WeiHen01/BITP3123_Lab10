package Exercise4;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Task implements Runnable {

	private String task;
	private int total = 0;
	
	/**
	 * Constructor - initialize field
	 * 
	 * @param task
	 */
	public Task(String task)
	{
		this.task = task;
	}

	@Override
	public void run() {
		
		// creating Random object
		Random rd = new Random(); 
		
		// total up 100 random integers ranges 0 to 100
		for(int i = 0; i < 100; i++)
		{
			total = total + rd.nextInt(100 - 0 + 1);
		}
		
		// Formatting current date
		String pattern = "dd/MM/yyyy HH:mm:ss";
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);  
		
		// Get current time
		LocalDateTime now = LocalDateTime.now();  
		
		// Display task and execution time

		System.out.println("\nTask " + task + ": Total = " + total + ", executed on: "  + dtf.format(now));
			
	}
}
