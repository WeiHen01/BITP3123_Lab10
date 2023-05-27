package scheduledtask1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * This class demonstrate execution of a task in 10 seconds after the 
 * application program has started.
 * 
 * 
 * 
 * @author emalianakasmuri
 *
 */
public class ScheduledExecutorApp2 {

	public static void main(String[] args) {
		
		System.out.println("Demonstration of a scheduled task.");
		
		// Get a pool to schedule threads
		ScheduledExecutorService scheduledExecutor = 
				Executors.newScheduledThreadPool(2);
		
		// Formatting current date
		String pattern = "dd/MM/yyyy HH:mm:ss";
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);  
		LocalDateTime now = LocalDateTime.now();  
		
		// Display current time to mark the execution from the main( ) 
	    System.out.println("Task scheduled to execute after 10 seconds at : " 
	    		+ dtf.format(now));
	    
	    // Execute task 10 seconds after the application starts
	    Runnable task1 = new Task("App-Task1");
	    Runnable task2 = new Task("App-Task2");
	    Runnable task3 = new Task("App-Task3");
	    
	    //delay for 13 seconds
	    ScheduledFuture<?> result1 = 
	    		scheduledExecutor.schedule(task1, 13, TimeUnit.SECONDS);
	    //delay for 15 seconds
	    ScheduledFuture<?> result2 = 
	    		scheduledExecutor.schedule(task2, 15, TimeUnit.SECONDS);
	    ScheduledFuture<?> result3 = 
	    		scheduledExecutor.schedule(task3, 10, TimeUnit.SECONDS);
	    
	    System.out.println("Shutdown and await requested at : " 
	    		+ dtf.format(now));
	    
	    shutdownAndAwaitTermination(scheduledExecutor);

	}
	
	/**
	 * This method disable more from being submitted.
	 * 
	 * @param executorService
	 */
	static void shutdownAndAwaitTermination(ExecutorService executorService) {
		
		executorService.shutdown();
		
		try {
			if (!executorService.awaitTermination(1, TimeUnit.MINUTES)) {
				executorService.shutdownNow();
			}
		} catch (InterruptedException ie) {
			executorService.shutdownNow();
			Thread.currentThread().interrupt();
		}
	}

}
