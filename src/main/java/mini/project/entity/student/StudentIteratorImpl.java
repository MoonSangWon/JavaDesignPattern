package mini.project.entity.student;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class StudentIteratorImpl implements StudentIterator{

    private List<Student> students = new ArrayList<>();

    public void findAll(){
        System.out.println("***학생 조회***");
        Iterator<Student> findAllStudent = students.iterator();
        if(findAllStudent.hasNext()==false){
            System.out.println("***학생이 없습니다.***");
        }
        else{
            while(findAllStudent.hasNext()==true) {
                Student student = findAllStudent.next();
                System.out.println("이름 : "+student.getName() +"  "+student.getGrade()+" 학년 "+ student.getCl()+" 반 "
                        + student.getNumber()+ " 번 " + "성별 : "+student.getGender());
            }
        }
    }

    @Override
    public Boolean findByStudent(int grade, int cl, int number) {
        Iterator<Student> findAllStudent = students.iterator();
        while(findAllStudent.hasNext()==true){
            Student student = findAllStudent.next();
            if(student.getCl()==cl&&student.getGrade()==grade&&student.getNumber()==number)
                return true;
        }
        return false;
    }

    @Override
    public Student setByStudent(int grade, int cl, int number){
        Iterator<Student> findAllStudent = students.iterator();
        while(findAllStudent.hasNext()==true) {
            Student student = findAllStudent.next();
            if (student.getCl() == cl && student.getGrade() == grade && student.getNumber() == number)
                return student;
        }
        return null;
    }

    @Override
    public void addToStudent(Student student) {
        this.students.add(student);
    }
    public void findByStudentFirst() {
        int threefirst = 0,twofirst=0,onefirst=0;
        String threeName ="없음",twoName="없음",oneName="없음";
        for(Student search :students){
            if(search.getGrade()==3){
                if(threefirst<search.getSum()){
                    threefirst=search.getSum();
                    threeName = search.getName();
                }
            }
            else if(search.getGrade()==2){
                if(twofirst<search.getSum()){
                    twofirst=search.getSum();
                    twoName = search.getName();
                }
            }
            else if(search.getGrade()==1){
                if(onefirst<search.getSum()){
                    onefirst=search.getSum();
                    oneName = search.getName();
                }
            }

        }
        System.out.println("3학년 1등 = " + threeName +" 2학년 1등 = "+ twoName+" 1학년 1등 = "+oneName);
    }

    @Override
    public void findByStudentLast() {
        int threelast = 1000,twolast=1000,onelast=1000;
        String threeName ="없음",twoName="없음",oneName="없음";
        for(Student search :students){
           if(search.getSum()!=0){
               if(search.getGrade()==3){
                   if(threelast>search.getSum()){
                       threelast=search.getSum();
                       threeName = search.getName();
                   }
               }
               else if(search.getGrade()==2){
                   if(twolast>search.getSum()){
                       twolast=search.getSum();
                       twoName = search.getName();
                   }
               }
               else if(search.getGrade()==1){
                   if(onelast>search.getSum()) {
                       onelast = search.getSum();
                       oneName = search.getName();
                   }
               }
           }

        }
        System.out.println("3학년 꼴등 = " + threeName + " 2학년 꼴등 = "+ twoName+" 1학년 꼴등 = "+oneName);
    }

}
