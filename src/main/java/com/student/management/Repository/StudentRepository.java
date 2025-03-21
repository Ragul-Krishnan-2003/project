package com.student.management.Repository;

import com.student.management.Model.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentModel,Integer> {

    public StudentModel findByStudentName(String name);

    public StudentModel findByStudentEmailId(String email);

    public StudentModel findByStudentNumber(String phoneNo);

    public List<StudentModel> findByStudentStatus(boolean status);
}
