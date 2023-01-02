import java.sql.Connection;
import java.sql.Statement;

public class Guests {
	static String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";

	  
    static String user = "sa";
    static String pass = "root";
	 public static void creatingGuestsTable(){

		 
	        
		 String sql = "CREATE TABLE Guests (" +
                 "id INTEGER PRIMARY KEY," +
                 "guest_name VARCHAR(255) NOT NULL," +
                 "guest_phone VARCHAR(255) NOT NULL," +
                 "guest_accompanying_members INTEGER NOT NULL," +
                 "guest_payment_amount INTEGER NOT NULL," +
                 "room_id INTEGER FOREIGN KEY REFERENCES Rooms(id)," +
                 "hotel_id INTEGER FOREIGN KEY REFERENCES Hotels(id)," +
                 "created_date DATE NOT NULL," +
                 "updated_date DATE," +
                 "is_Active BOOLEAN NOT NULL" +
                 ")";
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
	    }
}
