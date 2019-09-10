package com.test.ex_beanlifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

// Annotation 이용
public class Player2 {

	private String name;				// 선수명
	private int age;                    // 나이

	public Player2() {};	// construct default

	public Player2(String name, int age) {

		this.name = name;
		this.age = age;

	} // 인자생성자

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	@PostConstruct
	public void init(){
		System.out.println("Annotation: 빈 생성시 처리할 명령~");
	}

	@PreDestroy
	public void destroy(){
		System.out.println("Annotation: 빈 소멸시 처리할 명령!");
	}
}
