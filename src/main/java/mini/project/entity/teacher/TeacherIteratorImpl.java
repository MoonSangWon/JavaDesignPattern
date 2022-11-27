package mini.project.entity.teacher;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TeacherIteratorImpl implements TeacherIterator{

    private List<Teacher> teachers = new ArrayList<>();


    @Override
    public Teacher findId(String id) {
       for(Teacher search: teachers){
           if(search.getId().equals(id)) {
               return search;
               
           }
       }
        return new Teacher("0","0","0");
    }

    @Override
    public void addToTeacher(Teacher teacher) {
        this.teachers.add(teacher);
    }

    @Override
    public Boolean isId(String id) {
        for(Teacher search: teachers){
            if(search.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
}
