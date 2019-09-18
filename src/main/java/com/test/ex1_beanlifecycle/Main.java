package com.test.ex1_beanlifecycle;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		String confLoc = "classpath:baseball4.xml";
		//GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(confLoc);
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load(confLoc);
		ctx.refresh();

		ctx.close();
	}

}
