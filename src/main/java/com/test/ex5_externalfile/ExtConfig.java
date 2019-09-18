package com.test.ex5_externalfile;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

// 이 자바 파일은 설정 파일입니다.
// 2. xml파일에서 가져오지 않고 java 파일에서 외부 파일을 가져오는 방법
@Configuration
public class ExtConfig {

	@Value("${env.id}")
	private String envId;
	@Value("${env.pwd}")
	private String envPwd;
	@Value("${ext.id}")
	private String extId;
	@Value("${ext.pwd}")
	private String extPwd;

	@Bean
	// 시스템 컨테이너에서 자동으로 Properties() 호출하여 메모리(static)에 올림
	public static PropertySourcesPlaceholderConfigurer Properties() {

		//프로퍼티 파일의 위치값을 저장하는 객체
		PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
		Resource[] loc = new Resource[2];
		loc[0] = new ClassPathResource("env.properties");
		loc[1] = new ClassPathResource("external.properties");
		// configurer객체에 resource를 배열로 저장
		configurer.setLocations(loc);

		return configurer;
	}//properties()

	@Bean
	// Bean 생성
	public ExternalFileEx extConf() {
		ExternalFileEx ext = new ExternalFileEx();
		ext.setId(envId);
		ext.setPwd(envPwd);
		ext.setExtId(extId);
		ext.setExtPwd(extPwd);

		return ext;
	}//extConfig()
}
