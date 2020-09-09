package mini.project;

import java.sql.Date;

public class StudentHandler {
  StudentList studentList = new StudentList();

  public void add() {
    System.out.println("[학생 정보 입력]");

    Student student = new Student();

    student.setName(Prompt.inputString("학생 이름? "));
    student.setGender(Prompt.inputInt("학생 성별? (1: 남자 / 2 : 여자)"));
    student.setGrade(Prompt.inputString("학생 학년? "));
    student.setKor(Prompt.inputInt("국어성적? "));
    student.setEng(Prompt.inputInt("영어성적? "));
    student.setMath(Prompt.inputInt("수학성적? "));
    student.setRegisteredDate(new Date(System.currentTimeMillis()));

    studentList.add(student);
  }


  public void list() {
    System.out.println("[학생 목록]");

    Student[] students = studentList.toArray();

    for(Student student : students) {
      String genderLabel = null;
      switch(student.getGender()) {
        case 1:
          genderLabel = "남자";
          break;
        case 2:
          genderLabel = "여자";
          break;
      }
      int sum = student.getKor() + student.getEng() + student.getMath();
      float aver = sum/3;

      System.out.printf("이름 : %s\n성별 : %s\n학년 : %s\n국어 : %d\n영어 : %d\n"
          + "수학 : %d\n합계 : %d\n평균 : %.1f\n등록일 : %s\n",
          student.getName(),
          genderLabel,
          student.getGrade(),
          student.getKor(),
          student.getEng(),
          student.getMath(),
          sum,
          aver,
          student.getRegisteredDate());
    }


  }

}

