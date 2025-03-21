package com.student.management.Controller;

import com.student.management.Data.StudentData;
import com.student.management.Service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/student")
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;

    @PostMapping("/create")
    public String addStudent(@RequestBody StudentData data){
        String result = studentService.addStudent(data);
        return result;
    }
    @GetMapping("/all")
    public List<StudentData> getAllStudentData(){
        // create method to get all students details
        List<StudentData> studentDataList = studentService.getAllStudentData();
        return studentDataList;
    }
    @GetMapping("/getStudentDetails/{id}")
    public StudentData getStudentsById(@PathVariable(name = "id") int id){
        StudentData result = studentService.getStudentsById(id);
        return result;
    }

    @PutMapping("/UpdateStudentDetails/{id}")
    public String updateStudentById(@PathVariable(name = "id") int id, @RequestBody StudentData data){
        String result = studentService.updateStudentById(id,data);
        return result;
    }

    @DeleteMapping("/DeleteStudentDetails/{id}")
    public String deleteStudentById(@PathVariable (name = "id") int id){
        String result = studentService.deleteStudentById(id);
        return result;
    }

    @GetMapping("/Search")
    public StudentData searchStudentByDetail(@RequestParam(value = "name", required = false) String name,
                                             @RequestParam(value = "email", required = false) String email,
                                             @RequestParam(value = "phone",required = false) String phoneNo){
        StudentData result = studentService.searchStudentByDetail(name, email, phoneNo);
        return result;
    }

    @GetMapping("/GetStudentsBySpecificCourse/{id}")
    public List<StudentData> getStudentBySpecificCourse(@PathVariable(name = "id") int id){
        return null;
    }

    @GetMapping("/GetActiveStudents")
    public List<StudentData> getStudentsActive(){
        List<StudentData> result = studentService.getStudentsActive();
        return result;
    }

}
