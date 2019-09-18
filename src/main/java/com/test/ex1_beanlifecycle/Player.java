package com.test.ex1_beanlifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

// Interfave 이용
public class Player implements InitializingBean, DisposableBean {

	private String name;				// 선수명
	private int age;                    // 나이

	public Player() {};	// construct default

	public Player(String name, int age) {

		this.name = name;
		this.age = age;

	} // 인자생성자

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Interface: 빈 생성시 처리할 명령~");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Interface: 빈 소멸시 처리할 명령!");

	}
}
