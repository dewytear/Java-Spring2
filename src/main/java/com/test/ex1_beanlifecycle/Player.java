package com.test.ex1_beanlifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

// Interfave �̿�
public class Player implements InitializingBean, DisposableBean {

	private String name;				// ������
	private int age;                    // ����

	public Player() {};	// construct default

	public Player(String name, int age) {

		this.name = name;
		this.age = age;

	} // ���ڻ�����

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Interface: �� ������ ó���� ���~");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Interface: �� �Ҹ�� ó���� ���!");

	}
}
