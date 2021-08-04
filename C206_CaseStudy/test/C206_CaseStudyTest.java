import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	
	private UserAccount userAcc1;
	private UserAccount userAcc2;
	
	private ArrayList<UserAccount> userAccList;
	
	public C206_CaseStudyTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		userAcc1 = new UserAccount("James", "Admin", "james@rp.edu.sg", "james1234");
		userAcc2 = new UserAccount("Sean", "Seller", "sean@rp.edu.sg", "sean12345");
		userAccList = new ArrayList<UserAccount>();
	}


	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
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
		assertSame("Test if the User Account added matches with the first itme in the list?", userAcc1, userAccList.get(0));
		
		// Add another item in the account list and check if the list size is 2
		C206_CaseStudy.addUserAcc(userAccList, userAcc2);
		C206_CaseStudy.retriveAllUserAcc(userAccList);
		assertEquals("Test if the UserAccount arraylist size is 2?", 2, userAccList.size());
		
		//Check if the email address added is valid
		assertTrue(userAccList.get(0).getEmail().contains("@rp.edu.sg"));
		assertFalse(!userAccList.get(0).getEmail().contains("@rp.edu.sg"));
		
		//Check if the password added is valid
		boolean password = userAccList.get(0).getPassword().length()>8;
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
		//Test if the user account list is not empty
		assertNotNull("Test if there is arraylist for user account to add in to", userAccList);
		
		//Test if the email entered exist in the user account list
		C206_CaseStudy.addUserAcc(userAccList, userAcc1);
		C206_CaseStudy.viewAllUserAcc(userAccList);
		String deleteEmail = "james@rp.edu.sg";
		assertSame("Test if the email exists in the user account list", deleteEmail, userAccList.get(0).getEmail());
		
		// Test if the user account list size is 1 when 1 user account is deleted
		C206_CaseStudy.viewAllUserAcc(userAccList);
		userAccList.remove(userAcc1);
		System.out.println("Deleted successfully");
		assertEquals("Test if the user account list size is 0", 0, userAccList.size());
		
		//Test if after user account is deleted it do not exists in the list
		C206_CaseStudy.addUserAcc(userAccList, userAcc1);
		C206_CaseStudy.retriveAllUserAcc(userAccList);
		C206_CaseStudy.deleteUserAcc(userAccList);
		assertEquals("Test if the user account list size is 0", 0, userAccList.size());
	}
	
	
	@After
	public void tearDown() throws Exception {
		userAcc1 = null;
		userAcc2 = null;
		userAccList = null;
	}
  
}
