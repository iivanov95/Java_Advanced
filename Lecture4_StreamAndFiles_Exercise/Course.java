package Lecture4_StreamAndFiles_Exercise;

import java.io.Serializable;

public class Course  implements Serializable {
    private String name;
    private int students;

    public Course(String name, int students) {
        this.name = name;
        this.students = students;
    }
}
