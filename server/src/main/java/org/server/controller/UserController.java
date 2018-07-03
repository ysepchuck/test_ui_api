package org.server.controller;

import com.google.gson.Gson;
import org.server.domain.Jedy;
import org.server.domain.Planet;
import org.server.domain.User;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController()
public class UserController {

    private final String baseUrl = "https://swapi.co/api/";

    @GetMapping("/")
    public String getUsers() {
        return "Dima";
    }

    @GetMapping("/user")
    public User getUser() {
        return new User(1L, "Dima", "dima@test.com");
    }

    @GetMapping("jedy/{jedyId}")
    public void test(@PathVariable int jedyId) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        String response = restTemplate.exchange(baseUrl + "people/" + jedyId + "/",
                HttpMethod.GET,entity,String.class).getBody();

        Jedy jedy = new Gson().fromJson(response, Jedy.class);


        System.out.println(jedy.getName());
    }


    @GetMapping("planet/{planetId}")
    public void test2 (@PathVariable int planetId) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        String response = restTemplate.exchange(baseUrl + "planets/" + planetId + "/", HttpMethod.GET,entity,String.class).getBody();

        Planet planet = new Gson().fromJson(response, Planet.class);

        System.out.println(planet.getClimate());
    }


}
