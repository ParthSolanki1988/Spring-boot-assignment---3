package com.simform.studentslf4j.Controller;

import com.simform.studentslf4j.Entity.Student;
import com.simform.studentslf4j.Service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/v1/students")
public class StudentController {

  @Autowired
  private StudentService studentService;

  // build create User REST API

  //  CREAT
  @PostMapping
  public ResponseEntity<Student> createStudents(@RequestBody Student student){

    if (student.getId() == 0 || student.getId() < 0){
      log.warn("Enter Valid Id for Create Student");
      return null;
    }
    else {
      log.info("Create User");
      Student saveStudent = studentService.createStudent(student);
      return new ResponseEntity<>(saveStudent , HttpStatus.CREATED);
    }
  }

  //READ

  // build get user by id REST API
  // http://localhost:8080/api/v1/studens
  @GetMapping
  public ResponseEntity<List<Student>> getAllStudents(){
    log.info("Getting all student ");
    List<Student> listOfStudent = studentService.getAllStudents();
    return new ResponseEntity<>(listOfStudent , HttpStatus.OK );
  }


  //UPDATE

  // http://localhost:8080/api/v1/students/{id}
  @PutMapping("{id}")
  public ResponseEntity<Student> updatedStudent(@PathVariable("id") Long id,@RequestBody Student student){
    boolean isDigit = true;

//    try{
//      Integer.parseInt()
//    }

   if (id == 0 || id < 0){
     log.warn("Enter Valid Id for update student");
     return null;
   }
   else {
     log.info("updating the student , Id : " + id );
     student.setId(id);
     Student updateStudents = studentService.updateStudent(student);
     return new ResponseEntity<>(updateStudents , HttpStatus.OK);
   }
  }


  // DELETE

  // http://localhost:8080/api/v1/students/{id}
  @DeleteMapping("{id}")
  public ResponseEntity<String> deleteStudent(@PathVariable long id){
    if (id == 0 || id < 0){
      log.warn("Enter Valid id for delete student");
      return null;
    }
    else{
      log.info("deleting the Student, Id:" + id);
      studentService.deleteStudent(id);
      return new ResponseEntity<>("Delete Student Successfully!" , HttpStatus.OK);
    }

  }


}
