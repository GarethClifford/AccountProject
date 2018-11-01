package accountapp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.qa.service.AccountService;

public class AccountTest {

	@Test
	public void test() {

		AccountService ac = new AccountService();

		ac.createAccount("1", "Andrew", "Knott");
		ac.createAccount("4", "Gareth", "Clifford");
		ac.createAccount("3", "Ben", "Taylor");
		ac.createAccount("2", "Andrew", "Knott");

		
		
		assertEquals(2, ac.getAccountSum("Andrew"));
		assertEquals(1, ac.getAccountSum("Ben"));
		assertEquals(0, ac.getAccountSum("Mozi"));

	}

}
