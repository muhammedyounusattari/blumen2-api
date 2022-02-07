package com.kastech.blumen.service.admin.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.kastech.blumen.model.admin.TeacherClasses;
import com.kastech.blumen.model.admin.TutorClasses;
import com.kastech.blumen.model.student.Student;
import com.kastech.blumen.repository.student.StudentRepository;
import com.kastech.blumen.repository.tutor.TutorClassRepository;

@Service
public class TutorClassesService {

	@Autowired
	TutorClassRepository tutorClassRepository;

	@Autowired
	StudentRepository studentRepository;
	
	public List<TutorClasses> getTutorClassesList() {
		return tutorClassRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}

	public List<TutorClasses> getTutorClassessByNormalFilter(String fiscalYear, String active, String served,
			String reported, String counselor, String status, String ethnicity, String standing, String school,
			String eligibility, String gender) {
		return tutorClassRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}

	public List<TutorClasses> getTutorClassessByAdvanceFilter(String contactDateFrom, String contactDateTo,
			String reContactedDateFrom, String reContactedDateTo, String councellorContact, String contactType,
			String reContacted) {
		return tutorClassRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}

	public List<TutorClasses> getTutorClassessByMoreFilter(String collegeReady, String advisor, String codes,
			String tutor, String entryDateFrom, String entrySchool, String collegeType, String collegeName,
			String entryDateTo, String gpaEntry, String gpaStart, String gpaEnd) {
		return tutorClassRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}

	public List<TutorClasses> getTutorClassessByMoreAdvanceFilter(String zipCode, String major, String siteLocation,
			String incomeSource, String entryCollege, String cohortYear) {
		return tutorClassRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}

	public void deleteTutorClasses(Long TutorClassesId) {
		tutorClassRepository.deleteById(TutorClassesId);
	}

	public TutorClasses findById(Long id) {
		return tutorClassRepository.findById(id).get();
	}
	
	public List<Student> getStudents(Long id) {
		List<Student> students = new ArrayList<Student>();
		Optional<TutorClasses> optTeacherClass= tutorClassRepository.findById(id);
		if(optTeacherClass.isPresent()) {
			students = optTeacherClass.get().getStudentList();
		}
		return students;
	}
	
	public void assignStudents(Long classId, Set<Long> studentIds) {
		Optional<TutorClasses> optClass = tutorClassRepository.findById(classId);
		if (optClass.isPresent()) {
			TutorClasses classObj = optClass.get();
			List<Student> students = studentRepository.findAllById(studentIds);
			students.forEach(st -> {
				classObj.assignStudent(st);
			});
			tutorClassRepository.save(classObj);
			//studentRepository.saveAll(students);
		}
	}
	
	public TutorClasses save(TutorClasses classes) {
		return tutorClassRepository.save(classes);
	}
	
	public void saveAll(List<TutorClasses> classes) {
		tutorClassRepository.saveAll(classes);
	}
}
