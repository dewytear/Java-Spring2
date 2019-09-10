package com.test.ex2_beanscope;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class PersonInfo {

	public static void main(String[] args) {
		String confLoc = "classpath:person.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(confLoc);
		Person person1 = ctx.getBean("person", Person.class);
		System.out.println("이름: " + person1.getName());
		System.out.println("나이: " + person1.getAge());
		System.out.println("person1: " + person1);
		System.out.println("---------------------------");

		Person person2 = ctx.getBean("person", Person.class);
		person2.setName("고길동");
		System.out.println("이름: " + person2.getName());
		System.out.println("나이: " + person2.getAge());
		System.out.println("person2: " + person2);
		System.out.println("---------------------------");

		/*
		 *  xml파일내의 bean태그내의 scope 속성값(single,protype)에 따라 결과가 달라진다.
		    <bean> 태그의 속성 값 : default 값은 singleton
		      singleton : spring container에 의해 한 개의 bean 객체만 생성
		      prototype : bean을 사용(getBean())할 때 마다 객체를 생성
		 */
		if(person1.equals(person2)) {
			System.out.println("person1 == person2");
		}else {
			System.out.println("person1 != person2");
		}

		ctx.close();
	}

}
