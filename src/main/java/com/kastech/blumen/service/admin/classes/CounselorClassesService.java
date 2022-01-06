package com.kastech.blumen.service.admin.classes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.kastech.blumen.model.admin.CounselorClasses;
import com.kastech.blumen.repository.counselor.CounselorClassRepository;

@Service
public class CounselorClassesService {

	@Autowired
	CounselorClassRepository counselorClassRepository;
	
	public List<CounselorClasses> getCounselorClassesList() {
		return counselorClassRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}

	public List<CounselorClasses> getCounselorClassesByNormalFilter(String fiscalYear, String active, String served,
			String reported, String counselor, String status, String ethnicity, String standing, String school,
			String eligibility, String gender) {
		return counselorClassRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}

	public List<CounselorClasses> getCounselorClassesByAdvanceFilter(String contactDateFrom, String contactDateTo,
			String reContactedDateFrom, String reContactedDateTo, String councellorContact, String contactType,
			String reContacted) {
		return counselorClassRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}

	public List<CounselorClasses> getCounselorClassesByMoreFilter(String collegeReady, String advisor, String codes,
			String tutor, String entryDateFrom, String entrySchool, String collegeType, String collegeName,
			String entryDateTo, String gpaEntry, String gpaStart, String gpaEnd) {
		return counselorClassRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}

	public List<CounselorClasses> getCounselorClassesByMoreAdvanceFilter(String zipCode, String major,
			String siteLocation, String incomeSource, String entryCollege, String cohortYear) {
		return counselorClassRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}

	public CounselorClasses saveData(CounselorClasses counselorClasses){
		return counselorClassRepository.save(counselorClasses);
	}

	public void deleteData(Long id){
		 counselorClassRepository.deleteById(id);
	}

}
