package mini.project;

import java.sql.Date;
import java.util.Scanner;

public class StudentApp {
  public static void main(String[] args) {

    System.out.println("[학생 정보 입력]");
    Scanner scanner = new Scanner(System.in);

    final int LENGTH = 5;

    int[] no = new int[LENGTH];
    String[] name = new String[LENGTH];
    int[] gender = new int[LENGTH];
    String[] grade = new String[LENGTH];
    int[] kor = new int[LENGTH];
    int[] eng = new int[LENGTH];
    int[] math = new int[LENGTH];
    Date[] registeredDate = new Date[LENGTH];

    int size = 0;

    for(int i = 0; i < LENGTH; i++) {
      System.out.println("학생 번호? ");
      no[i] = Integer.parseInt(scanner.nextLine());

      System.out.println("학생 이름? ");
      name[i] = scanner.nextLine();

      System.out.println("학생 성별?(1 : 남자 / 2 : 여자) ");
      gender[i] = Integer.parseInt(scanner.nextLine());

      System.out.println("학생 학년?");
      grade[i] = scanner.nextLine();

      System.out.println("국어점수? ");
      kor[i] = Integer.parseInt(scanner.nextLine());

      System.out.println("영어점수? ");
      eng[i] = Integer.parseInt(scanner.nextLine());

      System.out.println("수학점수? ");
      math[i] = Integer.parseInt(scanner.nextLine());

      registeredDate[i] = new Date(System.currentTimeMillis());

      size++;
      System.out.println("계속 입력하시겠습니까?(y/N) ");
      String response = scanner.nextLine();
      if(!response.equalsIgnoreCase("y")) {
        System.out.println("입력을 완료했습니다.");
        break;
      }
      System.out.println();
    }
    scanner.close();

    System.out.println("---------------------");

    for(int i = 0; i < size; i++) {
      int sum = kor[i] + eng[i] + math[i];
      float aver = sum/3;

      String genderLabel = null;
      switch(gender[i]) {
        case 1:
          genderLabel = "남자";
          break;
        case 2:
          genderLabel = "여자";
          break;
      }

      System.out.printf("이름 : %s\n성별 : %s\n학년 : %s\n국어 : %d\n영어 : %d\n수학 : %d\n합계 : %d\n평균 : %.1f\n\n",
          name[i], genderLabel, grade[i], kor[i], eng[i], math[i], sum, aver);
    }
  }
}
