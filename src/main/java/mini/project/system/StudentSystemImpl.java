package mini.project.system;

import mini.project.Prompt;
import mini.project.entity.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentSystemImpl implements StudentSystem{

    private final StudentService studentService;
    @Autowired
    public StudentSystemImpl(StudentService studentService){
        this.studentService = studentService;
    }
    public int StudentMenu() {
        System.out.println("**0번을 누르면 메인 창으로 이동됩니다.**");
        return Prompt.inputInt("[1]학생 정보 입력" + " [2]학생 성적 입력" + " [3]학생 목록" + " [4]학생 상세 조회\n"
                + "[5]학생 정보 수정" +  " [6]1등은? " + " [7]꼴찌는? " + " [8]선생님 코멘트 \n");
    }
    public void run(){
        int num = 0;
        loop: while ((num = StudentMenu()) != 0) {
            switch (num) {
                case 1:
                    studentService.addToStudent();
                    break;
                case 2:
                    studentService.scoreAdd();
                    break;
                case 3:
                    studentService.studentList();
                    break;
                case 4:
                    studentService.studentDetail();
                    break;
                case 5:
                    studentService.studentUpdate();
                    break;
                case 6:
                    studentService.FirstPlace();
                    break;
                case 7:
                    studentService.BottomPlace();;
                    break;
                case 8:
                    studentService.teacherComment();;
                    break;
                case 0:
                    System.out.println("학생등록시스템 종료");
                    break loop;
                default:
                    System.out.println("잘못된 명령입니다.");
            }
            System.out.println();
        }
    }

}
