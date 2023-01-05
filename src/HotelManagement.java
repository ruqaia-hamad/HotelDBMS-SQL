import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class HotelManagement {
	static String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";

	static String user = "sa";
	static String pass = "root";
	
	public static void checkGuestNameEdingWithE() throws Throwable {
		String sql = "SELECT * FROM Guests WHERE guest_name LIKE '%E' ";

		Connection con = null;
		PreparedStatement pstmt = null;
		// Try block to check for exceptions
		try {
			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			// Registering drivers
			DriverManager.registerDriver(driver);

			// Reference to connection interface
			con = DriverManager.getConnection(url, user, pass);
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
		  while (rs.next()) {
		    String guestName = rs.getString("guest_name");
		    System.out.println(guestName);
		  }
		  
		} catch (SQLException e) {
		System.out.println(e);
		}
		
	}
	
	public static void roomPaying() throws Throwable {
		String sql = "\r\n"
				+ "SELECT g.guest_payment_amount, t.room_type_name  ,r.id, r.room_type_id, r.hotel_id FROM Rooms r\r\n"
				+ "	             INNER JOIN Guests g ON r.id = g.room_id \r\n"
				+ "				 INNER JOIN Room_Type t ON t.id =r.room_type_id\r\n"
				+ "	            WHERE g.guest_payment_amount > 1000";

		Connection con = null;
		PreparedStatement pstmt = null;
		// Try block to check for exceptions
		try {
			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			// Registering drivers
			DriverManager.registerDriver(driver);

			// Reference to connection interface
			con = DriverManager.getConnection(url, user, pass);
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
		  while (rs.next()) {
		    String RoomName = rs.getString("room_type_name");
		    Integer paymentAmount=rs.getInt("guest_payment_amount");
		    System.out.println(RoomName +" " + paymentAmount);
		  }
		  
		} catch (SQLException e) {
		System.out.println(e);
		}
		
	}
	
	public static void countGuest() throws Throwable {
		String sql = "SELECT COUNT(*) FROM Guests INNER JOIN Rooms ON Guests.room_id = Rooms.id JOIN Room_Type ON Room_Type.room_Type_name ='DELUXE'";

		Connection con = null;
		PreparedStatement pstmt = null;
		// Try block to check for exceptions
		try {
			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			// Registering drivers
			DriverManager.registerDriver(driver);

			// Reference to connection interface
			con = DriverManager.getConnection(url, user, pass);
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
		  while (rs.next()) {
		    rs.getInt(1);
		    System.out.println("COUNT: "+   rs.getInt(1));
		  }
		  
		} catch (SQLException e) {
		System.out.println(e);
		}
		
	}

}



