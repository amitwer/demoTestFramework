package rest;

import io.qameta.allure.Step;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class RestService {
    @Step("Checking if <{email}> has been PWNED")
    public static List<PwndEntry> haveIBeenPwnd(String email) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("User-Agent","test-pwnage-poc-thank-you");
        HttpEntity<String> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<PwndEntry[]> pwnedEntries = restTemplate.exchange("https://haveibeenpwned.com/api/v2/breachedaccount/" + email, HttpMethod.GET, httpEntity, PwndEntry[].class);
        return Arrays.asList(pwnedEntries.getBody());

    }
}
