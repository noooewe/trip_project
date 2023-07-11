package com.portfolio.trip_project.config;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class PasswordEncoderConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new PasswordEncoder();
    }

    public static class PasswordEncoder {
        public String encode(String password) {
            return BCrypt.hashpw(password, BCrypt.gensalt());
        }

        public boolean matches(String rawPassword, String encodedPassword) {
            return BCrypt.checkpw(rawPassword, encodedPassword);
        }
    }
}