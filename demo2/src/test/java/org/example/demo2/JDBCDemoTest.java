package org.example.demo2;

import org.example.demo2.entity.Student;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;


class JDBCDemoTest {

    private final JDBCDemo demo = new JDBCDemo();

    @Test
    void testGetStudents() throws ClassNotFoundException, SQLException {
        List<Student> students = demo.getStudents();
        for (Student s : students) {
            System.out.println("id=" + s.getId() + ", name=" + s.getName()
                    + ", class=" + s.getClassName() + ", college=" + s.getCollege()
                    + ", major=" + s.getMajor());
        }
    }
}
