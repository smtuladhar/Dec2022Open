package Day29;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
//@Listeners(Day29.MyListnerClassForDay28.class)  because we are using xml listner
public class ListnerClassTest {

	
	@Test(priority=1)
	public void test1() {
		Assert.assertEquals("A", "A");
	}
	
	@Test(priority=2)
	public void test2() {
		Assert.assertEquals("A", "b");
	}
	
	@Test(priority=3,dependsOnMethods= {"test2"})
	public void test3() {
		Assert.assertEquals("A", "A");
	}
}
