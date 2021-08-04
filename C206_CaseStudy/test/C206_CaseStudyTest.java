import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private Item ii1;
	private Item ii2;
	private ArrayList<Item> itemList;

	private UserAccount userAcc1;
	private UserAccount userAcc2;
	private ArrayList<UserAccount> userAccList;

	private Category c1;
	private Category c2;
	private ArrayList<Category> CategoryList;

	
	public C206_CaseStudyTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		// prepare test data
		ii1 = new Item("Shoe Bag", "Manchester United Bag", 15.85, "21-5-2021", "26-5-2021", 1);
		ii2 = new Item("Shoes", "Duramo SL Shoes", 50.75, "22-6-2021", "26-6-2021", 2);
		itemList = new ArrayList<Item>();
		
		userAcc1 = new UserAccount("James", "Admin", "james@rp.edu.sg", "james1234");
		userAcc2 = new UserAccount("Sean", "Seller", "sean@rp.edu.sg", "sean12345");
		userAccList = new ArrayList<UserAccount>();

		c1 = new Category("Books");
		c2 = new Category("CDs");
		CategoryList = new ArrayList<Category>();
		
	}

	@Test
	public void addItemTest() {
		// Test if Item list is not null but empty (boundary)
		assertNotNull("Check if there is valid Item arraylist to add to", itemList);

		// Given an empty list, after adding 1 item, the size of the list is 1 (normal)
		// The item just added is same as the first item of the list
		C206_CaseStudy.addItems(itemList, ii1);
		assertEquals("Check that Item arraylist size is 1", 1, itemList.size());
		assertSame("Check that Item is added", ii1, itemList.get(0));

		// Add another item. test The size of the list is 2? (normal)
		// The item just added is same as the second item of the list
		C206_CaseStudy.addItems(itemList, ii2);
		assertEquals("Check that Item arraylist size is 2", 2, itemList.size());
		assertSame("Check that Item is added", ii2, itemList.get(1));
	}

	@Test
	public void retrieveAllItemTest() {
		// Test if Item list is not null but empty (boundary)
		assertNotNull("Test if there is valid Item arraylist to retrieve item", itemList);

		// test if the list of Items retrieved is empty (boundary)
		String allItems = C206_CaseStudy.retrieveAllItems(itemList);
		String testOutput = "";
		assertEquals("Check that ViewAllitemList", testOutput, allItems);

		// Given an empty list, after adding 2 items, test if the size of the list is 2
		// (normal)
		C206_CaseStudy.addItems(itemList, ii1);
		C206_CaseStudy.addItems(itemList, ii2);
		assertEquals("Test that Item arraylist size is 2", 2, itemList.size());

		// test if the expected output string same as the list of Items retrieved from

		allItems = C206_CaseStudy.retrieveAllItems(itemList);
		testOutput = String.format("%-10s %-30s $%-20.2f %-20s %-20s $%-10d\n", "Shoe Bag", "Manchester United Bag",
				15.85, "21-5-2021", "26-5-2021", 1);
		testOutput += String.format("%-10s %-30s $%-20.2f %-20s %-20s $%-10d\n", "Shoes", "Duramo SL Shoes", 50.75,
				"22-6-2021", "26-6-2021", 1);

		assertEquals("Test that ViewAllitemList", testOutput, allItems);
	}

	@Test
	public void dodeleteItemTest() {

		// Test if Item list is not null but empty, so that can delete an item
		assertNotNull("Test if there is a valid Chromebook arraylist to add to", itemList);

		// Reduce the item test if the list size is x-1
		C206_CaseStudy.doDeleteItem(itemList, ii1.getItemName());
		assertEquals("Test if the chromebook arraylist is reduced by 1?", 0, itemList.size());

		// Test if the item is in the list
		C206_CaseStudy.doDeleteItem(itemList, ii1.getItemName());
		assertFalse(itemList.contains(ii1));

		
	}
	

	@Test
	public void c206_test() {
		// fail("Not yet implemented");
		assertTrue("C206_CaseStudy_SampleTest ", true);
	}

	@Test
	public void addUserAccTest() {
		// User Account list is not null, so that we can add new user
		assertNotNull("Test if there ia arraylist for user account to add in to", userAccList);

		// Check if after a user account is added the user account list size is 1
		C206_CaseStudy.addUserAcc(userAccList, userAcc1);
		C206_CaseStudy.retriveAllUserAcc(userAccList);
		assertEquals("Test if the UserAccount arraylist size is 1?", 1, userAccList.size());

		// Test if the user added is the same as the first item in the list
		assertSame("Test if the User Account added matches with the first itme in the list?", userAcc1,
				userAccList.get(0));

		// Add another item in the account list and check if the list size is 2
		C206_CaseStudy.addUserAcc(userAccList, userAcc2);
		C206_CaseStudy.retriveAllUserAcc(userAccList);
		assertEquals("Test if the UserAccount arraylist size is 2?", 2, userAccList.size());

		// Check if the email address added is valid
		assertTrue(userAccList.get(0).getEmail().contains("@rp.edu.sg"));
		assertFalse(!userAccList.get(0).getEmail().contains("@rp.edu.sg"));

		// Check if the password added is valid
		boolean password = userAccList.get(0).getPassword().length() > 8;
		assertTrue(password);
		assertFalse(!password);
	}

	@Test
	public void viewAllUserAccTest() {
		// User Account list is not null, so that we can add new user
		assertNotNull("Test if there ia arraylist for user account to add in to", userAccList);

		// Test if the user account list is empty when retrieving from main class
		String AccList = C206_CaseStudy.retriveAllUserAcc(userAccList);
		String testOutput = "";
		assertEquals("Check if the user account list is empty", testOutput, AccList);

		// Test if the there is the list is empty after adding users
		C206_CaseStudy.retriveAllUserAcc(userAccList);
		C206_CaseStudy.addUserAcc(userAccList, userAcc1);
		C206_CaseStudy.addUserAcc(userAccList, userAcc2);
		assertEquals("Test if the user account list size is 2", 2, userAccList.size());

		// Test if the user account retrieve is the same as the details added
		AccList = C206_CaseStudy.retriveAllUserAcc(userAccList);
		testOutput = String.format("%-30s %-30s %-30s %s\n", "James", "Admin", "james@rp.edu.sg", "*********");
		testOutput += String.format("%-30s %-30s %-30s %s\n", "Sean", "Seller", "sean@rp.edu.sg", "*********");
		assertEquals("Check if the result retrieve is the same", testOutput, AccList);
	}

	@Test
	public void deleteUserAccTest() {
		// Test if the user account list is not empty
		assertNotNull("Test if there is arraylist for user account to add in to", userAccList);

		// Test if the email entered exist in the user account list
		C206_CaseStudy.addUserAcc(userAccList, userAcc1);
		C206_CaseStudy.viewAllUserAcc(userAccList);
		String deleteEmail = "james@rp.edu.sg";
		assertSame("Test if the email exists in the user account list", deleteEmail, userAccList.get(0).getEmail());

		// Test if the user account list size is 1 when 1 user account is deleted
		C206_CaseStudy.viewAllUserAcc(userAccList);
		userAccList.remove(userAcc1);
		System.out.println("Deleted successfully");
		assertEquals("Test if the user account list size is 0", 0, userAccList.size());

		// Test if after user account is deleted it do not exists in the list
		C206_CaseStudy.addUserAcc(userAccList, userAcc1);
		C206_CaseStudy.retriveAllUserAcc(userAccList);
		C206_CaseStudy.deleteUserAcc(userAccList);
		assertEquals("Test if the user account list size is 0", 0, userAccList.size());
	}

	@Test
	public void addCategoryTest() {
		// Category list is not null, so that can add a new Category - boundary
		assertNotNull("Test if there is valid Category arraylist to add to", CategoryList);

		// Given an empty list, after adding 1 Category, the size of the list is 1 -
		// normal
		// The Category just added is as same as the first Category of the list
		C206_CaseStudy.addCategory(CategoryList, c1);
		assertEquals("Test that Category arraylist size is 1", 1, CategoryList.size());
		assertSame("Test that Category is added", c1, CategoryList.get(0));

		// Add another Category. test The size of the list is 2? - normal
		// The Category just added is as same as the second Category of the list
		C206_CaseStudy.addCategory(CategoryList, c2);
		assertEquals("Test that Category arraylist size is 2", 2, CategoryList.size());
		assertSame("Test that Category is added", c2, CategoryList.get(1));
	}

	@Test
	public void retrieveAllCategoryTest() {
		// Test if Category list is not null but empty -boundary
		assertNotNull("Test if there is valid Camcorder arraylist to retrieve item", CategoryList);

		// test if the list of Category retrieved from the casestudy is empty - boundary
		String allCategory = C206_CaseStudy.retrieveAllCategory(CategoryList);
		String testOutput = "";
		assertEquals("Check that ViewAllCamcorderlist", testOutput, allCategory);

		// Given an empty list, after adding 2 Category, test if the size of the list is
		// 2 - normal
		C206_CaseStudy.addCategory(CategoryList, c1);
		C206_CaseStudy.addCategory(CategoryList, c2);
		assertEquals("Test that Camcorder arraylist size is 2", 2, CategoryList.size());

		// test if the expected output string same as the list of category retrieved
		// from the casestudy
		allCategory = C206_CaseStudy.retrieveAllCategory(CategoryList);
		testOutput = String.format("%s. %s\n", "1", "Books");
		testOutput += String.format("%s. %s\n", "2", "CDs");
		assertEquals("Test that ViewAllCategorylist", testOutput, allCategory);

	}

	@Test
	public void deleteCategoryTest() {
		// Test if the category is not empty
		assertNotNull("Test if there is valid Category arraylist to delete ", CategoryList);

		// Test that the arrayList's size decreases by 1
		// *for example the second index is to be removed
		C206_CaseStudy.addCategory(CategoryList, c1);
		C206_CaseStudy.addCategory(CategoryList, c2);
		CategoryList.remove(c1);
		assertEquals("Test if the size will be reduced by 1 ", 1, CategoryList.size());

		// Test if the list is 0

		C206_CaseStudy.deleteCategory(CategoryList);
		assertEquals("Test if the category list size is 0", 1, CategoryList.size());

		// Test that arrayList is not null after deletion of 1 category, assuming
		// arrayList contains more than 1 category
//		assertNull("Test that Category arrayList is null", CategoryList.size());

	}

	@After
	public void tearDown() throws Exception {
		userAcc1 = null;
		userAcc2 = null;
		userAccList = null;

		c1 = null;
		c2 = null;
		CategoryList = null;

		ii1 = null;
		ii2 = null;
		itemList = null;
	}

}
