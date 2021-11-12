package com.kastech.blumen.service.student.contacts;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kastech.blumen.model.student.contacts.StudentCounselorContact;

@Service
public class StudentCounselorContactService {

	@Autowired

	public List<StudentCounselorContact> getCounselorContactList() {
		List<StudentCounselorContact> studentCounselorContacts = new ArrayList<>();
		StudentCounselorContact counselor1 = new StudentCounselorContact(1, "Alex", "Smith", "(832)654-6546",
				"09/06/2017", "JACKSON", "180", "");
		StudentCounselorContact counselor2 = new StudentCounselorContact(1, "Criage", "Adam", "(832)654-6546",
				"09/06/2017", "JACKSON", "190", "");
		StudentCounselorContact counselor3 = new StudentCounselorContact(1, "Edge", "Adekunle-moses",
				"(832)654-6546", "09/06/2017", "JACKSON", "200", "");
		StudentCounselorContact counselor4 = new StudentCounselorContact(1, "Ben", "Alpher", "(832)654-6546",
				"09/06/2017", "JACKSON", "210", "");

		studentCounselorContacts.add(counselor1);
		studentCounselorContacts.add(counselor2);
		studentCounselorContacts.add(counselor3);
		studentCounselorContacts.add(counselor4);

		return studentCounselorContacts;
	}

	public List<StudentCounselorContact> getCounselorContactsByNormalFilter(String fiscalYear, String active,
																			String served, String reported, String counselor, String status, String ethnicity, String standing,
																			String school, String eligibility, String gender) {
		// TODO Place repository code
		StudentCounselorContact Counselor = new StudentCounselorContact(1, "Alex", "Smith", "(832)654-6546",
				"09/06/2017", "JACKSON", "180", "");
		List<StudentCounselorContact> studentCounselorContacts = new ArrayList<>();
		studentCounselorContacts.add(Counselor);

		return studentCounselorContacts;
	}

	public List<StudentCounselorContact> getCounselorContactsByAdvanceFilter(String contactDateFrom,
																			 String contactDateTo, String reContactedDateFrom, String reContactedDateTo, String councellorContact,
																			 String contactType, String reContacted) {
		// TODO Place repository code
		StudentCounselorContact Counselor = new StudentCounselorContact(1, "Criage", "Adam", "(832)654-6546",
				"09/06/2017", "JACKSON", "190", "");
		List<StudentCounselorContact> studentCounselorContacts = new ArrayList<>();
		studentCounselorContacts.add(Counselor);

		return studentCounselorContacts;
	}

	public List<StudentCounselorContact> getCounselorContactsByMoreFilter(String collegeReady, String advisor,
																		  String codes, String tutor, String entryDateFrom, String entrySchool, String collegeType,
																		  String collegeName, String entryDateTo, String gpaEntry, String gpaStart, String gpaEnd) {
		// TODO Place repository code
		StudentCounselorContact counselor = new StudentCounselorContact(1, "Criage", "Adam", "(832)654-6546",
				"09/06/2017", "JACKSON", "190", "");
		List<StudentCounselorContact> studentCounselorContacts = new ArrayList<>();
		studentCounselorContacts.add(counselor);

		return studentCounselorContacts;
	}

	public List<StudentCounselorContact> getCounselorContactsByMoreAdvanceFilter(String zipCode, String major,
																				 String siteLocation, String incomeSource, String entryCollege, String cohortYear) {
		// TODO Place repository code
		StudentCounselorContact counselor = new StudentCounselorContact(1, "Edge", "Adekunle-moses", "(832)654-6546",
				"09/06/2017", "JACKSON", "200", "");
		List<StudentCounselorContact> studentCounselorContacts = new ArrayList<>();
		studentCounselorContacts.add(counselor);

		return studentCounselorContacts;
	}

	public String deleteCounselorContact(String counselorContactId) {
		// TODO Place repository code
		return "Deleted";
	}

}
