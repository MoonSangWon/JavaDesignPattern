package mini.project.entity.teacher;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import mini.project.Prompt;

import javax.persistence.Column;
import javax.persistence.Table;

@Getter@Setter
public class Teacher {

	private String id;
	private String password;
	private String teacherName;

	public Teacher(String id, String password, String teacherName){
		this.id =id;
		this.password = password;
		this.teacherName = teacherName;
	}
	/*public void System() {
		int num = 0;
		while ((num = menu()) != 0) {
			switch (num) {
			case 1:
				TeacherLogin();
				break;
			case 2:
				TeacherJoin();
				break;
			case 3:
				TeacherList();
			}
		}
	}*/

	/*private void TeacherJoin() {
		String Id = Prompt.inputString("ID : ");
		String Password = Prompt.inputString("Password : ");
		String Password2 = Prompt.inputString("Password Confirm : ");
		String Name = Prompt.inputString("Name : ");

		if(TestId(Id)) {
			System.out.println("중복된 ID입니다.");
		} else if(Password.equals(Password2)) {
			members.add(new Teacherdto(Id, Password, Name));
			System.out.println("회원가입이 완료되었습니다.");
		} else {
			System.out.println("비밀번호를 다시 입력하시오.");
		}
	}
*/
	/*private void TeacherLogin() {
		while (true) {
			String Id = Prompt.inputString("ID : ");

			String Password = Prompt.inputString("Password : ");

			Teacherdto member = FindId(Id);
			StudentHandler stu = new StudentHandler();

			if (member == null) {
				System.out.println("입력하신 아이디가 일치하지 않습니다.");
				System.out.println("다시 입력하시오.");
			} else if(member.getPassword().equals(Password)) {
				System.out.println("학생정보관리시스템에 접속하였습니다.");
				stu.StudentSystem();
				break;
			} else {
				System.out.println("입력하신 패스워드가 일치하지 않습니다.");
				System.out.println("다시 입력하시오.");
			}
		}
	}*/

	/*public boolean TestId(String Id) {
		boolean check = true;
		Teacherdto member = FindId(Id);
		if (member == null)
			check = false;
		return check;

	}*/

	/*private Teacherdto FindId(String Id) {
		for(Teacherdto memberLogin : members) {
			if(memberLogin.getId().equals(Id)) {
				return memberLogin;
			}
		}
		return null;
	}*/

	/*public int menu() {
		return Prompt.inputInt("[1]로그인 [2]회원가입 [3]전체회원 [0]종료");
	}*/


}
