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

		//propertySources(������ property)�� Environment�� ���ԵǾ��ִ�.
		propertySources.addLast(new ResourcePropertySource("classpath:env.properties"));

		//env.properties ���Ͽ��� ������ ������ ���
		System.out.println(env.getProperty("env.id"));
		System.out.println(env.getProperty("env.pwd"));

		GenericXmlApplicationContext gCtx = (GenericXmlApplicationContext)ctx;
		gCtx.load("env.xml");
		gCtx.refresh();

		//EnvironmentEx �����ϸ鼭 setEnvironment�� ���� Environment ��ü ����
		EnvironmentEx envEx = gCtx.getBean("env", EnvironmentEx.class);
		System.out.println("env Id: " + envEx.getId());
		System.out.println("env Pwd: " + envEx.getPwd());

		gCtx.close();
		ctx.close();
	}//main

}//class
