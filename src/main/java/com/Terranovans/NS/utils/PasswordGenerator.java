package com.Terranovans.NS.utils;

import org.hibernate.annotations.Comments;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordGenerator  implements CommandLineRunner {
  @Override
  public void run(String... args){
      BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String rawPassword = "user123";
        String encodedPassword = passwordEncoder.encode(rawPassword);
        System.out.println("Encoded password: user123 " + encodedPassword);
  }

}
