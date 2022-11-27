package mini.project.entity.teacher;

import mini.project.Teacherdto;

public interface TeacherIterator {
    public Teacher findId(String id);
    public void addToTeacher(Teacher teacher);
    public Boolean isId(String id);
}
