package org.example.restproject;

import org.example.restproject.model.Todo;
import org.example.restproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestprojectApplication  implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(RestprojectApplication.class, args);
    }


    @Autowired
    private UserRepository userRepo;
    @Override
    public void run(String... args) throws Exception {
        Todo user = new Todo();
        user.setId(1L);
        user.setTask("wakeup");
        user.setCompleted(true);
        userRepo.save(user);

        Todo user1 = new Todo();
        user1.setId(2L);
        user1.setTask("eat");
        user1.setCompleted(true);
        userRepo.save(user1);
      //id 3 post with the help of api


    }
}
