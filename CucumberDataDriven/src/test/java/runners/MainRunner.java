package runners;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@RunWith(Cucumber.class)

@CucumberOptions(features = { "src/test/java/resources/features" }, glue = {
		"stepDefinitions" }, monochrome = true, dryRun = false, tags = {"@datadriven"}, 
				plugin = { "pretty", "html:target/cucumber", "json:target/cucumber.json", "junit:target/cucumber-reports/Cucumber.xml",
				"com.cucumber.listener.ExtentCucumberFormatter:output/report.html" })

public class MainRunner {
	 
}