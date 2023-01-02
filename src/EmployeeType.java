import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;

public class EmployeeType {
	static String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";

	  
    static String user = "sa";
    static String pass = "root";
	 public static void creatingEmployeeTypeTable(){

	        String sql = "CREATE TABLE Employee_Type " +
                    "(id INTEGER PRIMARY KEY, " +
                    "employee_type_name TEXT NOT NULL, " +
                    " created_date DATE NOT NULL, " +
                    " updated_date DATE, " +
                    "is_active BIT NOT NULL) " ;

	        Connection con = null;

	        // Try block to check for exceptions
	        try {

	        	   Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
		            // Registering drivers
		            DriverManager.registerDriver(driver);

		            // Reference to connection interface
		            con = DriverManager.getConnection(url, user,
		                    pass);
	            Statement st = con.createStatement();

	            // Executing query
	            int m = st.executeUpdate(sql);
	            if (m <=  0)
	                System.out.println("Created successfully : " + sql);
	            else
	                System.out.println("creating table failed");

	            // Closing the connections
	            con.close();
	        }


	        catch (Exception ex) {
	        
	            System.err.println(ex);
	        }
	    }
}
