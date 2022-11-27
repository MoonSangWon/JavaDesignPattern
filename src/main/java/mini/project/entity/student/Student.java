package mini.project.entity.student;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
@Getter@Setter
public class Student {

  private int number; //번호
  private int cl;//반
  private String name; //이름
  private int gender; //성별
  private int grade; //학년
  private int kor;
  private int eng;
  private int math;
  private int sum;
  private float aver;
  private String comment;

  private Date registeredDate;

  private static final int LENGTH = 5;
  public Student(){
    this.number=0;this.cl=0;this.name="";this.gender=1;
    this.grade=0;this.kor=0;this.eng=0;this.math=0;this.sum=0;this.aver =0;this.comment="";
  }
  public void setSum(int kor, int eng, int math) {
    sum = kor+eng+math;
    aver = sum/3.f;
  }

/*

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public int getSum() {
    return sum;
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


*/

}
