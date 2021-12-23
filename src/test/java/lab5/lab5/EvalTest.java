package lab5.lab5;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import main.Injector;
import main.SomeBean;

@SuppressWarnings("deprecation")
public class EvalTest {
	@Before
	public void Right_Working_of_Injector() throws IllegalAccessException, InstantiationException, IOException{
		SomeBean testsb = (new Injector<SomeBean>("src/main/config/properties.properties").inject(new SomeBean()));
		testsb.foo();
	}
	
	@Test
	public void Testing_IOException_On_Injector() throws IOException, IllegalAccessException, InstantiationException{
		try {
			SomeBean testsb = (new Injector<SomeBean>("src/main/config/notProperties.properties").inject(new SomeBean()));
			testsb.foo();
			Assert.fail("Expected IOException");
		}
		catch (IOException thrown) {
			Assert.assertNotNull("", thrown.getMessage());
		}
		
	}
	
	@Test
	public void Is_Empty_Return_Of_Injector() throws IllegalAccessException, InstantiationException, IOException {
		SomeBean testsb = (new Injector<SomeBean>("src/main/config/properties.properties").inject(new SomeBean()));
		Assert.assertNotNull(testsb);
	}
	
}
