package com.test.ex5_externalfile;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainExternal_Java {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ExtConfig.class);
		ExternalFileEx ext = ctx.getBean("extConf", ExternalFileEx.class);

		System.out.println("envId: " + ext.getId());
		System.out.println("envPwd: " + ext.getPwd());
		System.out.println("extId: " + ext.getExtId());
		System.out.println("extPwd: " + ext.getExtPwd());

		ctx.close();
	}

}
