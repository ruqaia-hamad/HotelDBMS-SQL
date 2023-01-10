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

public class Guests {
	static String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";

	static String user = "sa";
	static String pass = "root";
    public static void creatingGuestsTable() {

		String sql = "CREATE TABLE Guests (" + "id INTEGER PRIMARY KEY IDENTITY(1,1)," + "guest_name VARCHAR(255) NOT NULL,"
				+ "guest_phone VARCHAR(255) NOT NULL," + "guest_accompanying_members INTEGER NOT NULL,"
				+ "guest_payment_amount INTEGER NOT NULL," + "room_id INTEGER FOREIGN KEY REFERENCES Rooms(id),"
				+ "hotel_id INTEGER FOREIGN KEY REFERENCES Hotels(id)," + "created_date DATE NOT NULL,"
				+ "updated_date DATE," + "is_Active BIT NOT NULL" + ")";
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
    	
    	for(int m=0;m<=1000;m++) {
      
		String sql = "INSERT INTO Guests (guest_name,guest_phone ,guest_accompanying_members,guest_payment_amount,room_id,hotel_id,created_date,updated_date,is_Active) \r\n"
				+ "VALUES ('MUNA', '9677456',5,200,5,5,'2022-01-01', '2022-01-01', 1),\r\n"
				+ "       ('NORA', '9677452',2,1000,2,2,'2022-02-02', '2022-02-02', 1),\r\n"
				+ "      ('EMEE', '9675432',3,400,3,3,'2022-03-03', '2022-03-03', 1),\r\n"
				+ "       ('SALE', '9577452',4,1200,4,4,'2022-04-04', '2022-04-04', 1),\r\n"
				+ "      ('LAMA', '9377432',9,700,5,5,'2022-05-05', '2022-05-05', 1),\r\n"
				+ "       ('SUHA', '9277452',19,2000,6,6,'2022-02-06', '2022-02-06', 1),\r\n"
				+ "      ('MARIYA', '9677432',23,800,7,7,'2022-03-07', '2022-03-07', 1),\r\n"
				+ "      ('AHMED', '9977432',4,700,8,8,'2022-04-08', '2022-04-08', 1)\r\n";
		Connection con = null;

		try {

			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			// Registering drivers
			DriverManager.registerDriver(driver);

			// Reference to connection interface
			con = DriverManager.getConnection(url, user, pass);
			Statement st = con.createStatement();

			// Executing query
			int n = st.executeUpdate(sql);
			if (n >1)
				System.out.println("Inserted successfully : " + sql);
			else
				System.out.println("Inserting failed");

			// Closing the connections
			con.close();
		}

		catch (Exception ex) {

			System.err.println(ex);
		}}}
	public static void InsertIntoTable(int numOfRows) {

		String sql = "INSERT INTO Guests (guest_name,guest_phone ,guest_accompanying_members,guest_payment_amount,room_id,hotel_id,created_date,updated_date,is_Active) VALUES (?, ?,?, ?, ?,?,?,?,?)";
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			// Registering drivers
			DriverManager.registerDriver(driver);

			// Reference to connection interface
			con = DriverManager.getConnection(url, user, pass);
			pstmt = con.prepareStatement(sql);
			for (int i = 0; i < numOfRows; i++) {
				Random rn = new Random();
				Integer numberToAdd = rn.nextInt(100);
				String stringToAdd = "Ruqaia" + numberToAdd;
				boolean boolToAdd = true;

				pstmt.setString(1, stringToAdd);
				pstmt.setString(2, stringToAdd);
				pstmt.setInt(3, numberToAdd);
				pstmt.setInt(4, numberToAdd);
				pstmt.setInt(5, numberToAdd);
				pstmt.setInt(6, numberToAdd);
				pstmt.setDate(7, new Date(System.currentTimeMillis()));
				pstmt.setDate(8, new Date(System.currentTimeMillis()));
				pstmt.setBoolean(9, boolToAdd);
				pstmt.executeUpdate();
			}

			System.out.println(numOfRows + " rows inserted successfully!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void readFromTable(int numOfRows) {

		String sql = "SELECT * FROM Guests";
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
				Integer id = rs.getInt("id");
				String guestName = rs.getString("guest_name");
				String guestPhone = rs.getString("guest_phone");
				Integer accompanyingMembers = rs.getInt("guest_accompanying_members");
				Integer paymentAmount = rs.getInt("guest_payment_amount");
				Integer roomId = rs.getInt("room_id");
				Integer hotelId = rs.getInt("hotel_id");
				Date createdDate = rs.getDate("created_date");
				Date updatedDate = rs.getDate("updated_date");
				boolean isActive = rs.getBoolean("is_Active");

				System.out.println(
						id + " " + guestName + " " + guestPhone + " " + accompanyingMembers + " " + paymentAmount + " "
								+ roomId + " " + hotelId + " " + createdDate + " " + updatedDate + " " + isActive);
				count++;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void getById() throws Throwable {

		String sql = "SELECT * FROM Guests WHERE id = ?";

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
				String guestName = rs.getString("guest_name");
				Integer guestPhone = rs.getInt("guest_phone");
				Integer accompanyingMembers = rs.getInt("guest_accompanying_members");
				Integer paymentAmount = rs.getInt("guest_payment_amount");
				Integer roomId = rs.getInt("room_id");
				Integer hotelId = rs.getInt("hotel_id");
				Date createdDate = rs.getDate("created_date");
				Date updatedDate = rs.getDate("updated_date");
				boolean isActive = rs.getBoolean("is_Active");
				System.out.println(
						id + " " + guestName + " " + guestPhone + " " + accompanyingMembers + " " + paymentAmount + " "
								+ roomId + " " + hotelId + " " + createdDate + " " + updatedDate + " " + isActive);
			} else {
				System.out.println("No row found with id " + id);
			}
		} catch (SQLException e) {
			System.out.println(e);

		}
	}

	public static void updateById() throws Throwable {

		String sql = "UPDATE Guests SET guest_name = ?, guest_phone = ?,created_date = ?, updated_date = ? WHERE id = ?";

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
			pstmt.setString(1, "Muna");
			pstmt.setInt(2, 96756);
			pstmt.setDate(3, new Date(System.currentTimeMillis()));
			pstmt.setDate(4, new Date(System.currentTimeMillis()));
			pstmt.setInt(5, id);
			pstmt.executeUpdate();

			String sql2 = "SELECT * FROM Guests WHERE id = ?";
			PreparedStatement pstmt2 = con.prepareStatement(sql2);
			pstmt2.setInt(1, id);
			ResultSet rs = pstmt2.executeQuery();

			if (rs.next()) {
				String guestName = rs.getString("guest_name");
				Integer guestPhone = rs.getInt("guest_phone");
				Date createdDate = rs.getDate("created_date");
				Date updatedDate = rs.getDate("updated_date");
				boolean isActive = rs.getBoolean("is_Active");

				System.out.println(id + " " + guestName + " " + guestPhone + " " + createdDate + " " + updatedDate + " "
						+ isActive);

			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public static void deleteById() throws Throwable {

		String sql = "DELETE FROM Guests WHERE id = ?";

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

			String sql = "UPDATE Guests SET is_Active = false WHERE id = ?";
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
}
