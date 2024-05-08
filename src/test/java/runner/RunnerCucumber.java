package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    plugin = {"pretty","json:target/cucumber-report.json","html:target/cucumber-reports.html"},
	    features = "C:/Users/rupes/BDD/BddAssessment/src/test/resources/features",
	    glue="stepDefinition"
	    )
	
public class RunnerCucumber extends AbstractTestNGCucumberTests {

}
