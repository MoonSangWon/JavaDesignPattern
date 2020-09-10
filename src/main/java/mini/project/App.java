package mini.project;

public class App {
  public static void main(String[] args) {


    Member member = new Member();

    loop:
      while(true) {
        System.out.println("[비트 고등학교 성적관리시스템 메인]");
        System.out.printf("[1] 선생님 로그인[0] 종료\n");
        int command = Prompt.inputInt("명령> ");

        switch(command) {
          case 1: member.System(); break;

          case 0 : 
            System.out.println("프로그램 종료");
            break loop;
          default : System.out.println("잘못된 명령입니다."); 
        }
        System.out.println();
      }
  }
}
