package com.kastech.blumen.service.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kastech.blumen.model.admin.TeacherContact;



@Service
public class TeacherContactsService {

	@Autowired

	public List<TeacherContact> getTeacherContactList() {
		List<TeacherContact> studentTeacherContacts = new ArrayList<>();
		TeacherContact counselor1 = new TeacherContact(1, "Alex", "Smith", "(832)654-6546",
				"09/06/2017", "JACKSON", "180", "");
		TeacherContact counselor2 = new TeacherContact(1, "Criage", "Adam", "(832)654-6546",
				"09/06/2017", "JACKSON", "190", "");
		TeacherContact counselor3 = new TeacherContact(1, "Edge", "Adekunle-moses",
				"(832)654-6546", "09/06/2017", "JACKSON", "200", "");
		TeacherContact counselor4 = new TeacherContact(1, "Ben", "Alpher", "(832)654-6546",
				"09/06/2017", "JACKSON", "210", "");

		studentTeacherContacts.add(counselor1);
		studentTeacherContacts.add(counselor2);
		studentTeacherContacts.add(counselor3);
		studentTeacherContacts.add(counselor4);

		return studentTeacherContacts;
	}

	public List<TeacherContact> getTeacherContactsByNormalFilter(String fiscalYear, String active,
																			String served, String reported, String counselor, String status, String ethnicity, String standing,
																			String school, String eligibility, String gender) {
		// TODO Place repository code
		TeacherContact teacher = new TeacherContact(1, "Alex", "Smith", "(832)654-6546",
				"09/06/2017", "JACKSON", "180", "");
		List<TeacherContact> studentTeacherContacts = new ArrayList<>();
		studentTeacherContacts.add(teacher);

		return studentTeacherContacts;
	}

	public List<TeacherContact> getTeacherContactsByAdvanceFilter(String contactDateFrom,
																			 String contactDateTo, String reContactedDateFrom, String reContactedDateTo, String councellorContact,
																			 String contactType, String reContacted) {
		// TODO Place repository code
		TeacherContact teacher = new TeacherContact(1, "Criage", "Adam", "(832)654-6546",
				"09/06/2017", "JACKSON", "190", "");
		List<TeacherContact> studentTeacherContacts = new ArrayList<>();
		studentTeacherContacts.add(teacher);

		return studentTeacherContacts;
	}

	public List<TeacherContact> getTeacherContactsByMoreFilter(String collegeReady, String advisor,
																		  String codes, String tutor, String entryDateFrom, String entrySchool, String collegeType,
																		  String collegeName, String entryDateTo, String gpaEntry, String gpaStart, String gpaEnd) {
		// TODO Place repository code
		TeacherContact teacher = new TeacherContact(1, "Criage", "Adam", "(832)654-6546",
				"09/06/2017", "JACKSON", "190", "");
		List<TeacherContact> studentTeacherContacts = new ArrayList<>();
		studentTeacherContacts.add(teacher);

		return studentTeacherContacts;
	}

	public List<TeacherContact> getTeacherContactsByMoreAdvanceFilter(String zipCode, String major,
																				 String siteLocation, String incomeSource, String entryCollege, String cohortYear) {
		// TODO Place repository code
		TeacherContact teacher = new TeacherContact(1, "Edge", "Adekunle-moses", "(832)654-6546",
				"09/06/2017", "JACKSON", "200", "");
		List<TeacherContact> studentTeacherContacts = new ArrayList<>();
		studentTeacherContacts.add(teacher);

		return studentTeacherContacts;
	}

	public String deleteTeacherContact(String TeacherContactId) {
		// TODO Place repository code
		return "Deleted";
	}

}
