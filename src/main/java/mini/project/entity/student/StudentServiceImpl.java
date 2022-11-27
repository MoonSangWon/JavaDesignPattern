package mini.project.entity.student;

import mini.project.Prompt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Iterator;

@Service
public class StudentServiceImpl implements StudentService{

    private final StudentIterator studentIterator;
    @Autowired
    public StudentServiceImpl(StudentIterator studentIterator){
        this.studentIterator = studentIterator;
    }
    @Override
    public void scoreAdd() {
        System.out.println("[학생 성적 입력]");
        int grade = Prompt.inputInt("학생 학년? ");
        int cl = Prompt.inputInt("학생 반? ");
        int number = Prompt.inputInt("학생 번호? ");
        Boolean isstudent = studentIterator.findByStudent(grade,cl, number);

        if (isstudent == false) {
            System.out.println("해당 학년 학급 번호의 학생이 없습니다.");
        }
        else{
            Student student = studentIterator.setByStudent(grade,cl,number);
            student.setKor(Prompt.inputInt("국어성적? "));
            student.setEng(Prompt.inputInt("영어성적? "));
            student.setMath(Prompt.inputInt("수학성적? "));
            student.setSum(student.getKor(), student.getEng(), student.getMath());
            System.out.println("***성적 변경 완료***");
        }
    }

    @Override
    public void addToStudent() {
        System.out.println("[학생 정보 입력]");

        Boolean isStudent=false;
        while (true) {
            int grade = Prompt.inputInt("학생 학년? ");
            if (grade <= 0 || grade >= 4) {
                System.out.println("잘못된 입력값입니다.");
                break;
            }
            int cl = Prompt.inputInt("학생 반? ");
            int number = Prompt.inputInt("학생 번호?(0 : 등록취소) ");
            isStudent = studentIterator.findByStudent(grade,cl, number);
            if (number == 0) {
                System.out.println("학생 등록을 취소합니다.");
                break;
            } else if (isStudent==true) {
                System.out.println("이미 등록된 학생번호입니다.");
                break;
            } else if(isStudent==false){
                Student student =new Student();
                student.setGrade(grade);
                student.setCl(cl);
                student.setNumber(number);
                student.setName(Prompt.inputString("학생 이름? "));
                student.setGender(Prompt.inputInt("학생 성별? (1: 남자 / 2 : 여자)"));
                student.setRegisteredDate(new Date(System.currentTimeMillis()));
                studentIterator.addToStudent(student);
                System.out.println("***학생등록완료***");
                break;
            }
            }
        }

    @Override
    public void studentList() {
        studentIterator.findAll();
    }

    @Override
    public void studentDetail() {
        System.out.println("[학생 상세 조회]");
        int grade = Prompt.inputInt("학생 학년? ");
        int cl = Prompt.inputInt("학생 반? ");
        int number = Prompt.inputInt("학생 번호? ");
        Student student;
        Boolean isstudent = studentIterator.findByStudent(grade,cl, number);
        if (isstudent == false)System.out.println("해당 학년 학급 번호의 학생이 없습니다.");
        else {
            student = studentIterator.setByStudent(grade,cl,number);
            System.out.printf("학년 :"+student.getGrade()+"반 : "+student.getCl()+"번호 : "+ student.getNumber());
            System.out.printf("이름 : "+ student.getName());
            String genderLabel = null;
            switch (student.getGender()) {
                case 1:
                    genderLabel = "남자";
                    break;
                case 2:
                    genderLabel = "여자";
                    break;
            }
            System.out.printf("성별 : %s\n", genderLabel);
            System.out.printf("학년 : %s\n", student.getGrade());
            System.out.printf("국어 : %s\n", student.getKor());
            System.out.printf("영어 : %s\n", student.getEng());
            System.out.printf("수학 : %s\n", student.getMath());
            System.out.printf("총합 : %s\n", student.getSum());
            System.out.printf("평균 : %s\n", student.getAver());
            if (student.getComment() != null) {
                System.out.printf("코멘트 : %s\n", student.getComment());
            }
        }

    }

    @Override
    public void studentUpdate() {
        System.out.println("[학생 정보 변경]");
        int grade = Prompt.inputInt("학생 학년? ");
        int cl = Prompt.inputInt("학생 반? ");
        int number = Prompt.inputInt("학생 번호? ");
        Boolean isstudent = studentIterator.findByStudent(grade,cl, number);
        Student student;
        if (isstudent == false)System.out.println("해당 학년 학급 번호의 학생이 없습니다.");
        else{
            student = studentIterator.setByStudent(grade,cl,number);
            int kor = Prompt.inputInt(String.format("국어? "));
            student.setKor(kor);
            int eng = Prompt.inputInt(String.format("영어? "));
            student.setEng(eng);
            int math = Prompt.inputInt(String.format("수학? "));
            student.setMath(math);

            student.setSum(kor, eng, math);
            String response = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
            if (!response.equalsIgnoreCase("y")) System.out.println("변경을 취소하였습니다.");
            System.out.println("학생 정보를 변경하였습니다.");
            System.out.println();
        }


    }

    @Override
    public void FirstPlace() {
        System.out.println("[1등 출력]");
        studentIterator.findByStudentFirst();
    }
    @Override
    public void BottomPlace() {
        System.out.println("[꼴지 출력]");
        studentIterator.findByStudentLast();
    }

    @Override
    public void teacherComment() {
        System.out.println("[선생님 코멘트]");
        int grade = Prompt.inputInt("학생 학년? ");
        int cl = Prompt.inputInt("학생 반? ");
        int number = Prompt.inputInt("학생 번호? ");
        Student student;
        Boolean isstudent = studentIterator.findByStudent(grade,cl, number);

        if (isstudent == false) {
            System.out.println("해당 번호의 학생이 없습니다.");
        }
        else{
            student = studentIterator.setByStudent(grade,cl,number);
            student.setComment(Prompt.inputString("한줄 코멘트를 입력하세요.\n"));
        }

    }

}
