package Exercise7;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.List;
import java.util.ArrayList;

import Exercise7.TableTask;
import Exercise7.Field;

/* This is the application to do multiple delay task
 * 
 * @author Ng Wei Hen
 * 
 */
public class ScheduledMultipleDelayTaskApp {

	public static void main(String [] args)
	{
		System.out.println("Implementing a scheduled multiple delay task.");
		
		// Get a pool to schedule threads
		ScheduledExecutorService scheduledExecutor = Executors.newScheduledThreadPool(7);
		
		// Formatting current date
		String pattern = "dd/MM/yyyy HH:mm:ss";
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);  
		LocalDateTime now = LocalDateTime.now();  
		
		// Display current time to mark the execution from the main( ) 
	    System.out.println("Task scheduled to execute after 5 seconds at : " + dtf.format(now) + "\n");
	  
	    // Execute task for 5 seconds after the application starts
	    
	    // create object for field School
	    Field school = new Field();
	    school.setPrimaryKey(true);
	    school.setName("UTeM");
	    school.setType("University");
	    
	    Field school1 = new Field();
	    school1.setPrimaryKey(false);
	    school1.setName("UNIMAP");
	    school1.setType("University");
	    
	    // create object of list of field for schools
	    List<Field> schools = new ArrayList<Field>();
	    schools.add(school);
	    schools.add(school1);
	    
	    
	    // create object for field Lecturer
	    Field lecturer = new Field();
	    lecturer.setPrimaryKey(false);
	    lecturer.setName("Pn Sabrina");
	    lecturer.setType("Lecturer SRD");
	    
	    Field lecturer2 = new Field();
	    lecturer2.setPrimaryKey(true);
	    lecturer2.setName("Pn Halizah");
	    lecturer2.setType("Lecturer AI");
	    
	    Field lecturer3 = new Field();
	    lecturer3.setPrimaryKey(false);
	    lecturer3.setName("Pn Raja Rina");
	    lecturer3.setType("Lecturer SVV");
	    
	    // create object of list of field for lecturers
	    List<Field> lecturers = new ArrayList<Field>();
	    lecturers.add(lecturer);
	    lecturers.add(lecturer2);
	    lecturers.add(lecturer3);
	    
	    
	    // create object for field Student
	    Field student1 = new Field();
	    student1.setPrimaryKey(true);
	    student1.setName("Ng Wei Hen");
	    student1.setType("BITS");
	    
	    Field student2 = new Field();
	    student2.setPrimaryKey(false);
	    student2.setName("Macaurel Noel");
	    student2.setType("BITS");
	    
	    Field student3 = new Field();
	    student3.setPrimaryKey(false);
	    student3.setName("Lau Chi Chien");
	    student3.setType("BITS");
	    
	    // create object of list of field for students
	    List<Field> students = new ArrayList<Field>();
	    students.add(student1);
	    students.add(student2);
	    students.add(student3);
	    
	    
	    // create object for field Subject
	    Field subject1 = new Field();
	    subject1.setPrimaryKey(true);
	    subject1.setName("Distributed Application");
	    subject1.setType("BITP3123");
	    
	    Field subject2 = new Field();
	    subject2.setPrimaryKey(false);
	    subject2.setName("Software Engineering");
	    subject2.setType("BITP2213");
	    
	    Field subject3 = new Field();
	    subject3.setPrimaryKey(false);
	    subject3.setName("Artificial Intelligence");
	    subject3.setType("BITI1113");
	    
	    // create object of list of field for subjects
	    List<Field> subjects = new ArrayList<Field>();
	    subjects.add(subject1);
	    subjects.add(subject2);
	    subjects.add(subject3);
	    
	    // Execute task 3 seconds after the application starts
	    Runnable task1 = new TableTask("School", schools);
	    Runnable task2 = new TableTask("Lecturer", lecturers);
	    Runnable task3 = new TableTask("Student", students);
	    Runnable task4 = new TableTask("Subject", subjects);
	    
	    // delay task1 for 8 seconds
	    ScheduledFuture<?> result1 = 
	    		scheduledExecutor.schedule(task1, 8, TimeUnit.SECONDS);

	    // delay task1 for 3 seconds
	    ScheduledFuture<?> result2 = 
	    		scheduledExecutor.schedule(task2, 3, TimeUnit.SECONDS);
	    
	    // delay task1 for 18 seconds
	    ScheduledFuture<?> result3 = 
	    		scheduledExecutor.schedule(task3, 18, TimeUnit.SECONDS);
	    
	    // delay task1 for 13 seconds
	    ScheduledFuture<?> result4 = 
	    		scheduledExecutor.schedule(task4, 13, TimeUnit.SECONDS);
	    
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
