package stepDefinitions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.*;

public class dataDrivenSteps {
	
	
	
	@Given("^Login to applivcation as \"([^\"]*)\" customer$")
	public void login_to_applivcation_as_customer(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions

	    int dataRow = Integer.parseInt(arg1)-1;
//	    System.out.println(dataRow);
	    System.out.println("Login to applivcation as \"([^\"]*)\" customer");
	    System.out.println(DataHelper.readExcelDatafromFile(Config.filename,Config.sheetname).get(dataRow));
	}

	@When("^user provides account transfer data as in \"([^\"]*)\" for account type \"([^\"]*)\" for sheet \"([^\"]*)\"")
	public void user_provides_account_transfer_data_as_in_for_account_type(String arg1, String arg2, String arg3) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
		System.out.println("user provides account transfer data as in \"([^\"]*)\" for account type \"([^\"]*)\" for sheet \"([^\"]*)\"");
		System.out.println(DataHelper.readExcelDatafromFile(Config.filename,arg3).get(Integer.parseInt(arg1)-1).get(arg2));
	}

	@When("^Submits the transfer$")
	public void submits_the_transfer() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
	}

	@Then("^The transfer should be successful$")
	public void the_transfer_should_be_successful() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
	}
}
