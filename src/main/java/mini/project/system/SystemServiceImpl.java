package mini.project.system;

import mini.project.Prompt;
import mini.project.login.LogInService;
import org.springframework.beans.factory.annotation.Autowired;

public class SystemServiceImpl implements SystemService{
    private final LogInService logInService;

    @Autowired
    public SystemServiceImpl(LogInService logInService) {
        this.logInService = logInService;
    }

    public int menu() {
        return Prompt.inputInt("[1]로그인 [2]회원가입 [0]종료\n");
    }

    public void run(){

        int num = 0;
        while ((num = menu()) != 0) {
            switch (num) {
                case 1:
                    logInService.login();
                    break;
                case 2:
                    logInService.join();
                    break;
            }
        }
    }
}
