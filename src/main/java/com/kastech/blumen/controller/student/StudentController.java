package com.kastech.blumen.controller.student;

import com.kastech.blumen.model.Response;
import com.kastech.blumen.model.student.Student;
import com.kastech.blumen.repository.student.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/blumen-api/student")
public class StudentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentRepository studentRepository;

    @ResponseBody
    @GetMapping(path = "/getStudents/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<Student> getStudents() {
        List<Student> list = new ArrayList<>();
        Iterable<Student> items = studentRepository.findAll(Sort.by(Sort.Direction.ASC, "ssno"));
        items.forEach(list::add);
        return list;
    }

    @ResponseBody
    @PostMapping(path = "/addStudents/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
    public Student addStudents(@RequestBody Student student) {
        return studentRepository.save(student);
    }
    
    @ResponseBody
    @PutMapping(path = "/student/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
    public Student updateStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @ResponseBody
    @DeleteMapping(path = "/deleteStudents/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<String> deleteStudents(@RequestBody Student student) {
         studentRepository.delete(student);
         return new ResponseEntity(new Response(200, "success"), null, HttpStatus.OK);
    }


    // Below apis for admin--systemtools--DeleteStudents module

    /**
     * To get the list of deleted students
     * @return
     */
    @ResponseBody
    @GetMapping(path = "/getDeleteStudentList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<Student>> getDeleteStudentList() {
        // addStudentProfile();
        return ResponseEntity.ok(studentRepository.getAllDeletedStudent());
    }

    /**
     * To get all deleted students by fiscal year
     * @param fiscalYear
     * @return
     */
    @ResponseBody
    @GetMapping(path = "/getAllStudentsByFiscalYearForDeletedStudentList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<Student>> getAllStudentsByFiscalYearForDeletedStudentList(@RequestParam("fiscalYear") String fiscalYear) {
        List<Student> studentList = studentRepository.findAllStudentbyFiscalYear(fiscalYear);

        return ResponseEntity.ok(studentList);
    }

    /**
     * To delete the list of student ssno
     * @param studentSsno
     * @return
     */
    @ResponseBody
    @DeleteMapping(path = "/deleteListOfStudentSsno/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> deleteListOfStudentSsno(@RequestBody List<String> studentSsno) {
        ResponseEntity<String> responseEntity = null;
        List<Student> studentList = new ArrayList<>();
        if (null != studentSsno) {

            if (!studentSsno.isEmpty()) {

                for (String ssno : studentSsno) {
                    try {
                        Optional<Student> student = studentRepository.findById(Long.parseLong(ssno));
                        if(null!=student.get()) {
                            Student studentObj = student.get();
                            studentObj.setDeletedStudent(true);
                            studentList.add(studentObj);
                            //  deleteStudentsRepository.save(student.get());
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }

                studentRepository.saveAll(studentList);

                responseEntity = new ResponseEntity(new Response(200, studentSsno.size() + " no of student deleted "), null, HttpStatus.OK);
            } else {
                responseEntity = new ResponseEntity(new Response(200, studentSsno.size() + " student list is empty"), null, HttpStatus.OK);

            }
        }

        return responseEntity;
    }

// Below apis for admin--systemtools--RecallStudents module


    /**
     * To get the RecallStudent list
     * @return
     */
    @ResponseBody
    @GetMapping(path = "/getRecallStudentList/v1", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Student>> getRecallStudentList() {
        return ResponseEntity.status(HttpStatus.OK).body(studentRepository.getAllDeletedStudent());
    }

    /**
     * To recall the list of student ssno back to studnet model
     * @param studentSsno
     * @return
     */
    @ResponseBody
    @DeleteMapping(path = "/recallSelectedStudent/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> recallSelectedStudent(@RequestBody List<String> studentSsno) {

        List<Student> studentList = new ArrayList<>();
        ResponseEntity<String> responseEntity = null;
        if (null != studentSsno) {

            if (!studentSsno.isEmpty()) {

                for (String ssno : studentSsno) {
                    try {
                        Student student = studentRepository.getDeletedStudentBySsno(Long.parseLong(ssno));
                        if (null != student) {

                            Student studentObj = student;
                            studentObj.setDeletedStudent(false);
                            studentList.add(studentObj);

                           /* studentList.add(student.get());
                            deleteStudentsRepository.deleteById(Long.parseLong(ssno));
                            studentRepository.save(student.get());*/
                        } else {
                            LOGGER.info("dint find the student with ssno " + ssno);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                studentRepository.saveAll(studentList);

                responseEntity = new ResponseEntity(studentList, null, HttpStatus.OK);
            } else {
                responseEntity = new ResponseEntity("empty student ssno list", null, HttpStatus.OK);

            }
        }

        return responseEntity;
    }
}
