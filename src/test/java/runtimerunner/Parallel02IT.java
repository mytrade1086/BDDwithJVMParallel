import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        features = {"H:/eclipseWin10Cucumber/BDDwithJVMParallel/src/test/java/features/searchProduct.feature"},
        plugin = {"json:H:/eclipseWin10Cucumber/BDDwithJVMParallel/target/cucumber-parallel/2.json"},
        monochrome = true,
        tags = {},
        glue = {"steps"})
public class Parallel02IT {
}
