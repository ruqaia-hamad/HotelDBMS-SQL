import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Throwable {
		Scanner sc = new Scanner(System.in);
		boolean isExitMenu3 = true;
		do {
			System.out.println("\t\t++++++++++++++++++++++++++++++++++");
			System.out.println("\t\t+ WELCOME TO THE SYSTEM          +");
			System.out.println("\t\t++++++++++++++++++++++++++++++++++\n");
			System.out.println("Please Choose Number From Menu:       \n");
			System.out.println(" =====================================");
			System.out.println("|  [1]HOTELS SUB MENU                 |");
			System.out.println("|  [2]ROOMS SUB MENU                  |");
			System.out.println("|  [3]GUESTS SUB MENU                 |");
			System.out.println("|  [4]EMPLOYEES SUB MENU              |");
			System.out.println("|  [5]EMPLOYEES TYPE SUB MENU         |");
			System.out.println("|  [6]ROOM TYPE SUB MENU              |");
			System.out.println("|  [7]EXIT                            |");
			System.out.println(" =====================================");
			Integer num = sc.nextInt();

			switch (num) {
			case 1:
				boolean isExitMenu = true;
				do {

					System.out.println("Please Choose Number From Menu:               \n");
					System.out.println(" ==============================================");
					System.out.println("|  [1]CREATE HOSTELS TABLE                     |");
					System.out.println("|  [2]Insert 10,000 hotels                     |");
					System.out.println("|  [3]Insert 1 hotel                           |");
					System.out.println("|  [4]Print 10 hotels                          |");
					System.out.println("|  [5]Make first 10 hotels 'is_Active' = false |");
					System.out.println("|  [6]Print hotel information by user input    |");
					System.out.println("|  [7]EXIT                                     |");
					System.out.println(" ==============================================");
					int op = sc.nextInt();

					switch (op) {
					case 1:
						Hotels.creatingHotelsTable();

						break;
					case 2:
						Hotels.InsertIntoTable(10000);
						break;
					case 3:

						Hotels.InsertIntoTable(1);
						break;
					case 4:
						Hotels.readFromTable(10);
						break;
					case 5:
						Hotels.makeIsActiveFalseById(12);
						break;

					case 6:
						System.out.print("Enter the number of hotel information you want ");
						int numOfRows = sc.nextInt();
						Hotels.readFromTable(numOfRows);
						break;
					case 7:
						isExitMenu = false;
					}
				} while (isExitMenu);

				break;

			case 2:
				boolean isExitMenu4 = true;
				do {

					System.out.println("Please Choose Number From Menu:               \n");
					System.out.println(" ==============================================");
					System.out.println("|  [1]CREATE ROOMS   TABLE                     |");
					System.out.println("|  [2]Insert 10,000 ROOM                       |");
					System.out.println("|  [3]Insert 1 ROOM                            |");
					System.out.println("|  [4]Print 10 ROOMS                           |");
					System.out.println("|  [5]Make first 10 ROOMS  'is_Active' = false |");
					System.out.println("|  [6]Print ROOMS information by user input    |");
					System.out.println("|  [7]EXIT                                     |");
					System.out.println(" ==============================================");
					int op2 = sc.nextInt();

					switch (op2) {
					case 1:
						Rooms.creatingRoomsTable();
						break;
					case 2:
						Rooms.InsertIntoTable(10000);
						break;
					case 3:

						Rooms.InsertIntoTable(1);
						break;
					case 4:
						Rooms.readFromTable(10);
						break;
					case 5:
						Rooms.makeIsActiveFalseById(12);
						break;

					case 6:
						System.out.print("Enter the number of hotel information you want ");
						int numOfRows = sc.nextInt();
						Hotels.readFromTable(numOfRows);
						break;
					case 7:
						isExitMenu4 = false;
					}
				} while (isExitMenu4);

				break;
			case 3:

				boolean isExitMenu5 = true;
				do {

					System.out.println("Please Choose Number From Menu:               \n");
					System.out.println(" ==============================================");
					System.out.println("|  [1]CREATE GUESTS TABLE                      |");
					System.out.println("|  [2]Insert 10,000 GUESTS                     |");
					System.out.println("|  [3]Insert 1 GUEST                           |");
					System.out.println("|  [4]Print 10 GUESTS                          |");
					System.out.println("|  [5]Make first 10 GUESTS 'is_Active' = false |");
					System.out.println("|  [6]Print GUESTS information by user input   |");
					System.out.println("|  [7]EXIT                                     |");
					System.out.println(" ==============================================");
					int op = sc.nextInt();

					switch (op) {
					case 1:
						Guests.creatingGuestsTable();

						break;
					case 2:
						Guests.InsertIntoTable(10000);
						break;
					case 3:

						Guests.InsertIntoTable(1);
						break;
					case 4:
						Guests.readFromTable(10);
						break;
					case 5:
						Guests.makeIsActiveFalseById(12);
						break;

					case 6:
						System.out.print("Enter the number of Guests information you want ");
						int numOfRows = sc.nextInt();
						Hotels.readFromTable(numOfRows);
						break;
					case 7:
						isExitMenu5 = false;
					}
				} while (isExitMenu5);

				break;

			case 4:
				boolean isExitMenu6 = true;
				do {

					System.out.println("Please Choose Number From Menu:               \n");
					System.out.println(" ==============================================");
					System.out.println("|  [1]CREATE Employees TABLE                      |");
					System.out.println("|  [2]Insert 10,000 Employees                     |");
					System.out.println("|  [3]Insert 1 Employees                          |");
					System.out.println("|  [4]Print 10 Employees                          |");
					System.out.println("|  [5]Make first 10 Employees 'is_Active' = false |");
					System.out.println("|  [6]Print Employees information by user input   |");
					System.out.println("|  [7]EXIT                                        |");
					System.out.println(" ==============================================");
					int op = sc.nextInt();

					switch (op) {
					case 1:
						Employees.creatingEmployeeTable();

						break;
					case 2:
						Employees.InsertIntoTable(10000);
						break;
					case 3:

						Employees.InsertIntoTable(1);
						break;
					case 4:
						Employees.readFromTable(10);
						break;
					case 5:
						Employees.makeIsActiveFalseById(10);
						break;

					case 6:
						System.out.print("Enter the number of Employees information you want ");
						int numOfRows = sc.nextInt();
						Hotels.readFromTable(numOfRows);
						break;
					case 7:
						isExitMenu6 = false;
					}
				} while (isExitMenu6);

				break;

			case 5:
				boolean isExitMenu7 = true;
				do {
 
					System.out.println("Please Choose Number From Menu:                      \n");
					System.out.println(" =====================================================");
					System.out.println("|  [1]CREATE Employee Type TABLE                      |");
					System.out.println("|  [2]Insert 10,000 Employee Type                     |");
					System.out.println("|  [3]Insert 1 Employee Type                          |");
					System.out.println("|  [4]Print 10 Employee Type                          |");
					System.out.println("|  [5]Make first 10 Employee Type'is_Active' = false  |");
					System.out.println("|  [6]Print Employee Type information by user input   |");
					System.out.println("|  [7]EXIT                                            |");
					System.out.println(" =====================================================");
					int op = sc.nextInt();

					switch (op) {
					case 1:
						EmployeeType.creatingEmployeeTypeTable();

						break;
					case 2:
						EmployeeType.InsertIntoTable(10000);
						break;
					case 3:

						EmployeeType.InsertIntoTable(1);
						break;
					case 4:
						EmployeeType.readFromTable(10);
						break;
					case 5:
						EmployeeType.makeIsActiveFalseById(10);
						break;

					case 6:
						System.out.print("Enter the number of Employee type information you want ");
						int numOfRows = sc.nextInt();
						EmployeeType.readFromTable(numOfRows);
						break;
					case 7:
						isExitMenu7 = false;
					}
				} while (isExitMenu7);

				break;

			case 6:
				boolean isExitMenu8 = true;
				do {
 
					System.out.println("Please Choose Number From Menu:                      \n");
					System.out.println(" =====================================================");
					System.out.println("|  [1]CREATE Room Type TABLE                      |");
					System.out.println("|  [2]Insert 10,000 Room Type                    |");
					System.out.println("|  [3]Insert 1 Room Type                        |");
					System.out.println("|  [4]Print 10 Room Type                         |");
					System.out.println("|  [5]Make first 10 Room Type'is_Active' = false  |");
					System.out.println("|  [6]Print Room Type information by user input   |");
					System.out.println("|  [7]EXIT                                            |");
					System.out.println(" =====================================================");
					int op = sc.nextInt();

					switch (op) {
					case 1:
						RoomType.creatingRoomTypeTable();

						break;
					case 2:
						RoomType.InsertIntoTable(10000);
						break;
					case 3:

						RoomType.InsertIntoTable(1);
						break;
					case 4:
						RoomType.readFromTable(10);
						break;
					case 5:
						RoomType.makeIsActiveFalseById(10);
						break;

					case 6:
						System.out.print("Enter the number of Room type information you want ");
						int numOfRows = sc.nextInt();
						RoomType.readFromTable(numOfRows);
						break;
					case 7:
						isExitMenu8 = false;
					}
				} while (isExitMenu8);

				break;
	
			case 7:
				System.out.println("THANK YOU");
				isExitMenu = false;
				break;

			}

		}while(isExitMenu3=false);

	}

}
