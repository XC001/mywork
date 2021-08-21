import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"classpath:feature"},
        glue = {"com.learn.steps"},
        plugin = {"pretty", "junit:cucumber.xml"})
public class BusinessTest {
}
