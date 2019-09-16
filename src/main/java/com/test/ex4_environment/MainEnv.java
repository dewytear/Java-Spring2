package com.test.ex4_environment;

import java.io.IOException;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

public class MainEnv {

	public static void main(String[] args) throws IOException {

		ConfigurableApplicationContext ctx = new GenericXmlApplicationContext();

		ConfigurableEnvironment env = ctx.getEnvironment();
		MutablePropertySources propertySources = env.getPropertySources();

		//propertySources(각각의 property)는 Environment에 포함되어있다.
		propertySources.addLast(new ResourcePropertySource("classpath:env.properties"));

		//env.properties 파일에서 가져온 정보를 출력
		System.out.println(env.getProperty("env.id"));
		System.out.println(env.getProperty("env.pwd"));

		GenericXmlApplicationContext gCtx = (GenericXmlApplicationContext)ctx;
		gCtx.load("env.xml");
		gCtx.refresh();

		//EnvironmentEx 생성하면서 setEnvironment를 통해 Environment 객체 생성
		EnvironmentEx envEx = gCtx.getBean("env", EnvironmentEx.class);
		System.out.println("env Id: " + envEx.getId());
		System.out.println("env Pwd: " + envEx.getPwd());

		gCtx.close();
		ctx.close();
	}//main

}//class
