package tests;

import org.assertj.core.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import reporting.Reporter;
import rest.PwndEntry;
import rest.RestService;

import java.util.List;

public class MyFirstApiTest {
    static final Logger log = LoggerFactory.getLogger(MyFirstApiTest.class);
    @Test
    public void testHaveIBeenPwnd(){
        List<PwndEntry> pwndEntries = RestService.haveIBeenPwnd("amit@mailinator.com");
        Assertions.assertThat(pwndEntries).isNotEmpty();
        Reporter.log("got "+pwndEntries.size()+" entries");
        pwndEntries.stream().map(PwndEntry::getDomain).map(s->"Stolen from["+s+"]").forEach(log::debug);

    }
}
