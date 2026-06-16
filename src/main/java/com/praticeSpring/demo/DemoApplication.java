package com.praticeSpring.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;



@SpringBootApplication
@RestController
public class DemoApplication {
    @Autowired
    private JdbcTemplate jdbcTemplate;

public static void main(String[] args) {
SpringApplication.run(DemoApplication.class, args);
}
@GetMapping("/hello")
public Map<String, Object> sayHello() {
return Map.of("message", "Hello World!");
}


    @GetMapping("/users")
    public List<Map<String, Object>> users() {
        return jdbcTemplate.queryForList("SELECT * FROM users");
    }
	 @PostMapping("/users")
    public Map<String, Object> createUser(@RequestBody Map<String, String> body) {

        String email = body.get("email");

        int result = jdbcTemplate.update(
            "INSERT INTO users (email) VALUES (?)",
            email
        );

        return Map.of(
            "success", result,
            "email", email
        );
    }




}