package com.test.ex6_profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("service")
public class ConfigService {

	@Bean
	public ProfileEx profileEx() {
		ProfileEx prof = new ProfileEx();

		//[region] TEST
		prof.setIp("192.168.0.2");
		prof.setPort("88");//[end]
		return prof;
	}

}
