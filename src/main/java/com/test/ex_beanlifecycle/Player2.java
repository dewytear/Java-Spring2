package com.test.ex_beanlifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

// Annotation �̿�
public class Player2 {

	private String name;				// ������
	private int age;                    // ����

	public Player2() {};	// construct default

	public Player2(String name, int age) {

		this.name = name;
		this.age = age;

	} // ���ڻ�����

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	@PostConstruct
	public void init(){
		System.out.println("Annotation: �� ������ ó���� ���~");
	}

	@PreDestroy
	public void destroy(){
		System.out.println("Annotation: �� �Ҹ�� ó���� ���!");
	}
}
