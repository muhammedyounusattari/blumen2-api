package com.kastech.blumen.service.admin.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.kastech.blumen.model.admin.TeacherClasses;
import com.kastech.blumen.model.student.Student;
import com.kastech.blumen.model.admin.TeacherClasses;
import com.kastech.blumen.repository.student.StudentRepository;
import com.kastech.blumen.repository.teacher.TeacherClassRepository;
import com.kastech.blumen.service.student.StudentService;

@Service
public class TeacherClassesService {

	@Autowired
	TeacherClassRepository teacherClassRepository;
	/*
	@Autowired
	StudentRepository studentRepository;*/

	public List<TeacherClasses> getTeacherClassesList() {
		return teacherClassRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}

	public List<TeacherClasses> getTeacherClassessByNormalFilter(String fiscalYear, String active, String served,
			String reported, String counselor, String status, String ethnicity, String standing, String school,
			String eligibility, String gender) {
		return teacherClassRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}

	public List<TeacherClasses> getTeacherClassessByAdvanceFilter(String contactDateFrom, String contactDateTo,
			String reContactedDateFrom, String reContactedDateTo, String councellorContact, String contactType,
			String reContacted) {
		return teacherClassRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}

	public List<TeacherClasses> getTeacherClassessByMoreFilter(String collegeReady, String advisor, String codes,
			String tutor, String entryDateFrom, String entrySchool, String collegeType, String collegeName,
			String entryDateTo, String gpaEntry, String gpaStart, String gpaEnd) {
		return teacherClassRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}

	public List<TeacherClasses> getTeacherClassessByMoreAdvanceFilter(String zipCode, String major, String siteLocation,
			String incomeSource, String entryCollege, String cohortYear) {
		return teacherClassRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}

	public void deleteTeacherClasses(Long TeacherClassesId) {
		teacherClassRepository.deleteById(TeacherClassesId);
	}

	public TeacherClasses findById(Long id) {
		return teacherClassRepository.findById(id).get();
	}
	
	public List<Student> getStudents(Long id) {
		List<Student> students = new ArrayList<Student>();
		/*Optional<TeacherClasses> optTeacherClass= teacherClassRepository.findById(id);
		if(optTeacherClass.isPresent()) {
			students = optTeacherClass.get().getStudentList();
		}*/
		return students;
	}

	public void assignStudents(Long classId, Set<Long> studentIds) {
		Optional<TeacherClasses> optClass = teacherClassRepository.findById(classId);
		/*if (optClass.isPresent()) {
			TeacherClasses classObj = optClass.get();
			List<Student> students = studentRepository.findAllById(studentIds);
			students.forEach(st -> {
				classObj.assignStudent(st);
			});
			teacherClassRepository.save(classObj);
			//studentRepository.saveAll(students);
		}*/
	}

	public TeacherClasses save(TeacherClasses classes) {
		return teacherClassRepository.save(classes);
	}
	
	public void saveAll(List<TeacherClasses> classes) {
		teacherClassRepository.saveAll(classes);
	}
}
