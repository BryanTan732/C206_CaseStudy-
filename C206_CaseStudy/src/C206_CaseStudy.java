import java.util.ArrayList;

//Tan Kai Jie Bryan StudentID:20045873
//Lam Heng Yee, 20014013
//Wong Mei Yan, 20031018

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int option = -1;
		while (option != 5) {
			C206_CaseStudy.mainMenu();
			option = Helper.readInt("Choose your option > ");
			if (option == 1) {
				// User Account
				C206_CaseStudy.userAcc();

			} else if (option == 2) {
				// Category
				C206_CaseStudy.category();
			} else if (option == 3) {
				// Item
				C206_CaseStudy.Item();

			} else if (option == 4) {
				// Deal

			} else {
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
			C206_CaseStudy.userAccMenu();

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

	public static void userAccMenu() {
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

	public static void category() {
		ArrayList<Category> CategoryList = new ArrayList<Category>();

		CategoryList.add(new Category("Books"));
		CategoryList.add(new Category("CDs"));

		int option = 0;

		while (option != 4) {

			C206_CaseStudy.CategoryMenu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				// View all items
				C206_CaseStudy.viewAllCategory(CategoryList);

			} else if (option == 2) {
				// Add a new category
				addCategory(CategoryList, inputCategory());

			} else if (option == 3) {
				// Delete item
				deleteCategory(CategoryList);
			} else if (option == 4) {

				System.out.println("Bye!");
			} else {
				System.out.println("Invalid option");
			}
		}
	}

	// View all category
	public static String retrieveAllCategory(ArrayList<Category> CategoryList) {
		String output = "";

		for (int i = 0; i < CategoryList.size(); i++) {

			output += String.format("%s. %s\n", (i + 1), CategoryList.get(i).getName());
		}
		return output;
	}

	public static void CategoryMenu() {

		Helper.line(30, "=");
		System.out.println("CATEGORY MANAGER");
		Helper.line(30, "-");
		System.out.println("1. View all Category");
		System.out.println("2. Add Category");
		System.out.println("3. Delete Category");
		System.out.println("4. Quit");
		Helper.line(30, "=");
	}

	public static void viewAllCategory(ArrayList<Category> CategoryList) {
		Helper.line(30, "=");
		String output = String.format("%-10s\n", "CATEGORY NAME");
		Helper.line(30, "=");
		output += retrieveAllCategory(CategoryList);
		System.out.println(output);
	}

	// Add Category
	public static Category inputCategory() {
		String name = Helper.readString("Enter name > ");

		Category c = new Category(name);
		return c;

	}

	public static void addCategory(ArrayList<Category> CategoryList, Category c) {

		CategoryList.add(c);
		System.out.println("Category added");
	}

	// Delete Category
	public static void deleteCategory(ArrayList<Category> CategoryList) {

		String delete = Helper.readString("Enter category name to delete > ");
		for (int i = 0; i < CategoryList.size(); i++) {
			if (delete.equalsIgnoreCase(CategoryList.get(i).getName())) {
				CategoryList.remove(i);
				System.out.println("Delete successfully");
				break;

			}
		}
	}

	public static void Item() {
		ArrayList<Item> itemList = new ArrayList<Item>();

		itemList.add(new Item("Shoe Bag", "Manchester United Bag", 15.85, "21-5-2021", "26-5-2021", 1));
		itemList.add(new Item("Shoes", "Duramo SL Shoes", 50.75, "22-6-2021", "26-6-2021", 2));

		int option = 0;

		while (option != 4) {

			ItemMenu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				// View all items
				C206_CaseStudy.viewAllItems(itemList);

			} else if (option == 2) {
				// Add a new item
				Item i = inputItems();
				C206_CaseStudy.addItems(itemList, i);
			} else if (option == 3) {
				// Delete item
				C206_CaseStudy.deleteItem(itemList);
			} else if (option == 4) {
				System.out.println("Bye!");
			} else {
				System.out.println("Invalid option");
			}
		}
	}

	public static void ItemMenu() {
		System.out.println("RESOURCE CENTRE APP");
		Helper.line(80, "-");
		System.out.println("1. View all items");
		System.out.println("2. Add item");
		System.out.println("3. Delete item");
		System.out.println("4. Quit");
		Helper.line(80, "-");

	}

	public static String retrieveAllItems(ArrayList<Item> itemList) {
		String output = "";

		for (int i = 0; i < itemList.size(); i++) {

			output += String.format("%-10s %-30s $%-20.2f %-20s %-20s $%-10d\n", itemList.get(i).getItemName(),
					itemList.get(i).getItemDescription(), itemList.get(i).getMinbidPrice(),
					itemList.get(i).getAuctionStart(), itemList.get(i).getAuctionEnd(), itemList.get(i).getBidIncR());
		}
		return output;
	}

	public static void viewAllItems(ArrayList<Item> itemList) {
		System.out.println("CAMCORDER LIST");
		String output = String.format("%-10s %-30s %-20s %-20s %-20s %-10s\n", "ITEM NAME", "ITEM DESCRIPTION",
				"MINIMUM BID PRICE", "AUCTION START DATE", "AUCTION END DATE", "BID INCREMENT");
		output += retrieveAllItems(itemList);
		System.out.println(output);
	}

	public static Item inputItems() {
		String itemName = Helper.readString("Enter item name > ");
		String itemDescription = Helper.readString("Enter item description > ");
		double minBidPrice = Helper.readDouble("Enter minimum bid price> ");
		String auctionStart = Helper.readString("Enter date (dd-mm-yyyy)> ");
		String auctionEnd = Helper.readString("Enter date (dd-mm-yyyy)> ");
		int bidIncR = Helper.readInt("Enter bid Increment > ");

		Item i = new Item(itemName, itemDescription, minBidPrice, auctionStart, auctionEnd, bidIncR);
		return i;

	}

	public static void addItems(ArrayList<Item> itemList, Item i) {
		itemList.add(i);
		System.out.println("Item added");
	}

	public static boolean doDeleteItem(ArrayList<Item> itemList, String name) {
		// write your code here
		boolean isDeleted = false;

		for (int i = 0; i < itemList.size(); i++) {
			if (name.equalsIgnoreCase(itemList.get(i).getItemName())) {
				isDeleted = true;

			}
		}
		return isDeleted;

	}

	public static void deleteItem(ArrayList<Item> itemList) {
		// write your code here
		String name = Helper.readString("Enter item name > ");
		Boolean isDeleted = doDeleteItem(itemList, name);
		if (isDeleted == false) {
			System.out.println("Invalid item name");
		} else {
			System.out.println("Item " + name + " has been deleted");
		}
	}

}
