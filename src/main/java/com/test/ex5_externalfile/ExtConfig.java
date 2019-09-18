package com.test.ex5_externalfile;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

// �� �ڹ� ������ ���� �����Դϴ�.
// 2. xml���Ͽ��� �������� �ʰ� java ���Ͽ��� �ܺ� ������ �������� ���
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
	// �ý��� �����̳ʿ��� �ڵ����� Properties() ȣ���Ͽ� �޸�(static)�� �ø�
	public static PropertySourcesPlaceholderConfigurer Properties() {

		//������Ƽ ������ ��ġ���� �����ϴ� ��ü
		PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
		Resource[] loc = new Resource[2];
		loc[0] = new ClassPathResource("env.properties");
		loc[1] = new ClassPathResource("external.properties");
		// configurer��ü�� resource�� �迭�� ����
		configurer.setLocations(loc);

		return configurer;
	}//properties()

	@Bean
	// Bean ����
	public ExternalFileEx extConf() {
		ExternalFileEx ext = new ExternalFileEx();
		ext.setId(envId);
		ext.setPwd(envPwd);
		ext.setExtId(extId);
		ext.setExtPwd(extPwd);

		return ext;
	}//extConfig()
}
