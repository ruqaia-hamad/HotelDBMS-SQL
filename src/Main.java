import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Throwable {
		Scanner sc= new Scanner(System.in);
		System.out.println("\t\t++++++++++++++++++++++++++++++++++");
		System.out.println("\t\t+ WELCOME TO THE SYSTEM          +");
		System.out.println("\t\t++++++++++++++++++++++++++++++++++\n");
		System.out.println("Please Choose Number From Menu:       \n");
		System.out.println(" =====================================");
		System.out.println("|  [1]HOTELS SUB MENU                 |");
		System.out.println("|  [2]ROOMS SUB MENU                  |");
		System.out.println("|  [10]EXIT                           |");
		System.out.println(" =====================================");
		Integer num=sc.nextInt();
		boolean isExitMenu = true;
		boolean isExitMenu2 = true;
		switch(num) {
		case 1:
			System.out.println("Please Choose Number From Menu:               \n");
			System.out.println(" ==============================================");
			System.out.println("|  [1]CREATE HOSTELS TABLE                     |");
			System.out.println("|  [2]Insert 10,000 hotels                     |");
			System.out.println("|  [3]Insert 1 hotel                           |");
			System.out.println("|  [4]Print 10 hotels                          |");
			System.out.println("|  [5]Make first 10 hotels 'is_Active' = false |");
			System.out.println("|  [6]Print hotel information by user input    |");
			System.out.println(" ==============================================");
			int op = sc.nextInt();

			switch (op) {
			case 1:
				Hotels.creatingHotelsTable();
				break;
			case 2:
				Hotels.InsertIntoTable(10000);
				break;
			case 3 :

		   	Hotels.InsertIntoTable(1);
			case 4:
		      Hotels.readFromTable(10);
				break;
			case 5 :
				Hotels.makeIsActiveFalseById(12);
				break;
				
			case 6 :
				   System.out.print("Enter the number of hotel information you want ");
			       int numOfRows = sc.nextInt();
			       Hotels.readFromTable(numOfRows);
				break;
			case 7 :
			
				isExitMenu2 = false;
			}
			break;
	
		case 2:
			System.out.println("Please Choose Number From Menu:               \n");
			System.out.println(" ==============================================");
			System.out.println("|  [1]CREATE ROOMS   TABLE                     |");
			System.out.println("|  [2]Insert 10,000 ROOM                       |");
			System.out.println("|  [3]Insert 1 ROOM                            |");
			System.out.println("|  [4]Print 10 ROOMS                           |");
			System.out.println("|  [5]Make first 10 ROOMS  'is_Active' = false |");
			System.out.println("|  [6]Print ROOMS information by user input    |");
			System.out.println(" ==============================================");
			int op2 = sc.nextInt();

			switch (op2) {
			case 1:
				Rooms.creatingRoomsTable();
				break;
			case 2:
				Rooms.InsertIntoTable(10000);
				break;
			case 3 :

				Rooms.InsertIntoTable(1);
			case 4:
		      Rooms.readFromTable(10);
				break;
			case 5 :
				Rooms.makeIsActiveFalseById(12);
				break;
				
			case 6 :
				   System.out.print("Enter the number of hotel information you want ");
			       int numOfRows = sc.nextInt();
			       Hotels.readFromTable(numOfRows);
				break;
			case 7 :
			
				isExitMenu2 = false;
			}
			break;

		case 3:
	

			break;
			
		case 4:
		
				break;
				
		case 5:


			break;
		case 6:
	
			break;
		case 7:

			break;
		case 8:
		
			break;
		case 9:
		
			break;
		case 10:
			System.out.println("THANK YOU");
			isExitMenu = false;
			break;


	
		}
		
	}


	}


