package tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MyFirstTest {

    @Test
    public void passingTest() {
        //this test always passes
    }

    @Test(enabled = false)
    public void failingTest() {
        Assert.fail("Failing test");
    }

    @Test (dataProvider = "dataProvider")
    public  void testWithDataProvider(String line){
        Reporter.log(line);
    }


    @DataProvider
    public Object[] dataProvider(){
        return new Object[]{"Hello","World"};

    }

}
