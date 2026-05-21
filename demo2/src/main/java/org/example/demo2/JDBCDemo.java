package org.example.demo2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.example.demo2.entity.Student;

public class JDBCDemo {

    private static final String URL = "jdbc:mysql://localhost:3306/demosql?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "mysql123";



    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    // 查询所有学生
    public List<Student> getStudents() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM student";
        try (Connection conn = getConnection();
             ResultSet rs = conn.prepareStatement(sql).executeQuery()) {
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getString("id"));
                student.setName(rs.getString("name"));
                student.setClassName(rs.getString("class_name"));
                student.setCollege(rs.getString("college"));
                student.setMajor(rs.getString("major"));
                list.add(student);
            }
        }
        return list;
    }

}
