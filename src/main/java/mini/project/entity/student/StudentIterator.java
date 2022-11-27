package mini.project.entity.student;

public interface StudentIterator {
    public void findAll();

    public Boolean findByStudent(int grade, int cl, int number);
    public Student setByStudent(int grade, int cl, int number);
    public void addToStudent(Student student);

    public void findByStudentFirst();

    public void findByStudentLast();
}
