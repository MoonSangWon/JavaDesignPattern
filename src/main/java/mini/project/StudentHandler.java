package mini.project;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudentHandler {
  List<Student> studentList = new ArrayList<Student>();


  public void StudentSystem() {
    int num = 0;
    while((num = StudentMenu()) != 0) {
      switch (num) {
        case 1: add(); break;
        case 2: scoreAdd(); break;
        case 3: list(); break;
        case 4: FirstPlace(); break;
      }
    }
  }


  private void scoreAdd() {
    System.out.println("[학생 성적 입력]");
    int no = Prompt.inputInt("학생 번호? ");
    Student student = findByNo(no);

    if(student == null) {
      System.out.println("해당 번호의 학생이 없습니다.");
      return;
    }

    student.setGrade(Prompt.inputString("학생 학년? "));
    student.setKor(Prompt.inputInt("국어성적? "));
    student.setEng(Prompt.inputInt("영어성적? "));
    student.setMath(Prompt.inputInt("수학성적? "));

    student.setSum(student.getKor(), student.getEng(), student.getMath());

  }


  public void add() {
    System.out.println("[학생 정보 입력]");

    Student student = new Student();

    student.setNo(Prompt.inputInt("학생 번호? "));
    student.setName(Prompt.inputString("학생 이름? "));
    student.setGender(Prompt.inputInt("학생 성별? (1: 남자 / 2 : 여자)"));

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
    System.out.println("[1등총합 출력]");

    int max = -1;
    String name = null;
    for(int i = 0; i < studentList.size(); i++) {
      Student students = studentList.get(i);
      if(students.getSum() > max) {
        max = students.getSum();
      }
    }
    System.out.printf("전교 1등 총합 : %d\n", max);
  }

  private Student findByNo(int no) {
    for(int i = 0; i < studentList.size(); i++) {
      Student student = studentList.get(i);
      if(student.getNo() == no) {
        return student;
      }
    }
    return null;
  }

  public int StudentMenu() {
    return Prompt.inputInt("[1]학생정보입력 [2]학생성적입력 [3]전체학생 [4]1등총합 [0]종료");
  }
}

















