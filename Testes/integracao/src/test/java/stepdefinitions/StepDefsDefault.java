package stepdefinitions;

import com.pieropan.integracao.IntegracaoApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = IntegracaoApplication.class)
public class StepDefsDefault {
}