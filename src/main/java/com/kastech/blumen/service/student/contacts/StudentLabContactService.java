package com.kastech.blumen.service.student.contacts;

import java.util.ArrayList;
import java.util.List;

import com.kastech.blumen.model.student.Student;
import org.springframework.stereotype.Service;

import com.kastech.blumen.model.student.contacts.StudentLabContact;

@Service
public class StudentLabContactService {

	public List<StudentLabContact> getLabContactList() {
		StudentLabContact studentLabCont1 = null;/*new StudentLabContact(1, "Alex", "Smith", "11-11-2021", "11-11-2021",
				"11-11-2021", "Practise");*/
		StudentLabContact studentLabCont2 = null;/*new StudentLabContact(2, "Mathew", "James", "11-11-2021", "11-11-2021",
				"11-11-2021", "Practise");*/
		StudentLabContact studentLabCont3 = null;/*new StudentLabContact(3, "Juan", "Borris", "11-11-2021", "11-11-2021",
				"11-11-2021", "Practise");*/
		StudentLabContact studentLabCont4 = null;/*new StudentLabContact(4, "Alex", "Logan", "11-11-2021", "11-11-2021",
				"11-11-2021", "Practise");*/
		List<StudentLabContact> studentLabContacts = new ArrayList<>();
		studentLabContacts.add(studentLabCont1);
		studentLabContacts.add(studentLabCont2);
		studentLabContacts.add(studentLabCont3);
		studentLabContacts.add(studentLabCont4);

		return studentLabContacts;
	}

	public List<StudentLabContact> getLabContactsByNormalFilter(String checkInFrom, String checkInTo, String fiscalYear,
			String active, String served, String reported, String counselor, String status, String ethnicity,
			String standing, String school, String eligibility, String gender) {
		// TODO Place repository code
		StudentLabContact studentLabCont1 = null;/*new StudentLabContact(1, "Alex", "Smith", "11-11-2021", "11-11-2021",
				"11-11-2021", "Practise");*/
		List<StudentLabContact> studentLabContacts = new ArrayList<>();
		studentLabContacts.add(studentLabCont1);

		return studentLabContacts;
	}

	public List<StudentLabContact> getLabContactsByAdvanceFilter(String collegeReady, String advisor, String codes,
			String tutor, String entryDateFrom, String entrySchool, String collegeType, String collegeName,
			String entryDateTo, String gpaEntry, String gpaStart, String gpaEnd) {
		// TODO Place repository code
		StudentLabContact studentLabCont = null;/*new StudentLabContact(2, "Mathew", "James", "11-11-2021", "11-11-2021",
				"11-11-2021", "Practise");*/
		List<StudentLabContact> studentLabContacts = new ArrayList<>();
		studentLabContacts.add(studentLabCont);

		return studentLabContacts;
	}

	public List<StudentLabContact> getLabContactsByMoreFilter(String zipCode, String major, String siteLocation,
			String incomeSource, String entryCollege, String cohortYear) {
		// TODO Place repository code
		StudentLabContact studentLabCont = null; /*new StudentLabContact(3, "Juan", "Borris", "11-11-2021", "11-11-2021",
				"11-11-2021", "Practise");*/
		List<StudentLabContact> studentLabContacts = new ArrayList<>();
		studentLabContacts.add(studentLabCont);

		return studentLabContacts;

	}

	public String deleteLabContact(String labContactId) {
		// TODO Place repository code
		return "Deleted";
	}

}
