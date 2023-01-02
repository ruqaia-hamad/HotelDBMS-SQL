import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;

public class RoomType {
	static String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";

	  
    static String user = "sa";
    static String pass = "root";
	 public static void creatingRoomTypeTable(){

		  String sql = "CREATE TABLE Room_Type " +
                  "(id INTEGER PRIMARY KEY, " +
                  " room_type_name VARCHAR(255) NOT NULL, " +
                  " created_date DATE, " +
                  " updated_date DATE, " +
                  " is_Active BIT NOT NULL)";
	        
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
	    }}

