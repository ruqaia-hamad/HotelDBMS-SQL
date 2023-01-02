import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;

public class Employees {

	  
    static String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";

  
    static String user = "sa";
    static String pass = "root";
	 public static void creatingEmployeeTable(){

		 
	        
		 String sql = "CREATE TABLE Employees (id INTEGER PRIMARY KEY,"
		 		+ " employee_type_id INTEGER FOREIGN KEY REFERENCES Employee_Type(id),"
		 		+ " room_id INTEGER FOREIGN KEY REFERENCES Rooms(id),"
		 		+ " created_date DATE NOT NULL,"
		 		+ " updated_date DATE, is_Active BOOLEAN NOT NULL)";

	        Connection con = null;

	        // Try block to check for exceptions
	        try {
	            Statement st = con.createStatement();

	            // Executing query
	            int m = st.executeUpdate(sql);
	            if (m >  0)
	                System.out.println("Created successfully : " + sql);
	            else
	                System.out.println("creating table failed");

	            // Closing the connections
	            con.close();
	        }


	        catch (Exception ex) {
	        
	            System.err.println(ex);
	        }
	    }}