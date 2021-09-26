package com.onurryazici.SpringApp;

import com.onurryazici.SpringApp.model.User;
import com.onurryazici.SpringApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class SpringAppApplication implements CommandLineRunner {
	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringAppApplication.class, args);
	}

	@Override
	public void run(String... s ) throws  Exception{
		/*userRepository.save(new User("onur","yazıcı1"));
		userRepository.save(new User("onur","yazıcı2"));
		userRepository.save(new User("onur","yazıcı3"));
		userRepository.save(new User("onur","yazıcı4"));
		userRepository.save(new User("onur","yazıcı5"));
*/
	}

}
