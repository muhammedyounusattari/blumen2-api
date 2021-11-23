package com.kastech.blumen.service.admin.classes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kastech.blumen.model.admin.TutorClasses;



@Service
public class TutorClassesService {

	@Autowired

	public List<TutorClasses> getTutorClassesList() {
		List<TutorClasses> studentTutorClassess = new ArrayList<>();
		studentTutorClassess.add(getTutorClasses());

		return studentTutorClassess;
	}

	public List<TutorClasses> getTutorClassessByNormalFilter(String fiscalYear, String active,
																			String served, String reported, String counselor, String status, String ethnicity, String standing,
																			String school, String eligibility, String gender) {
		// TODO Place repository code
		List<TutorClasses> studentTutorClassess = new ArrayList<>();
		studentTutorClassess.add(getTutorClasses());

		return studentTutorClassess;
	}

	public List<TutorClasses> getTutorClassessByAdvanceFilter(String contactDateFrom,
																			 String contactDateTo, String reContactedDateFrom, String reContactedDateTo, String councellorContact,
																			 String contactType, String reContacted) {
		// TODO Place repository code
		List<TutorClasses> studentTutorClassess = new ArrayList<>();
		studentTutorClassess.add(getTutorClasses());

		return studentTutorClassess;
	}

	public List<TutorClasses> getTutorClassessByMoreFilter(String collegeReady, String advisor,
																		  String codes, String tutor, String entryDateFrom, String entrySchool, String collegeType,
																		  String collegeName, String entryDateTo, String gpaEntry, String gpaStart, String gpaEnd) {
		// TODO Place repository code
		List<TutorClasses> studentTutorClassess = new ArrayList<>();
		studentTutorClassess.add(getTutorClasses());

		return studentTutorClassess;
	}

	public List<TutorClasses> getTutorClassessByMoreAdvanceFilter(String zipCode, String major,
																				 String siteLocation, String incomeSource, String entryCollege, String cohortYear) {
		// TODO Place repository code
		List<TutorClasses> studentTutorClassess = new ArrayList<>();
		studentTutorClassess.add(getTutorClasses());

		return studentTutorClassess;
	}

	public String deleteTutorClasses(String TutorClassesId) {
		// TODO Place repository code
		return "Deleted";
	}
	
	private TutorClasses getTutorClasses() {
		return new TutorClasses(1, "2020", "Fall", "ANDERSON", "Algebra", "1", "5:20", "3", "ROOM1", "2", "30min", "22", "Test notes");		
	}

}
