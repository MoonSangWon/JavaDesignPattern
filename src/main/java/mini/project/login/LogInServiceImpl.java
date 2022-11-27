package mini.project.login;

import mini.project.Prompt;
import mini.project.entity.teacher.Teacher;
import mini.project.entity.teacher.TeacherIterator;
import mini.project.system.StudentSystem;
import org.springframework.beans.factory.annotation.Autowired;

public class LogInServiceImpl implements LogInService{

    private final TeacherIterator teacherIterator;
    private final StudentSystem studentSystem;
    @Autowired
    public LogInServiceImpl(TeacherIterator teacherIterator, StudentSystem studentSystem){
        this.teacherIterator = teacherIterator;
        this.studentSystem = studentSystem;
    }
    @Override
    public void login() {
        System.out.println("***로그인***");
        String Id = Prompt.inputString("ID : ");
        String Password = Prompt.inputString("Password : ");
        while (true) {
            Teacher teacher = teacherIterator.findId(Id);
            if (!teacher.getId().equals(Id)) {
                System.out.println("입력하신 아이디가 일치하지 않습니다.");
                System.out.println("다시 입력하시오.");
                Id = Prompt.inputString("ID : ");
            }
           else if(!teacher.getPassword().equals(Password)){
                System.out.println("입력하신 비밀번호가 일치하지 않습니다.");
                System.out.println("다시 입력하시오.");
                Password = Prompt.inputString("Password : ");
            }
           else studentSystem.run();
        }
    }

    @Override
    public void join() {
        System.out.println("***회원가입***");
        String Id = Prompt.inputString("ID : ");
        String Password = Prompt.inputString("Password : ");
        String Password2 = Prompt.inputString("Password Confirm : ");
        String Name = Prompt.inputString("Name : ");
        while(true){
            Boolean isId = teacherIterator.isId(Id);
            if (isId ==true) {
                System.out.println("중복된 ID입니다.");
                Id = Prompt.inputString("ID : ");
            }
            else if(Password.equals(Password2)&&isId==false) {
                Teacher teacher =new Teacher(Id,Password,Name);
                teacherIterator.addToTeacher(teacher);
                System.out.println("회원가입이 완료되었습니다.");
                break;
            }
            else {
                System.out.println("비밀번호를 다시 입력하시오.");
                Password2 = Prompt.inputString("Password Confirm : ");
            }
        }
    }
}
