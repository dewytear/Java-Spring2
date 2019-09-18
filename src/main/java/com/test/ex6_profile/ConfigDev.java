package com.test.ex6_profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("development")
public class ConfigDev {

	@Bean
	public ProfileEx profileEx() {
		ProfileEx prof = new ProfileEx();
		prof.setIp("Localhost");
		prof.setPort("9090");
		return prof;
	}

}
