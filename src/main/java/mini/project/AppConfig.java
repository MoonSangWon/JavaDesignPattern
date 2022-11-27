package mini.project;

import mini.project.entity.student.StudentIterator;
import mini.project.entity.student.StudentIteratorImpl;
import mini.project.entity.student.StudentService;
import mini.project.entity.student.StudentServiceImpl;
import mini.project.entity.teacher.*;
import mini.project.login.LogInService;
import mini.project.login.LogInServiceImpl;
import mini.project.system.StudentSystem;
import mini.project.system.StudentSystemImpl;
import mini.project.system.SystemService;
import mini.project.system.SystemServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public LogInService logInService(){
        return new LogInServiceImpl(teacherIterator(), studentSystem());
    }
    @Bean
    public TeacherIterator teacherIterator(){
        return new TeacherIteratorImpl();
    }
    @Bean
    public StudentService studentService(){
        return new StudentServiceImpl(studentIterator());
    }
    @Bean
    public StudentIterator studentIterator(){
        return new StudentIteratorImpl();
    }
    @Bean
    public SystemService systemService() { return new SystemServiceImpl(logInService());}
    @Bean
    public StudentSystem studentSystem(){
        return new StudentSystemImpl(studentService());
    }
}
