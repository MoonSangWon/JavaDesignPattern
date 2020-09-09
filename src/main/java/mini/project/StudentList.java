package mini.project;

import java.util.Arrays;

public class StudentList {
  final int LENGTH = 10;
  Student[] list;
  int size = 0;

  public StudentList() {
    list = new Student[LENGTH];
  }

  public StudentList(int initialCapacity) {
    if (initialCapacity <= LENGTH) {
      list = new Student[LENGTH];
    } else {
      list = new Student[LENGTH];
    }
  }

  public void add(Student student) {
    if (size == list.length) {
      int oldCapacity = list.length;
      int newCapacity = oldCapacity + (oldCapacity >> 1);
      list = Arrays.copyOf(list, newCapacity);
    }
    list[size++] = student;
  }

  public Student[] toArray() {
    return Arrays.copyOf(list, size);

  }
}
