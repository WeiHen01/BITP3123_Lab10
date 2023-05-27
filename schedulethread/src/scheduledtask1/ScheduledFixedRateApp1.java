package scheduledtask1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;


/**
 * This class demonstrates periodical execution of a task.  The task will be 
 * executed in every 10 seconds.
 * 
 * @author emalianakasmuri
 *
 */
public class ScheduledFixedRateApp1 {
	
public static void main(String[] args) {
	
		System.out.println("Demonstration of a scheduled task at a fixed "
				+ "periodical time.");
		
		
		// Get a pool to schedule threads
		ScheduledExecutorService scheduledExecutor = 
				Executors.newScheduledThreadPool(1);
		
		// Formatting current date
		String pattern = "dd/MM/yyyy HH:mm:ss";
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern); 
		
		// Display current time
		LocalDateTime now = LocalDateTime.now();  
	    System.out.println("Task scheduled to execute after 10 seconds at : " 
	    		+ dtf.format(now));
	    
	    // Execute the task in every 10 seconds
	    // The execution begin 10 seconds after the application has started.
	    Runnable task = new Task("App-Task");
	    ScheduledFuture<?> scheduledFuture = 
	    		scheduledExecutor.scheduleAtFixedRate(
	    				task, 10, 10, TimeUnit.SECONDS);
	    
	    System.out.println("Shutdown and await requested at : " 
	    		+ dtf.format(now));
	    
	}

}
