package mini.project;

import java.util.Scanner;

public class Teacher {
	public static void main(String[] args) {
		System.out.println("[학생정보관리]");

		Scanner scanner = new Scanner(System.in);

		while (true) {
			String Id = Prompt.inputString("ID : ");

			String Password = Prompt.inputString("Password : ");

			Login l = new Login(Id, Password);
			boolean result = l.Test();

			if (result == false) {
				System.out.println("입력하신 아이디와 패스워드가 일치하지 않습니다.");
				System.out.println("다시 입력하시오.");
			} else {
				System.out.println("학생정보관리시스템에 접속하였습니다.");
				break;
			}

		}
	}

}
