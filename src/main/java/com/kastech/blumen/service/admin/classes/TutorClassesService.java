package com.kastech.blumen.service.admin.classes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.kastech.blumen.model.admin.TutorClasses;
import com.kastech.blumen.repository.tutor.TutorClassRepository;

@Service
public class TutorClassesService {

	@Autowired
	TutorClassRepository tutorClassRepository;

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

}
