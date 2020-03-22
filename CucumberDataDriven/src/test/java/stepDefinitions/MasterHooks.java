package stepDefinitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;


public class MasterHooks  {
	
	@Before
	public void setup(Scenario scenario) {
		System.out.println("Test setup");
		System.out.println(scenario.getId());	
	}
	
	@After
	public void tearDownAndScreenshotOnFailure(Scenario scenario) {
		System.out.println("Test teardown");
	}
}

