package mini.project;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudentHandler {
  List<Student> studentList = new ArrayList<Student>();

  public void add() {
    System.out.println("[학생 정보 입력]");

    Student student = new Student();

    student.setNo(Prompt.inputInt("학생 번호? "));
    student.setName(Prompt.inputString("학생 이름? "));
    student.setGender(Prompt.inputInt("학생 성별? (1: 남자 / 2 : 여자)"));
    student.setGrade(Prompt.inputString("학생 학년? "));
    student.setKor(Prompt.inputInt("국어성적? "));
    student.setEng(Prompt.inputInt("영어성적? "));
    student.setMath(Prompt.inputInt("수학성적? "));

    student.setSum(student.getKor(), student.getEng(), student.getMath());

    student.setRegisteredDate(new Date(System.currentTimeMillis()));

    studentList.add(student);
  }


  public void list() {
    System.out.println("[학생 목록]");

    Iterator<Student> iterator = studentList.iterator();

    while(iterator.hasNext()) {
      Student student = iterator.next();

      String genderLabel = null;
      switch(student.getGender()) {
        case 1:
          genderLabel = "남자";
          break;
        case 2:
          genderLabel = "여자";
          break;
      }

      System.out.printf("이름 : %s\n성별 : %s\n학년 : %s\n국어 : %d\n영어 : %d\n"
          + "수학 : %d\n합계 : %d\n평균 : %.1f\n등록일 : %s\n\n",
          student.getName(),
          genderLabel,
          student.getGrade(),
          student.getKor(),
          student.getEng(),
          student.getMath(),
          student.getSum(),
          student.getAver(),
          student.getRegisteredDate());
    }
  }

  public void FirstPlace() {
    for(int i = 0; i < studentList.size(); i++) {
      System.out.println("[1등 출력]");
      Student student = studentList.get(i); //


    }
  }
}

















