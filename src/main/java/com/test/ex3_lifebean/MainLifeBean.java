package com.test.ex3_lifebean;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainLifeBean {

	public static void main(String[] args) {

		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:lifebean.xml");
		LifeBean bean = ctx.getBean("lifeBean", LifeBeanImpl.class);
		bean.lifeMethod();
		ctx.close();

	}

}
