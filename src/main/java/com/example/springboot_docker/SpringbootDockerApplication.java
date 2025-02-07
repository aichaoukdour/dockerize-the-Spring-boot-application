package com.example.springboot_docker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
@RestController
public class SpringbootDockerApplication {

    // Dynamic Welcome Message with fixed name "Aicha Oukdour"
    @GetMapping("/welcome")
    public String welcome() {
        String currentTime = getCurrentTime();

        return "<html>"
                + "<head>"
                + "<title>Welcome to Spring Boot with Docker</title>"
                + "<style>"
                + "body { font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; background-color: #f0f2f5; color: #333; margin: 0; padding: 0; text-align: center; }"
                + "header { background-color: #4CAF50; color: white; padding: 20px 0; font-size: 24px; }"
                + ".content { margin: 50px; padding: 20px; background-color: white; border-radius: 10px; box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1); }"
                + ".content h2 { font-size: 32px; color: #333; }"
                + ".content p { font-size: 18px; }"
                + ".btn { padding: 12px 20px; font-size: 16px; background-color: #4CAF50; color: white; border: none; border-radius: 5px; cursor: pointer; transition: background-color 0.3s ease; }"
                + ".btn:hover { background-color: #45a049; }"
                + ".footer { background-color: #333; color: white; padding: 10px; position: fixed; width: 100%; bottom: 0; font-size: 14px; }"
                + "@media (max-width: 600px) { .content { margin: 20px; padding: 15px; } .content h2 { font-size: 24px; } }"
                + "</style>"
                + "</head>"
                + "<body>"
                + "<header>"
                + "<h1>Welcome to the Spring Boot Docker Demo</h1>"
                + "</header>"
                + "<div class='content'>"
                + "<h2>Hello Aicha Oukdour!</h2>"
                + "<p>Current Time: " + currentTime + "</p>"
                + "<p>This Spring Boot application is running inside a Docker container.</p>"
                + "<button class='btn' onclick='alert(\"Enjoy your visit! 🚀\")'>Click Me!</button>"
                + "</div>"
                + "<footer class='footer'>"
                + "<p>Created with ❤️ by Spring Boot and Docker</p>"
                + "</footer>"
                + "<script>"
                + "function showAlert() { alert('This is a dynamic alert!'); }"
                + "</script>"
                + "</body>"
                + "</html>";
    }

    // Helper method to get current time
    private String getCurrentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDockerApplication.class, args);
    }
}
