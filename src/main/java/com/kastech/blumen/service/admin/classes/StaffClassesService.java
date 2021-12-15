package com.kastech.blumen.service.admin.classes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kastech.blumen.model.admin.StaffClasses;
import com.kastech.blumen.repository.admin.StaffClassRepository;

@Service
public class StaffClassesService {

	@Autowired
	private StaffClassRepository staffClassRepository;

	public List<StaffClasses> getStaffClassesList() {
		return staffClassRepository.findAll();
	}

	public List<StaffClasses> getStaffClassesByNormalFilter(String fiscalYear, String active, String served,
			String reported, String counselor, String status, String ethnicity, String standing, String school,
			String eligibility, String gender) {

		return staffClassRepository.findAll();

	}

	public List<StaffClasses> getStaffClassesByAdvanceFilter(String contactDateFrom, String contactDateTo,
			String reContactedDateFrom, String reContactedDateTo, String councellorContact, String contactType,
			String reContacted) {

		return staffClassRepository.findAll();
	}

	public List<StaffClasses> getStaffClassesByMoreFilter(String collegeReady, String advisor, String codes,
			String tutor, String entryDateFrom, String entrySchool, String collegeType, String collegeName,
			String entryDateTo, String gpaEntry, String gpaStart, String gpaEnd) {
		return staffClassRepository.findAll();
	}

	public List<StaffClasses> getStaffClassesByMoreAdvanceFilter(String zipCode, String major, String siteLocation,
			String incomeSource, String entryCollege, String cohortYear) {
		return staffClassRepository.findAll();
	}

}
