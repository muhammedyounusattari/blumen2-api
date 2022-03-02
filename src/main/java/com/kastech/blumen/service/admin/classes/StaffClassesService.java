package com.kastech.blumen.service.admin.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.kastech.blumen.model.admin.CounselorClasses;
import com.kastech.blumen.model.admin.StaffClasses;
import com.kastech.blumen.model.admin.TutorClasses;
import com.kastech.blumen.model.student.Student;
import com.kastech.blumen.repository.admin.StaffClassRepository;
import com.kastech.blumen.repository.student.StudentRepository;

@Service
public class StaffClassesService {

	@Autowired
	private StaffClassRepository staffClassRepository;
	
	/*@Autowired
	StudentRepository studentRepository;*/

	public List<StaffClasses> getStaffClassesList() {
		return staffClassRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}

	public List<StaffClasses> getStaffClassesByNormalFilter(String fiscalYear, String active, String served,
			String reported, String counselor, String status, String ethnicity, String standing, String school,
			String eligibility, String gender) {

		return staffClassRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));

	}

	public List<StaffClasses> getStaffClassesByAdvanceFilter(String contactDateFrom, String contactDateTo,
			String reContactedDateFrom, String reContactedDateTo, String councellorContact, String contactType,
			String reContacted) {

		return staffClassRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}

	public List<StaffClasses> getStaffClassesByMoreFilter(String collegeReady, String advisor, String codes,
			String tutor, String entryDateFrom, String entrySchool, String collegeType, String collegeName,
			String entryDateTo, String gpaEntry, String gpaStart, String gpaEnd) {
		return staffClassRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}

	public List<StaffClasses> getStaffClassesByMoreAdvanceFilter(String zipCode, String major, String siteLocation,
			String incomeSource, String entryCollege, String cohortYear) {
		return staffClassRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}

	public StaffClasses findById(Long id) {
		return staffClassRepository.findById(id).get();
	}
	
	public List<Student> getStudents(Long id) {
		List<Student> students = new ArrayList<Student>();
		/*Optional<StaffClasses> optTeacherClass= staffClassRepository.findById(id);
		if(optTeacherClass.isPresent()) {
			students = optTeacherClass.get().getStudentList();
		}*/
		return students;
	}
	
	public void assignStudents(Long classId, Set<Long> studentIds) {
		Optional<StaffClasses> optClass = staffClassRepository.findById(classId);
		/*if (optClass.isPresent()) {
			StaffClasses classObj = optClass.get();
			List<Student> students = studentRepository.findAllById(studentIds);
			students.forEach(st -> {
				classObj.assignStudent(st);
			});
			staffClassRepository.save(classObj);
			//studentRepository.saveAll(students);
		}*/
	}
	
	public StaffClasses save(StaffClasses classes) {
		return staffClassRepository.save(classes);
	}
	
	public void saveAll(List<StaffClasses> classes) {
		staffClassRepository.saveAll(classes);
	}

}
