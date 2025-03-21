package com.student.management.Service;

import com.student.management.Data.StudentData;
import com.student.management.Model.StudentModel;

import java.util.List;

public interface StudentService {

    public String addStudent(StudentData data);
    public List<StudentData> getAllStudentData();
    public StudentData getStudentsById(int id);
    public String updateStudentById(int id, StudentData data);
    public String deleteStudentById(int id);
    public StudentData searchStudentByDetail(String name,String phone,String email);
    // TODO
    public List<StudentData> getStudentBySpecificCourse(int id);
    public List<StudentData> getStudentsActive();

}
