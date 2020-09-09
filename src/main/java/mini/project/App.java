package mini.project;

public class App {
  public static void main(String[] args) {


    StudentHandler studentHandler = new StudentHandler();
    Member member = new Member();


    loop:
      while(true) {
        System.out.println("[성적관리시스템 메인]");
        System.out.printf("[1] 학생성적관리\n[2] 학생등록\n[0] 종료\n");
        int command = Prompt.inputInt("명령> ");


        switch(command) {
          case 1: member.System(); break;
          case 2: studentHandler.StudentSystem(); break;
          //          case 2: studentHandler.add(); break;
          //          case 3: studentHandler.list(); break;
          //          case 4: studentHandler.FirstPlace(); break;

          case 0 : 
            System.out.println("프로그램 종료");
            break loop;
          default : System.out.println("잘못된 명령입니다."); 
        }
        System.out.println();
      }
    Prompt.close();
  }
}
