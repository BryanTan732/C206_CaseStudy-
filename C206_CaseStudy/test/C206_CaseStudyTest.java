import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private Item ii1;
	private Item ii2;

	private ArrayList<Item> itemList;

	@Before
	public void setUp() throws Exception {
		// prepare test data
		ii1 = new Item("Shoe Bag", "Manchester United Bag", 15.85, "21-5-2021", "26-5-2021", 1);
		ii2 = new Item("Shoes", "Duramo SL Shoes", 50.75, "22-6-2021", "26-6-2021", 2);

		itemList = new ArrayList<Item>();
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

	@After
	public void tearDown() throws Exception {
		ii1 = null;
		ii2 = null;
		itemList = null;

	}	

}
