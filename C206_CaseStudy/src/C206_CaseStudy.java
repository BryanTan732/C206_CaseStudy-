
//Tan Kai Jie Bryan StudentID:20045873
import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Item> itemList = new ArrayList<Item>();

		itemList.add(new Item("Shoe Bag", "Manchester United Bag", 15.85, "21-5-2021", "26-5-2021", 1));
		itemList.add(new Item("Shoes", "Duramo SL Shoes", 50.75, "22-6-2021", "26-6-2021", 2));

		int option = 0;

		while (option != 4) {

			menu();
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

	public static void menu() {
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
