package com.test.ex6_profile;

import java.util.Scanner;
import org.springframework.context.support.GenericXmlApplicationContext;

// 1. xml�������Ͽ��� profile �о���� ���
public class MainProfile {

	public static void main(String[] args) {
		String profile = null;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Profile ���� �Է��ϼ���: ");
		String str = scanner.next();

		if(str.equalsIgnoreCase("development")) {
			profile = "development";
		}else {
			profile = "service";
		}

		scanner.close();

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.getEnvironment().setActiveProfiles(profile); // ���������� ����
		ctx.load("profile_dev.xml", "profile_service.xml");

		ProfileEx prof = ctx.getBean("profileEx", ProfileEx.class);
		System.out.println("IP: " + prof.getIp());
		System.out.println("Port: " + prof.getPort());

		ctx.close();
	}


}
