package com.student.management.Service;

import com.student.management.Data.StudentData;
import com.student.management.Model.StudentModel;
import com.student.management.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
//    converting data into model
    public String addStudent(StudentData data) {
        // converting the Student data to Student model
        StudentModel model = convertDataToModel(data);
        studentRepository.save(model);
        return "Saved Successfully";
    }

    @Override
    public List<StudentData> getAllStudentData() {
        // fetch studentModel from Table
      List<StudentModel> modellist = studentRepository.findAll();
       // convert the list of StudentModel to List of StudentData
      List<StudentData> dataList = new ArrayList<>();
      for(StudentModel model: modellist){
          StudentData data = convertModelToData(model);
          dataList.add(data);
      }
       //returning the List of StudentData
        return dataList;
    }

    @Override
    public StudentData getStudentsById(int id) {
        StudentModel model = studentRepository.findById(id).orElse(null);
        StudentData data = convertModelToData(model);
        return data;
    }

    @Override
    public String updateStudentById(int id, StudentData data) {
        StudentModel model= convertDataToModel(data);
        model.setStudentId(id);
        studentRepository.save(model);
        return "Updated Successfully";
    }

    @Override
    public String deleteStudentById(int id) {
        studentRepository.deleteById(id);
        return "Deleted Successfully";
    }

    @Override
    public StudentData searchStudentByDetail(String name, String phone, String email) {

        StudentModel model = null;

        if(name != null){
            model = studentRepository.findByStudentName(name);
        }else if(phone != null){
            model = studentRepository.findByStudentNumber(phone);
        } else if (email != null) {
            model = studentRepository.findByStudentEmailId(email);
        }

        StudentData data = convertModelToData(model);
        return data;
    }

    @Override
    public List<StudentData> getStudentBySpecificCourse(int id) {
        return List.of();
    }

    @Override
    public List<StudentData> getStudentsActive() {
        List<StudentModel> activeStudentModelList = studentRepository.findByStudentStatus(true);
        List<StudentData> dataList = new ArrayList<>();

        for(StudentModel model : activeStudentModelList){
            StudentData data = convertModelToData(model);
            dataList.add(data);
        }

        return dataList;
    }

    public StudentData convertModelToData(StudentModel model){
        StudentData data = new StudentData();
        data.setStudentName(model.getStudentName());
        data.setStudentNumber(model.getStudentNumber());
        data.setStudentEmailId(model.getStudentEmailId());
        data.setStudentStatus(model.isStudentStatus());
        data.setStudentId(model.getStudentId());
        return data;
    }

    public StudentModel convertDataToModel(StudentData data){
        StudentModel model = new StudentModel();
        model.setStudentName(data.getStudentName());
        model.setStudentEmailId(data.getStudentEmailId());
        model.setStudentNumber(data.getStudentNumber());
        model.setStudentStatus(data.isStudentStatus());
        return model;
    }
}
