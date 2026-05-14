package org.example.demo2.dao.impl;

import cn.hutool.core.io.FileUtil;
import org.example.demo2.dao.StudentDao;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDaoImpl implements StudentDao {

    @Override
    public String readStudentsFile() {
        return FileUtil.readUtf8String("classpath:students.txt");
    }
}
