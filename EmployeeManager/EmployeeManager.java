import java.io.*;
import java.util.*;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;

class EmployeeManager {

	public static int uid = 0;
	public static BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
	public static int flag = 0;


/*

Add Entry

*/

	public static ArrayList<Employee> addEntry(ArrayList<Employee> list) {

		// variables
		String fName = "";
		String lName = "";
		int IdNum = ++uid;
		String address = "";
		int zipcode = 0;
		String phone = "";
		int salary = 0;
		String dept = "";

		try {
			// get values
			System.out.println("Please provide the following information.");
			System.out.print("First Name: ");
			fName = console.readLine();
			System.out.print("Last Name: ");
			lName = console.readLine();
			System.out.print("Address: ");
			address = console.readLine();
			System.out.print("Zip Code: ");
			zipcode = Integer.parseInt( console.readLine() );
			System.out.print("Phone Number: ");
			phone = console.readLine();
			System.out.print("Salary: ");
			salary = Integer.parseInt( console.readLine() );
			System.out.print("Department: ");
			dept = console.readLine();

			// new entry
			Employee emp = new Employee(fName, lName, IdNum, address, zipcode, phone, salary, dept);
			list.add(emp);
			flag = 1;
		} catch(Exception ex) {
			System.out.println("Error: Entry could not be added.");
		}

		return list;
	}

/*

Edit Entry

*/
	public static ArrayList<Employee> editEntry(ArrayList<Employee> list) {
		String cmd = "";

		try {
			System.out.println("Please enter the ID Number of the entry you would like to edit.");
			System.out.print(">> ");
			cmd = console.readLine();
			int temp = -1;

			if(!list.isEmpty() ) {
				for(int i = 0; i < list.size(); i++) {
					if(list.get(i).getIdNum() == Integer.parseInt(cmd) ) {
						list.get(i).report();

						System.out.println("Is this the entry you are searching for?");
						System.out.print("Y/N >> ");
						cmd = console.readLine();
						if("Y".equalsIgnoreCase(cmd) ) {
							temp = i;
							i = list.size();
							System.out.println("Employee ID #" + list.get(temp).getIdNum() + " selected.");
						} // breaks the loop
					} // if
				} // for
			} // list not empty

			if(temp == -1) {
				System.out.println("Error: The value you entered was not found.");
			} else {
				while(true) {
					System.out.println("What would you like to change?");
					System.out.println("  F - First Name");
					System.out.println("  L - Last Name");
					System.out.println("  A - Address");
					System.out.println("  Z - Zip Code");
					System.out.println("  P - Phone Number");
					System.out.println("  S - Salary");
					System.out.println("  D - Department");
					System.out.println("  Q - Quit");
					System.out.print(" >> ");
					cmd = console.readLine();

					if("F".equalsIgnoreCase(cmd) ) {
						System.out.println("Current First Name: " + list.get(temp).getFName() );
						System.out.print("New First Name: >> ");
						cmd = console.readLine();
						list.get(temp).setFName(cmd);
					} else if("L".equalsIgnoreCase(cmd) ) {
						System.out.println("Current Last Name: " + list.get(temp).getLName() );
						System.out.print("New Last Name: >> ");
						cmd = console.readLine();
						list.get(temp).setLName(cmd);
					} else if("A".equalsIgnoreCase(cmd) ) {
						System.out.println("Current Address: " + list.get(temp).getAddress() );
						System.out.print("New Address: >> ");
						cmd = console.readLine();
						list.get(temp).setAddress(cmd);
					} else if("Z".equalsIgnoreCase(cmd) ) {
						System.out.println("Current Zip Code: " + list.get(temp).getZipcode() );
						System.out.print("New Zip Code: >> ");
						cmd = console.readLine();
						list.get(temp).setZipcode( Integer.parseInt(cmd) );
					} else if("P".equalsIgnoreCase(cmd) ) {
						System.out.println("Current Phone: " + list.get(temp).getPhone() );
						System.out.print("New Phone: >> ");
						cmd = console.readLine();
						list.get(temp).setPhone(cmd);
					} else if("S".equalsIgnoreCase(cmd) ) {
						System.out.println("Current Salary: " + list.get(temp).getSalary() );
						System.out.print("New Salary: >> ");
						cmd = console.readLine();
						list.get(temp).setSalary( Integer.parseInt(cmd) );
					} else if("D".equalsIgnoreCase(cmd) ) {
						System.out.println("Current Department: " + list.get(temp).getDept() );
						System.out.print("New Department: >> ");
						cmd = console.readLine();
						list.get(temp).setDept(cmd);
					} else if("Q".equalsIgnoreCase(cmd) ) {
						break;
					} else {
						System.out.println("Error: Please enter a valid option.");
					}
				} // while
			} // checking temp value
		} catch(Exception ex) {
			//
		}
		return list;
	}

/*

Delete Entry

*/
	public static ArrayList<Employee> deleteEntry(ArrayList<Employee> list) {

		String cmd = "";

		try {
			System.out.println("Please enter the ID Number of the entry you would like to delete.");
			System.out.print(">> ");
			cmd = console.readLine();
			int temp = -1;

			if(!list.isEmpty() ) {
				for(int i = 0; i < list.size(); i++) {
					if(list.get(i).getIdNum() == Integer.parseInt(cmd) ) {
						list.get(i).report();

						System.out.println("Is this the entry you are searching for?");
						System.out.print("Y/N >> ");
						cmd = console.readLine();
						if("Y".equalsIgnoreCase(cmd) ) {
							temp = i;
							i = list.size();
							System.out.println("Employee ID #" + list.get(temp).getIdNum() + " selected.");
						} // breaks the loop
					} // if
				} // for
			} // list not empty

			System.out.println("Are you sure you want to delete this entry? This action cannot be undone.");
			System.out.print(" Y/N >> ");
			cmd = console.readLine();
			if("Y".equalsIgnoreCase(cmd) ) {
				list.remove(temp);
				System.out.println("Delete successful.");
			}
		} catch(Exception ex) {
			//
		}

		return list;
	}

/*

Report

*/
	public static void report(ArrayList<Employee> list) {

		String cmd = "";

		// get sorting & filters

		try {
			System.out.println("Would you like to print this report to a file?");
			System.out.print("Y/N >> ");
			cmd = console.readLine();
			if("Y".equalsIgnoreCase(cmd) ) {
				// print to file
			} // if

			System.out.println("Would you like to print this report to the console?");
			System.out.print("Y/N >> ");
			cmd = console.readLine();
			if("Y".equalsIgnoreCase(cmd) ) {
				// print entries
				if(!list.isEmpty() ) {
					System.out.println("Current Entries:");
					for (int i = 0; i < list.size(); i++) {
						list.get(i).report();
						System.out.println("");
					}
				} else {
					System.out.println("There are no entries at this time.");
				}
			} // if
		} catch(Exception ex) {
			System.out.println("An unknown error has occurred.");
		}
	}

/*

Search

*/
	public static void search(ArrayList<Employee> list) {
		ArrayList<Employee> temp = new ArrayList<Employee>();
		String cmd = "";

		System.out.println("What field would you like to search by?");
		System.out.println("  F - First Name");
		System.out.println("  L - Last Name");
		System.out.println("  A - Address");
		System.out.println("  Z - Zip Code");
		System.out.println("  P - Phone Number");
		System.out.println("  S - Salary");
		System.out.println("  D - Department");
		System.out.print(" >> ");

		try {
			cmd = console.readLine();

			if("F".equalsIgnoreCase(cmd) ) {
				System.out.print("First Name: >> ");
				cmd = console.readLine();

				for(int i = 0; i < list.size(); i++) {
					if( (list.get(i).getFName() ).contains(cmd)) {
						temp.add( list.get(i) );
					}
				}

				if(temp.size() == 0) {
					System.out.println("Your search returned no results.");
				} else if (temp.size() > 1) {
					report(temp);
				} else {
					temp.get(0).report();
				}
			} else if("L".equalsIgnoreCase(cmd) ) {
				System.out.print("Last Name: >> ");
				cmd = console.readLine();

				for(int i = 0; i < list.size(); i++) {
					if( (list.get(i).getLName() ).contains(cmd)) {
						temp.add( list.get(i) );
					}
				}
				if(temp.size() == 0) {
					System.out.println("Your search returned no results.");
				} else if (temp.size() > 1) {
					report(temp);
				} else {
					temp.get(0).report();
				}

			} else if("A".equalsIgnoreCase(cmd) ) {
				System.out.print("Address: >> ");
				cmd = console.readLine();
				for(int i = 0; i < list.size(); i++) {
					if( (list.get(i).getAddress() ).contains(cmd)) {
						temp.add( list.get(i) );
					}
				}
			if(temp.size() == 0) {
					System.out.println("Your search returned no results.");
				} else if (temp.size() > 1) {
					report(temp);
				} else {
					temp.get(0).report();
				}
			} else if("Z".equalsIgnoreCase(cmd) ) {
				System.out.print("Zip Code: >> ");
				cmd = console.readLine();

				for(int i = 0; i < list.size(); i++) {
					if(list.get(i).getZipcode() == Integer.parseInt(cmd) ) {
						temp.add( list.get(i) );
					}
				}
				if(temp.size() == 0) {
					System.out.println("Your search returned no results.");
				} else if (temp.size() > 1) {
					report(temp);
				} else {
					temp.get(0).report();
				}

			} else if("P".equalsIgnoreCase(cmd) ) {
				System.out.print("Phone: >> ");
				cmd = console.readLine();
				for(int i = 0; i < list.size(); i++) {
					if( (list.get(i).getPhone() ).contains(cmd)) {
						temp.add( list.get(i) );
					}
				}

				if(temp.size() == 0) {
					System.out.println("Your search returned no results.");
				} else if (temp.size() > 1) {
					report(temp);
				} else {
					temp.get(0).report();
				}

			} else if("S".equalsIgnoreCase(cmd) ) {
				System.out.print("Salary: >> ");
				cmd = console.readLine();
				for(int i = 0; i < list.size(); i++) {
					if(list.get(i).getSalary() == Integer.parseInt(cmd) ) {
						temp.add( list.get(i) );
					}
				}

				if(temp.size() == 0) {
					System.out.println("Your search returned no results.");
				} else if (temp.size() > 1) {
					report(temp);
				} else {
					temp.get(0).report();
				}
			} else if("D".equalsIgnoreCase(cmd) ) {
				System.out.print("Department: >> ");
				cmd = console.readLine();

				for(int i = 0; i < list.size(); i++) {
					if( (list.get(i).getDept() ).contains(cmd)) {
						temp.add( list.get(i) );
					}
				}

				if(temp.size() == 0) {
					System.out.println("Your search returned no results.");
				} else if (temp.size() > 1) {
					report(temp);
				} else {
					temp.get(0).report();
				}
			} else {
				System.out.println("Error: Invalid option.");
			}
		} catch(Exception ex) {
			System.out.println("Error: An unknown exception has occured.");
		}

	}

/*

Main

*/
	public static void main(String args[]) {

		// local variables
		String fName = "";
		String lName = "";
		int IdNum = 0;
		String address = "";
		int zipcode = 0;
		String phone = "";
		int salary = 0;
		String dept = "";
		Employee emp = null;
		ArrayList<Employee> list = new ArrayList<Employee>();
		String cmd = "";

// read file into objects; initial loading
		File file = new File("data.txt");
		StringBuffer buffer = new StringBuffer();
		BufferedReader reader = null;

		try {

			reader = new BufferedReader( new FileReader(file) );
			String lineTemp = null;
			String line[] = null;

			while( (lineTemp = reader.readLine() ) != null) {
				line = lineTemp.split("\\|"); // split line into entries
				// create & populate new object
				fName = line[0];
				lName = line[1];
				IdNum = Integer.parseInt( line[2] );
				address = line[3];
				zipcode = Integer.parseInt( line[4] );
				phone = line[5];
				salary = Integer.parseInt( line[6] );
				dept = line[7];
				emp = new Employee(fName, lName, IdNum, address, zipcode, phone, salary, dept);
				list.add(emp);
				// get the highest uid
				if(IdNum > uid) uid = IdNum;
			} // while
		} catch(FileNotFoundException ex) {
			System.out.println("Error: Data file not found.");
		}catch(NumberFormatException ed) {
	 		System.out.println("Error: Value not recognized. Please check entries for errors.");
		} catch(Exception ex) {
			System.out.println("Error: Unknown Error");
		} // try/catch


// Display Menu
		while(true) {
			System.out.println("Main Menu\n");
			System.out.println("  A - Add Employee Entry");
			System.out.println("  E - Edit Employee Entry");
			System.out.println("  D - Delete Employee Entry");
			System.out.println("  R - Report");
			System.out.println("  S - Search");
			System.out.println("  Q - Quit\n\n");
			System.out.print(" >> ");

			try {
				cmd = console.readLine();

				if("A".equalsIgnoreCase(cmd) ) {
					list = addEntry(list);
				} else if ("E".equalsIgnoreCase(cmd) ) {
					list = editEntry(list);
				} else if ("D".equalsIgnoreCase(cmd) ) {
					list = deleteEntry(list);
				} else if ("R".equalsIgnoreCase(cmd) ) {
					report(list);
				}else if ("S".equalsIgnoreCase(cmd) ) {
					search(list);
				} else if ("Q".equalsIgnoreCase(cmd) ) {
					if(flag == 1) {
						System.out.println("Would you like to update the data file?");
						System.out.print("Y/N >> ");
						cmd = console.readLine();
						if( "Y".equalsIgnoreCase(cmd) ) {
							// update file
							for(int i =0; i < list.size(); i++) {
								// loop through list and write object values to flat file
							}
						}
					} else {
						System.out.println("Note: No changes were made to the data file.");
					}
					break;
				}else {
					System.out.println("Error: Please enter a valid choice.");
				} // switch if/else statements

			} catch(Exception ex) {
				System.out.println("There has been an unexpected error.");
			}
		} // while
	} // psvm
} // class EmployeeManager