package io.sys1.test;

import io.sys1.test.entity.Users;
import io.sys1.test.v1.user.UsersRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class Application implements CommandLineRunner {
	@Autowired
	private UsersRespository usersRespository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		usersRespository.save(Users.join("dd", passwordEncoder.encode("pw1234")));
		usersRespository.save(Users.join("aa", passwordEncoder.encode("pw_1234")));
		usersRespository.save(Users.join("ee", passwordEncoder.encode("_pw1234")));
	}

}
