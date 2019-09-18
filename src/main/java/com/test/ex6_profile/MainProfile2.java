package com.test.ex6_profile;

import java.util.Scanner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// 2. java �������Ͽ��� profile �о���� ���
public class MainProfile2 {

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

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.getEnvironment().setActiveProfiles(profile); // ���������� ����
		ctx.register(ConfigDev.class, ConfigService.class);
		ctx.refresh();

		ProfileEx prof = ctx.getBean("profileEx", ProfileEx.class);
		System.out.println("IP: " + prof.getIp());
		System.out.println("Port: " + prof.getPort());

		ctx.close();

	}

}
