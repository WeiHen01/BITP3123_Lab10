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
		System.out.println("SQL Statement to CREATE a table " + name);
		System.out.println("CREATE TABLE " + name + "\n");
		System.out.println("Primary Key\t BOOLEAN\t PRIMARY KEY");
		System.out.println("Name\t\t VARCHAR(20)\t NOT NULL");
		System.out.println("Type\t\t VARCHAR(20)\t NOT NULL\n");
	}
	
	// generate SQL INSERT record statement in the list of field
	public void InsertRecord()
	{
		System.out.println("SQL Statement to INSERT a record into table " + name);
		System.out.println("INSERT INTO " + name);
		System.out.print("VALUES ");
		
		//check for multiple records to be inserted
		for (int i = 0; i < fields.size(); i++)
		{
			System.out.print("('" + fields.get(i).isPrimaryKey() + "', '"
					+ fields.get(i).getName() + "', '" + fields.get(i).getType() + "')");
			
			// validate for multiple records
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
		System.out.println("SQL Statement to UPDATE a record to table " + name);
		
		// update name of certain record if primary key is true
		for (int i = 0; i < fields.size(); i++)
		{
			if(fields.get(i).isPrimaryKey() == true) {
				// before update
				System.out.println("Before update: ");
				System.out.println(fields.get(i).isPrimaryKey() + "\t\t" 
								+ fields.get(i).getName() + "\t" + fields.get(i).getType());
				
				// update name of record to the table based on the task name
				System.out.print("\nUPDATE " + name + " SET ");
				
				// IF it's lecturer, update the record in Lecturer table
				if(name == "Lecturer") {
					fields.get(i).setName("Pn Emaliana");
					fields.get(i).setType("Lecturer DAD");
					System.out.println("name = " + fields.get(i).getName()
							+ " WHERE primary key = " + fields.get(i).isPrimaryKey());
				}
				// ELSE IF it's student, update the record in Student table
				else if(name == "Student") {
					fields.get(i).setName("Teoh Jia Qi");
					System.out.println("name = " + fields.get(i).getName()
							+ " WHERE primary key = " + fields.get(i).isPrimaryKey());
				}
				// ELSE IF it's school, update the record in School table
				else if(name == "School") {
					fields.get(i).setName("UUM");
					System.out.println("name = " + fields.get(i).getName()
							+ " WHERE primary key = " + fields.get(i).isPrimaryKey());
				}
				// else it's subject, update the record in Subject table
				else {
					fields.get(i).setName("Calculus");
					fields.get(i).setType("BITI1223");
					System.out.println("name = " + fields.get(i).getName()
							+ " WHERE primary key = " + fields.get(i).isPrimaryKey());
				}
				
				// display the record after update is done
				System.out.println("\nAfter update: ");
				System.out.println(fields.get(i).isPrimaryKey() + "\t\t" 
						+ fields.get(i).getName() + "\t" + fields.get(i).getType());
			}
		}

	}
	
	// generate SQL SELECT ALL statement in the list of field
	public void SelectAll()
	{
		System.out.println("\nSQL Statement to SELECT ALL records from table" + name);
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
		System.out.println("SQL Statement to SELECT a certain record from table " + name);
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
		// display SQL DELETE statement
		System.out.println("SQL Statement to DELETE a certain record from table " + name);
		System.out.println("DELETE FROM " + name + " WHERE PRIMARY KEY = true" + "\n");
		
		// display current records before delete
		System.out.println("Before delete, the current records: ");
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
		
		// display the record after delete record is done
		System.out.println("");
		System.out.println("After delete, the current records: ");
		
		for (int j = 0; j < fields.size(); j++) {
			System.out.println(fields.get(j).isPrimaryKey() + "\t\t" 
					+ fields.get(j).getName() + "\t" + fields.get(j).getType());
		}
		System.out.println("");
	}
	
	// Generate DROP statement to delete a entity 
	public void DropTable()
	{
		System.out.println("SQL Statement to DROP table " + name);
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
