import java.util.ArrayList;

//Lam Heng Yee, 20014013
public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int option = -1;
		while (option !=5 ) {
			C206_CaseStudy.mainMenu();
			option = Helper.readInt("Choose your option > ");
			if (option == 1) {
				// User Account
				C206_CaseStudy.userAcc();
				
			}
			else if (option == 2) {
				// Category
				
			}
			else if (option == 3) {
				// Item
				
			}
			else if (option == 4) {
				// Deal
				
			}
			else {
				System.out.println("Thank you for visiting Campus Online Auction Shop. Good Bye!");
			}
		}
		
		
	}
	
	public static void mainMenu() {
		C206_CaseStudy.setHeader("Campus Online Auction Shop");
		System.out.println("1. Manage User Account");
		System.out.println("2. Manage Category");
		System.out.println("3. Manage Item");
		System.out.println("4. Manage Deal");
		System.out.println("5. Exit the program");
	}
	
	public static void userAcc() {
		ArrayList<UserAccount> userAccList = new ArrayList<UserAccount>();

		userAccList.add(new UserAccount("James", "Admin", "james@rp.edu.sg", "james1234"));
		userAccList.add(new UserAccount("Sean", "Seller", "sean@rp.edu.sg", "sean12345"));
		
		int option = -1;
		
		while (option != 4) {
			C206_CaseStudy.menu();

			option = Helper.readInt("Enter an option > ");
			if (option == 1) {
				// View all user accounts
				C206_CaseStudy.viewAllUserAcc(userAccList);

			}

			else if (option == 2) {
				// Add user account
				C206_CaseStudy.setHeader("ADD User Account");
				UserAccount userAcc = askUserAcc();
				C206_CaseStudy.addUserAcc(userAccList, userAcc);
			}

			else if (option == 3) {
				// Delete user account
				C206_CaseStudy.setHeader("DELETE User Account");
				C206_CaseStudy.deleteUserAcc(userAccList);
			}

			else if (option == 4) {
				System.out.println("Exit");
			}

			else {
				System.out.println("Invalid option");
			}
		}
	}
	
	public static void menu() {
		C206_CaseStudy.setHeader("User Account");
		System.out.println("1. View All User Accounts");
		System.out.println("2. Add User Account");
		System.out.println("3. Delete User Account");
		System.out.println("4. Quit");
		Helper.line(80, "-");
	}

	public static void setHeader(String heading) {
		Helper.line(80, "-");
		System.out.println(heading);
		Helper.line(80, "-");
	}

	// Option 1 = View all User Account
	public static String retriveAllUserAcc(ArrayList<UserAccount> userAccList) {
		String output = "";
		for (int i = 0; i < userAccList.size(); i++) {
			output += String.format("%-30s %-30s %-30s %s\n", userAccList.get(i).getName(),
					userAccList.get(i).getRole(), userAccList.get(i).getEmail(),
					obscure(userAccList.get(i).getPassword()));
		}
		return output;
	}

	public static void viewAllUserAcc(ArrayList<UserAccount> userAccList) {
		C206_CaseStudy.setHeader("User Account List");
		String output = String.format("%-30s %-30s %-30s %s\n", "NAME", "ROLE", "EMAIL", "PASSWORD");
		viewUser(userAccList, output);
	}

	private static void viewUser(ArrayList<UserAccount> userAccList, String output) {
		output += retriveAllUserAcc(userAccList);
		System.out.println(output);
	}

	private static String obscure(String inStr) {
		String rtnVal = "";
		if (inStr.length() <= 5) {
			rtnVal = inStr;
		} else {
			rtnVal = String.format("%" + (inStr.length()) + "s", " ").replaceAll(" ", "*");
		}
		return rtnVal;
	}
	
	// Option 2 = Add User Account
	public static UserAccount askUserAcc() {
		String name = Helper.readString("Enter your name > ");
		String role = Helper.readString("Enter your role (Buyer/Seller/Admin) > ");
		String email = Helper.readString("Enter your email > ");
		String password = Helper.readString("Enter your password > ");
		String confirmPassword = Helper.readString("Re-enter your password > ");
 
		UserAccount userAcc = null;

		if (email.contains("@rp.edu.sg") && password.equals(confirmPassword) && password.length() > 8) {
			userAcc = new UserAccount(name, role, email, password);
		}
		return userAcc;
	}

	public static void addUserAcc(ArrayList<UserAccount> userAccList, UserAccount userAcc) {
		userAccList.add(userAcc);
		System.out.println("New User Account successfully added");
	}

	// Option 3 = Delete User Account
	public static void deleteUserAcc(ArrayList<UserAccount> userAccList) {
		String output = String.format("%-30s %-30s %-30s %s\n", "NAME", "ROLE", "EMAIL", "PASSWORD");
		output += retriveAllUserAcc(userAccList);
		System.out.println(output);
		String deleteEmail = Helper.readString("Enter the email of the user you wish to delete > ");

		boolean isDeleted = false;

		for (int i = 0; i < userAccList.size(); i++) {
			if (deleteEmail.equalsIgnoreCase(userAccList.get(i).getEmail())) {
				userAccList.remove(i);
				isDeleted = true;
			} else {
				isDeleted = false;
			}
		}

		if (isDeleted == true) {
			System.out.println("Successfully deleted the user account");
		} else if (isDeleted == false) {
			System.out.println("Please re-enter the email of the user that you would like to delete");
		}
	}

}
