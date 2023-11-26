package org.Test1;

/**
 * @author liu
 * @date 2023/11/25 9:15
 */
public class Student
implements Person{
    String name;

    @Override
    public void eat() {
        System.out.println("eat");
    }

    public Student() {

    }

    public Student(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
