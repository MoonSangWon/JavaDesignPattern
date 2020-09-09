package mini.project;

import java.sql.Date;

public class Student {

  private int no;
  private String name;
  private int gender;
  private String grade;
  private int kor;
  private int eng;
  private int math;
  private int sum;
  private float aver;

  private Date registeredDate;

  private static final int LENGTH = 5;

  public int getSum() {
    return sum;
  }

  public void setSum(int kor, int eng, int math) {
    sum = kor+eng+math;
    aver = sum/3.f;
  }

  public void setAver(float aver) {
    this.aver = aver;
  }

  public float getAver() {
    return aver;
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getGender() {
    return gender;
  }

  public void setGender(int gender) {
    this.gender = gender;
  }

  public String getGrade() {
    return grade;
  }

  public void setGrade(String grade) {
    this.grade = grade;
  }

  public int getKor() {
    return kor;
  }

  public void setKor(int kor) {
    this.kor = kor;
  }

  public int getEng() {
    return eng;
  }

  public void setEng(int eng) {
    this.eng = eng;
  }

  public int getMath() {
    return math;
  }

  public void setMath(int math) {
    this.math = math;
  }

  public Date getRegisteredDate() {
    return registeredDate;
  }

  public void setRegisteredDate(Date registeredDate) {
    this.registeredDate = registeredDate;
  }

  public static int getLength() {
    return LENGTH;
  }



}
