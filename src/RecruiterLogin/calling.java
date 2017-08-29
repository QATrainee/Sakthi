package RecruiterLogin;

import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class calling {

	

	@BeforeTest
	public void f() throws Exception {
		BaseClass.browserOpen();
		BaseClass.logIn();

	}

	@Test
	public void g() throws Exception {
		implement.dashBoard();
		implement.post();
		implement.jobResponse();
		implement.fetchResume();
		implement.jobs();
		implement.myAccount();
	}

	@AfterTest
	public void h() throws Exception {

		BaseClass.logOut();
		BaseClass.browserClose();

	}
}
