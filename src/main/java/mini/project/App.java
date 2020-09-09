package mini.project;

public class App {
	public static void main(String[] args) {


		StudentHandler studentHandler = new StudentHandler();
		Member member = new Member();

		loop:
			while(true) {
				String command = Prompt.inputString("명령> ");

				switch(command) {
				case "학생성적관리": member.System(); break;
				case "학생등록": studentHandler.add(); break;
				case "학생조회": studentHandler.list(); break;

				case "quit" : 
				case "exit" :
					System.out.println("프로그램 종료");
					break loop;
				default : System.out.println("잘못된 명령입니다."); 
				}
				System.out.println();
			}
		Prompt.close();
	}
}
