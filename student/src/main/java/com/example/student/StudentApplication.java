package com.example.student;


import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class StudentApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentApplication.class, args);
    }

//    @Bean
//    CommandLineRunner run(StudentRepository repository) {
//        return args -> {
//            Student s1 = new Student("John", "john@gmail.com", 20);
//            repository.save(s1);
//
//            System.out.println("Student saved: " + s1.getName());
//        };
//    }

//    @Bean
//    CommandLineRunner createUser(
//            UserRepository userRepository,
//            PasswordEncoder encoder) {
//
//        return args -> {
//            if (userRepository.findByUsername("admin").isEmpty()) {
//                userRepository.save(
//                        new User("admin", encoder.encode("admin123"), "ADMIN")
//                );
//            }
//        };
    // }


}
