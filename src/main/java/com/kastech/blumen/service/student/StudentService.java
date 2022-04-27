package com.kastech.blumen.service.student;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.kastech.blumen.model.Response;
import com.kastech.blumen.model.student.StudentDataObject;
import com.kastech.blumen.model.student.StudentYearlyData;
import com.kastech.blumen.repository.student.StudentYearlyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.kastech.blumen.model.admin.CounselorClasses;
import com.kastech.blumen.model.admin.StaffClasses;
import com.kastech.blumen.model.admin.TeacherClasses;
import com.kastech.blumen.model.admin.TutorClasses;
import com.kastech.blumen.model.student.Student;
import com.kastech.blumen.repository.admin.StaffClassRepository;
import com.kastech.blumen.repository.counselor.CounselorClassRepository;
import com.kastech.blumen.repository.student.StudentRepository;
import com.kastech.blumen.repository.teacher.TeacherClassRepository;
import com.kastech.blumen.repository.tutor.TutorClassRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	/*@Autowired
	private StudentYearlyRepository studentYearlyRepository;
	
	@Autowired
	private TeacherClassRepository teacherClassRepository;
	
	@Autowired
	private TutorClassRepository tutorClassRepository;
	
	@Autowired
	private StaffClassRepository staffClassRepository;
	
	@Autowired
	private CounselorClassRepository counselorClassRepository;*/
	
	public void assignTeacherClasses(Long studentId, Set<Long> teacherClassesIds) {
		Optional<Student> student = studentRepository.findById(studentId);
		/*if (student.isPresent()) {
			Student studentObj = student.get();
			List<TeacherClasses> teacherClasses = teacherClassRepository.findAllById(teacherClassesIds);
			teacherClasses.forEach(tc -> {
				studentObj.assignTeacherClasses(tc);
			});
			//teacherClassRepository.saveAll(teacherClasses);
			studentRepository.save(studentObj);
		}*/
	}
	
	public void assignTutorClasses(Long studentId, Set<Long> tutorClassesIds) {
		/*Optional<Student> student = studentRepository.findById(studentId);
		if (student.isPresent()) {
			Student studentObj = student.get();
			List<TutorClasses> tutorClasses = tutorClassRepository.findAllById(tutorClassesIds);
			tutorClasses.forEach(tc -> {
				studentObj.assignTutorClasses(tc);
			});
			//teacherClassRepository.saveAll(teacherClasses);
			studentRepository.save(studentObj);
		}*/
	}
	
	public void assignStaffClasses(Long studentId, Set<Long> StaffClassesIds) {
		/*Optional<Student> student = studentRepository.findById(studentId);
		if (student.isPresent()) {
			Student studentObj = student.get();
			List<StaffClasses> StaffClasses = staffClassRepository.findAllById(StaffClassesIds);
			StaffClasses.forEach(tc -> {
				studentObj.assignStaffClasses(tc);
			});
			//teacherClassRepository.saveAll(teacherClasses);
			studentRepository.save(studentObj);
		}*/
	}
	
	public void assignCounselorClasses(Long studentId, Set<Long> CounselorClassesIds) {
		/*Optional<Student> student = studentRepository.findById(studentId);
		if (student.isPresent()) {
			Student studentObj = student.get();
			List<CounselorClasses> CounselorClasses = counselorClassRepository.findAllById(CounselorClassesIds);
			CounselorClasses.forEach(tc -> {
				studentObj.assignCounselorClasses(tc);
			});
			//teacherClassRepository.saveAll(teacherClasses);
			studentRepository.save(studentObj);
		}*/
	}

	public StudentDataObject saveStudent(StudentDataObject studentData)
	{
		try
		{
			Student student = studentData.getStudent();
//			StudentYearlyData studentYearlyData = studentData.getStudentYearlyData();
//
//			student = studentRepository.save(student);
//			studentYearlyData.setStuid(student.getStuid());
//			studentYearlyData = studentYearlyRepository.save(studentYearlyData);
//
//			studentData.setStudent(student);
//			studentData.setStudentYearlyData(studentYearlyData);
			return studentData;
		}
		catch(Exception ex) {
			throw ex;
		}
	}

	public  boolean DeleteStudent(Long StudentId)
	{
		boolean returnValue = false;
		try
		{

		}
		catch (Exception ex)
		{

		}
		return returnValue;
	}
	
}
