package com.test.ex2_beanscope;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class PersonInfo {

	public static void main(String[] args) {
		String confLoc = "classpath:person.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(confLoc);
		Person person1 = ctx.getBean("person", Person.class);
		System.out.println("�̸�: " + person1.getName());
		System.out.println("����: " + person1.getAge());
		System.out.println("person1: " + person1);
		System.out.println("---------------------------");

		Person person2 = ctx.getBean("person", Person.class);
		person2.setName("��浿");
		System.out.println("�̸�: " + person2.getName());
		System.out.println("����: " + person2.getAge());
		System.out.println("person2: " + person2);
		System.out.println("---------------------------");

		/*
		 *  xml���ϳ��� bean�±׳��� scope �Ӽ���(single,protype)�� ���� ����� �޶�����.
		    <bean> �±��� �Ӽ� �� : default ���� singleton
		      singleton : spring container�� ���� �� ���� bean ��ü�� ����
		      prototype : bean�� ���(getBean())�� �� ���� ��ü�� ����
		 */
		if(person1.equals(person2)) {
			System.out.println("person1 == person2");
		}else {
			System.out.println("person1 != person2");
		}

		ctx.close();
	}

}
