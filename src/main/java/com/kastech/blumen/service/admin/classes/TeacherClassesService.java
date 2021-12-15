package com.kastech.blumen.service.admin.classes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kastech.blumen.model.admin.TeacherClasses;
import com.kastech.blumen.model.admin.TeacherClasses;
import com.kastech.blumen.repository.teacher.TeacherClassRepository;

@Service
public class TeacherClassesService {

	@Autowired
	TeacherClassRepository teacherClassRepository;

	public List<TeacherClasses> getTeacherClassesList() {
		return teacherClassRepository.findAll();
	}

	public List<TeacherClasses> getTeacherClassessByNormalFilter(String fiscalYear, String active, String served,
			String reported, String counselor, String status, String ethnicity, String standing, String school,
			String eligibility, String gender) {
		return teacherClassRepository.findAll();
	}

	public List<TeacherClasses> getTeacherClassessByAdvanceFilter(String contactDateFrom, String contactDateTo,
			String reContactedDateFrom, String reContactedDateTo, String councellorContact, String contactType,
			String reContacted) {
		return teacherClassRepository.findAll();
	}

	public List<TeacherClasses> getTeacherClassessByMoreFilter(String collegeReady, String advisor, String codes,
			String tutor, String entryDateFrom, String entrySchool, String collegeType, String collegeName,
			String entryDateTo, String gpaEntry, String gpaStart, String gpaEnd) {
		return teacherClassRepository.findAll();
	}

	public List<TeacherClasses> getTeacherClassessByMoreAdvanceFilter(String zipCode, String major, String siteLocation,
			String incomeSource, String entryCollege, String cohortYear) {
		return teacherClassRepository.findAll();
	}

	public void deleteTeacherClasses(Long TeacherClassesId) {
		teacherClassRepository.deleteById(TeacherClassesId);
	}

}
