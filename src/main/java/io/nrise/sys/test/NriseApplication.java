package io.nrise.sys.test;

import io.nrise.sys.test.entity.Users;
import io.nrise.sys.test.v1.user.UsersRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class NriseApplication implements CommandLineRunner {
	@Autowired
	private UsersRespository usersRespository;
	private PasswordEncoder passwordEncoder;



	public static void main(String[] args) {
		SpringApplication.run(NriseApplication.class, args);
	}

	@Override
	public void run(String... args) {
		usersRespository.save(Users.join("dd", passwordEncoder.encode("pw1234")));
		usersRespository.save(Users.join("aa", passwordEncoder.encode("pw_1234")));
		usersRespository.save(Users.join("ee", passwordEncoder.encode("_pw1234")));
	}

}
