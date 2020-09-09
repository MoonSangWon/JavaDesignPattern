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
        case 3: studentList(); break;
        case 4: StudentDetail(); break;
        case 5: FirstPlace(); break;
        case 6: BottomPlace(); break;
        case 7: studentUpdate(); break;
      }
      System.out.println();
    }
  }

  public int StudentMenu() {
    return Prompt.inputInt(
        "[1]학생정보입력"
            + " [2]학생성적입력"
            + " [3]전체학생"
            + " [4]학생 상세조회\n"
            + "[5]1등총합"
            + " [6]꼴지총합"
            + " [7]학생 정보수정"
            + " [0]종료");

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


  public void studentList() {
    System.out.println("[학생 목록]");

    Iterator<Student> iterator = studentList.iterator();

    while(iterator.hasNext()) {
      Student student = iterator.next();

      String genderLabel = null;
      switch(student.getGender()) {
        case 1: genderLabel = "남자"; break;
        case 2: genderLabel = "여자"; break;
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

  public void StudentDetail() {
    System.out.println("[학생 상세 조회]");
    int no = Prompt.inputInt("학생 번호? ");
    Student student = findByNo(no);

    if(student == null) {
      System.out.println("해당 번호의 학생이 없습니다.");
      return;
    }

    System.out.printf("이름 : %s\n", student.getName());
    String genderLabel = null;
    switch(student.getGender()) {
      case 1: genderLabel = "남자"; break;
      case 2: genderLabel = "여자"; break;
    }
    System.out.printf("성별 : %s\n", genderLabel);
    System.out.printf("학년 : %s\n", student.getGrade());
    System.out.printf("국어 : %s\n", student.getKor());
    System.out.printf("영어 : %s\n", student.getEng());
    System.out.printf("수학 : %s\n", student.getMath());
    System.out.printf("총합 : %s\n", student.getSum());
    System.out.printf("평균 : %s\n", student.getAver());
  }

  public void studentUpdate() {
    System.out.println("[학생 정보 변경]");
    int no = Prompt.inputInt("학생 번호? ");
    Student student = findByNo(no);

    if(student == null) {
      System.out.println("해당 번호의 학생이 없습니다.");
      return;
    }
    String name = Prompt.inputString(
        String.format("이름(%s)? ", student.getName()));
    String grade = Prompt.inputString(
        String.format("학년(%s)? ", student.getGrade()));
    int kor = Prompt.inputInt(
        String.format("국어(%s)? ", student.getKor()));
    int eng = Prompt.inputInt(
        String.format("영어(%s)? ", student.getEng()));
    int math = Prompt.inputInt(
        String.format("수학(%s)? ", student.getMath()));

    student.setSum(kor, eng, math);


    String response = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (!response.equalsIgnoreCase("y")) {
      System.out.println("변경을 취소하였습니다.");
      return;
    }
    student.setName(name);
    student.setGrade(grade);
    student.setKor(kor);
    student.setEng(eng);
    student.setMath(math);
    student.getSum();

    System.out.println("학생 정보를 변경하였습니다.");
  }

  public void FirstPlace() {
    System.out.println("[1등 출력]");
    Iterator<Student> iterator = studentList.iterator();

    int[] first = new int[studentList.size()];
    int max = first[0];

    while(iterator.hasNext()) {
      Student student = iterator.next();
      if(student.getSum() > max) {
        max = student.getSum();
      }
    }

    System.out.println("1등 총합 : " + max);
    System.out.println("와우! 대단해요!");

    //    int max = -1;
    //    for(int i = 0; i < studentList.size(); i++) {
    //      Student student = studentList.get(i);
    //      if(student.getSum() > max) {
    //        max = student.getSum();
    //      }
    //    }
    //    System.out.println("1등 총합 : " + max);
    //    System.out.println("와우! 대단해요!");
  }

  public void BottomPlace() {
    System.out.println("[꼴지 출력]");

    int[] bottom = new int[studentList.size()];
    int min = bottom[0];

    for(int i = 0; i < studentList.size(); i++) {

      Student student = studentList.get(i);
      if(student.getSum() < min) {
        min = student.getSum();
      }
    }
    System.out.println("꼴지 총합 : " + min);
    System.out.println("격려가 필요합니다.");
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
}
