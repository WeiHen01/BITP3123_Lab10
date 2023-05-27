package Exercise7;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ArrayList;

/* This is the table task to generate SQL statement for executing multiple delay task
 * 
 * @author Ng Wei Hen
 * 
 */

public class TableTask implements Runnable{
	
	// attributes
	private List<Field> fields = new ArrayList<Field>();
	private String name;
	
	// default constructor
	public TableTask(String name, List<Field> fields)
	{
		this.name = name;
		this.fields = fields;
	}
	
	// generate SQL CREATE table statement
	public void CreateTable()
	{
		System.out.println("SQL Statement to CREATE a table:");
		System.out.println("CREATE TABLE " + name + "\n");
	}
	
	// generate SQL INSERT record statement in the list of field
	public void InsertRecord()
	{
		System.out.println("SQL Statement to INSERT a record");
		System.out.println("INSERT INTO " + name);
		System.out.print("VALUES ");
		
		//check for multiple records to be inserted
		for (int i = 0; i < fields.size(); i++)
		{
			System.out.print("('" + fields.get(i).isPrimaryKey() + "', '"
					+ fields.get(i).getName() + "', '" + fields.get(i).getType() + "')");
			
			//validate for multiple records
			if(i < fields.size() - 1) {
				System.out.println(", ");
			}
		}
		System.out.println("\n");
	}
	
	// generate SQL UPDATE record statement in the list of field
	public void UpdateRecord()
	{	
		// display SQL UPDATE Statement
		System.out.println("SQL Statement to UPDATE a record");
		
		// update name of certain record if primary key is true
		for (int i = 0; i < fields.size(); i++)
		{
			if(fields.get(i).isPrimaryKey() == true) {
				// before update
				System.out.println("Before update, name = " + fields.get(i).getName()
						+ ", type = " + fields.get(i).getType());
				
				// update name of record based on the task name
				System.out.print("UPDATE " + name + " SET ");
				
				// IF it's lecturer
				if(name == "Lecturer") {
					fields.get(i).setName("Pn Emaliana");
					fields.get(i).setType("Lecturer DAD");
					System.out.print("name = " + fields.get(i).getName()
							+ " WHERE primary key = " + fields.get(i).isPrimaryKey());
				}
				// ELSE IF it's student
				else if(name == "Student") {
					fields.get(i).setName("Teoh Jia Qi");
					System.out.print("name = " + fields.get(i).getName()
							+ " WHERE primary key = " + fields.get(i).isPrimaryKey());
				}
				// ELSE IF it's school
				else if(name == "School") {
					fields.get(i).setName("UUM");
					System.out.print("name = " + fields.get(i).getName()
							+ " WHERE primary key = " + fields.get(i).isPrimaryKey());
				}
				// if it's subject
				else {
					fields.get(i).setName("Calculus");
					fields.get(i).setType("BITI1223");
					System.out.print("name = " + fields.get(i).getName()
							+ " WHERE primary key = " + fields.get(i).isPrimaryKey());
				}

			}
		}
		System.out.println("\n");

	}
	
	// generate SQL SELECT ALL statement in the list of field
	public void SelectAll()
	{
		System.out.println("SQL Statement to SELECT ALL record");
		System.out.println("SELECT * FROM " + name + "\n");

		// display all records in the list of field
		for (int i = 0; i < fields.size(); i++) {
			System.out.println(fields.get(i).isPrimaryKey() + "\t\t" 
					+ fields.get(i).getName() + "\t" + fields.get(i).getType());
		}
		System.out.println("");
	}
	
	// generate SQL SELECT statement in the list of field
	public void SelectRecord()
	{
		System.out.println("SQL Statement to SELECT a certain record");
		System.out.println("SELECT FROM " + name + " WHERE PRIMARY KEY = true" + "\n");
		
		// display the record if the primary key is true
		for (int i = 0; i < fields.size(); i++) {
			if (fields.get(i).isPrimaryKey() == true)
			{
				System.out.println(fields.get(i).isPrimaryKey() + "\t\t" 
						+ fields.get(i).getName() + "\t" + fields.get(i).getType());
			}
		}
		System.out.println("");
	}
	
	// generate SQL DELETE statement in the list of field
	public void DeleteRecord()
	{
		System.out.println("SQL Statement to DELETE a certain record");
		System.out.println("DELETE FROM " + name + " WHERE PRIMARY KEY = true" + "\n");
		System.out.println("Before delete, the records: ");
		for (int i = 0; i < fields.size(); i++) {
			System.out.println(fields.get(i).isPrimaryKey() + "\t\t" 
					+ fields.get(i).getName() + "\t" + fields.get(i).getType());
		}
		System.out.println("");
		
		for (int i = 0; i < fields.size(); i++) {
			if (fields.get(i).isPrimaryKey() == true)
			{
				// display if the record is match
				System.out.println("The record to be deleted: ");
				System.out.println(fields.get(i).isPrimaryKey() + "\t\t" 
						+ fields.get(i).getName() + "\t" + fields.get(i).getType());
				
				// remove the record
				fields.remove(i);
			}
		}
		System.out.println("");
		System.out.println("After delete, the records: ");
		// display the record after delete record is done
		for (int j = 0; j < fields.size(); j++) {
			System.out.println(fields.get(j).isPrimaryKey() + "\t\t" 
					+ fields.get(j).getName() + "\t" + fields.get(j).getType());
		}
		System.out.println("");
	}
	
	public void DropTable()
	{
		System.out.println("SQL Statement to DROP a table");
		System.out.println("DROP TABLE " + name + "\n");
	}

	@Override
	public void run() {
		
		//Formatting current date
		String pattern = "dd/MM/yyyy HH:mm:ss";
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);  
		
		// Get current time
		LocalDateTime now = LocalDateTime.now();  
		
		// Display task and execution time
		System.out.println("Generation of SQL Statements \n");
		CreateTable();
		DropTable();
		InsertRecord();
		UpdateRecord();
		SelectAll();
		SelectRecord();
		DeleteRecord();
		
		System.out.println("Task SQL Statement Generation for table " + name
				+ " is executed on: "  + dtf.format(now));
		
	}

}
