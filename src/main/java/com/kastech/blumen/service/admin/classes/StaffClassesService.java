package com.kastech.blumen.service.admin.classes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kastech.blumen.model.admin.CounselorClasses;
import com.kastech.blumen.model.admin.StaffClasses;



@Service
public class StaffClassesService {

	@Autowired

	public List<StaffClasses> getStaffClassesList() {
		List<StaffClasses> studentStaffClasses = new ArrayList<>();
		studentStaffClasses.add(getStaffClasses());

		return studentStaffClasses;
	}

	public List<StaffClasses> getStaffClassesByNormalFilter(String fiscalYear, String active,
																			String served, String reported, String counselor, String status, String ethnicity, String standing,
																			String school, String eligibility, String gender) {
		// TODO Place repository code
		List<StaffClasses> studentStaffClasses = new ArrayList<>();
		studentStaffClasses.add(getStaffClasses());

		return studentStaffClasses;
	}

	public List<StaffClasses> getStaffClassesByAdvanceFilter(String contactDateFrom,
																			 String contactDateTo, String reContactedDateFrom, String reContactedDateTo, String councellorContact,
																			 String contactType, String reContacted) {
		// TODO Place repository code
		List<StaffClasses> studentStaffClasses = new ArrayList<>();
		studentStaffClasses.add(getStaffClasses());

		return studentStaffClasses;
	}

	public List<StaffClasses> getStaffClassesByMoreFilter(String collegeReady, String advisor,
																		  String codes, String tutor, String entryDateFrom, String entrySchool, String collegeType,
																		  String collegeName, String entryDateTo, String gpaEntry, String gpaStart, String gpaEnd) {
		// TODO Place repository code
		
		List<StaffClasses> studentStaffClasses = new ArrayList<>();
		studentStaffClasses.add(getStaffClasses());

		return studentStaffClasses;
	}

	public List<StaffClasses> getStaffClassesByMoreAdvanceFilter(String zipCode, String major,
																				 String siteLocation, String incomeSource, String entryCollege, String cohortYear) {
		// TODO Place repository code
	
		List<StaffClasses> studentStaffClasses = new ArrayList<>();
		studentStaffClasses.add(getStaffClasses());

		return studentStaffClasses;
	}

	private StaffClasses getStaffClasses() {
		return new StaffClasses(1, "2020", "Fall", "ANDERSON", "Algebra", "1", "5:20", "3", "ROOM1", "2", "30min",
				"22", "Test notes");
	}

}
