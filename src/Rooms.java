import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

public class Rooms {
	static String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";

	static String user = "sa";
	static String pass = "root";

	public static void creatingRoomsTable() {

		String sql = "CREATE TABLE Rooms (id INTEGER PRIMARY KEY IDENTITY(1,1),"
				+ " room_type_id INTEGER FOREIGN KEY REFERENCES Room_Type(id)"
				+ ", hotel_id INTEGER FOREIGN KEY REFERENCES Hotels(id)" + ", created_date DATE NOT NULL, "
				+ "updated_date DATE, " + "is_Active BIT NOT NULL)";

		Connection con = null;

		// Try block to check for exceptions
		try {

			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			// Registering drivers
			DriverManager.registerDriver(driver);

			// Reference to connection interface
			con = DriverManager.getConnection(url, user, pass);
			Statement st = con.createStatement();

			// Executing query
			int m = st.executeUpdate(sql);
			if (m <= 0)
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

	public static void InsertIntoTable() {

		String sql = "INSERT INTO Room_Type (room_type_id,hotel_id , created_date, updated_date, is_Active)\r\n"
				+ "VALUES (1, 1,'2022-01-01', '2022-01-01', 1),\r\n"
				+ "       (2,2, '2022-01-02', '2022-01-02', 1),\r\n"
				+ "       (3,3 ,'2022-01-03', '2022-01-03', 1);";
		Connection con = null;

		try {

			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			// Registering drivers
			DriverManager.registerDriver(driver);

			// Reference to connection interface
			con = DriverManager.getConnection(url, user, pass);
			Statement st = con.createStatement();

			// Executing query
			int m = st.executeUpdate(sql);
			if (m >1)
				System.out.println("Inserted successfully : " + sql);
			else
				System.out.println("Inserting failed");

			// Closing the connections
			con.close();
		}

		catch (Exception ex) {

			System.err.println(ex);
		}}


	public static void readFromTable(int numOfRows) {

		String sql = "SELECT * FROM Rooms";
		Connection con = null;
		PreparedStatement pstmt = null;
		Scanner sc = new Scanner(System.in);

		try {
			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			// Registering drivers
			DriverManager.registerDriver(driver);

			// Reference to connection interface
			con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			int count = 0;
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next() && count < numOfRows) {
				int id = rs.getInt("id");
				int room_type_id = rs.getInt("room_type_id");
				int hotel_id = rs.getInt("hotel_id");
				Date createdDate = rs.getDate("created_date");
				Date updatedDate = rs.getDate("updated_date");
				boolean isActive = rs.getBoolean("is_Active");

				System.out.println(id + " " + room_type_id + " " + hotel_id + " " + createdDate + " " + updatedDate
						+ " " + isActive);
				count++;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void getById() throws Throwable {

		String sql = "SELECT * FROM Rooms WHERE id = ?";

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the id of the row to print: ");
		int id = sc.nextInt();
		Connection con = null;

		try {
			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			// Registering drivers
			DriverManager.registerDriver(driver);

			// Reference to connection interface
			con = DriverManager.getConnection(url, user, pass);
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				int roomTypeId = rs.getInt("room_type_id");
				int hostelId = rs.getInt("hotel_id ");
				Date createdDate = rs.getDate("created_date");
				Date updatedDate = rs.getDate("updated_date");
				boolean isActive = rs.getBoolean("is_Active");

				System.out.println(id + " " + hostelId + " " + roomTypeId + " " + createdDate + " " + createdDate + " "
						+ updatedDate + " " + isActive);
			} else {
				System.out.println("No row found with id " + id);
			}
		} catch (SQLException e) {
			System.out.println(e);

		}
	}

	public static void updateById() throws Throwable {

		String sql = "UPDATE Rooms SET id = ?,created_date = ?, updated_date = ? WHERE id = ?";

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the id of the row to update: ");
		int id = sc.nextInt();
		Connection con = null;

		try {
			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			// Registering drivers
			DriverManager.registerDriver(driver);

			// Reference to connection interface
			con = DriverManager.getConnection(url, user, pass);
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, 23);
			pstmt.setDate(2, new Date(System.currentTimeMillis()));
			pstmt.setDate(3, new Date(System.currentTimeMillis()));
			pstmt.setInt(4, id);
			pstmt.executeUpdate();

			String sql2 = "SELECT * FROM Rooms WHERE id = ?";
			PreparedStatement pstmt2 = con.prepareStatement(sql2);
			pstmt2.setInt(1, id);
			ResultSet rs = pstmt2.executeQuery();

			if (rs.next()) {
				int roomid = rs.getInt("id");
				int room_type_id = rs.getInt("room_type_id");
				int hotel_id = rs.getInt("hotel_id");
				Date createdDate = rs.getDate("created_date");
				Date updatedDate = rs.getDate("updated_date");
				boolean isActive = rs.getBoolean("is_Active");

				System.out.println(roomid + " " + room_type_id + " " + hotel_id + " " + createdDate + " " + updatedDate
						+ " " + isActive);

			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public static void deleteById() throws Throwable {

		String sql = "DELETE FROM Rooms WHERE id = ?";

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the id to be deleted : ");
		int id = sc.nextInt();
		Connection con = null;

		try {
			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			// Registering drivers
			DriverManager.registerDriver(driver);

			// Reference to connection interface
			con = DriverManager.getConnection(url, user, pass);
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeQuery();

			System.out.println("Row with id " + id + " deleted successfully!");
		} catch (SQLException e) {
			System.out.println(e);

		}
	}

	public static void makeIsActiveFalseById(int id) throws Throwable {
		Connection con = null;
		PreparedStatement stmt = null;

		try {
			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();

			DriverManager.registerDriver(driver);

			con = DriverManager.getConnection(url, user, pass);

			String sql = "UPDATE Rooms SET is_Active = false WHERE id = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	//-------------------------------------------
	
	


}




