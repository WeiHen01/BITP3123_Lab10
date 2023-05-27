package scheduledtask1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * This class represent a task.
 * 
 * @author emalianakasmuri
 *
 */

public class Task implements Runnable {
	
	private String name;
	
	/**
	 * Constructor - initialize field
	 * 
	 * @param name
	 */
	public Task(String name) {
		this.name = name;
	}

	/**
	 * Task: Display task name and current date
	 */
	@Override
	public void run() {
		
		// Formatting current date
		String pattern = "dd/MM/yyyy HH:mm:ss";
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);  
		
		// Get current time
		LocalDateTime now = LocalDateTime.now();  
		
		// Display task and execution time
		System.out.println("\nTask " + name + " executed on : " + dtf.format(now));

	}

}
