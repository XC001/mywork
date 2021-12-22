import com.learn.ConsumerServerApplication;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"classpath:feature"},
        glue = {"com.learn.steps"},
        plugin = {"pretty", "junit:cucumber.xml"})
public class BusinessTest {
}
