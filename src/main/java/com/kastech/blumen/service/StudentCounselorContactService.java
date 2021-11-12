package com.kastech.blumen.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kastech.blumen.model.StudentCouncellorContact;

@Service
public class StudentCounselorContactService {

	@Autowired

	public List<StudentCouncellorContact> getCouncellorContactList() {
		List<StudentCouncellorContact> studentCouncellorContacts = new ArrayList<>();
		StudentCouncellorContact councellor1 = new StudentCouncellorContact(1, "Alex", "Smith", "(832)654-6546",
				"09/06/2017", "JACKSON", "180", "");
		StudentCouncellorContact councellor2 = new StudentCouncellorContact(1, "Criage", "Adam", "(832)654-6546",
				"09/06/2017", "JACKSON", "190", "");
		StudentCouncellorContact councellor3 = new StudentCouncellorContact(1, "Edge", "Adekunle-moses",
				"(832)654-6546", "09/06/2017", "JACKSON", "200", "");
		StudentCouncellorContact councellor4 = new StudentCouncellorContact(1, "Ben", "Alpher", "(832)654-6546",
				"09/06/2017", "JACKSON", "210", "");

		studentCouncellorContacts.add(councellor1);
		studentCouncellorContacts.add(councellor2);
		studentCouncellorContacts.add(councellor3);
		studentCouncellorContacts.add(councellor4);

		return studentCouncellorContacts;
	}

	public List<StudentCouncellorContact> getCouncellorContactsByNormalFilter(String fiscalYear, String active,
			String served, String reported, String counselor, String status, String ethnicity, String standing,
			String school, String eligibility, String gender) {
		// TODO Place repository code
		StudentCouncellorContact councellor = new StudentCouncellorContact(1, "Alex", "Smith", "(832)654-6546",
				"09/06/2017", "JACKSON", "180", "");
		List<StudentCouncellorContact> studentCouncellorContacts = new ArrayList<>();
		studentCouncellorContacts.add(councellor);

		return studentCouncellorContacts;
	}

	public List<StudentCouncellorContact> getCouncellorContactsByAdvanceFilter(String contactDateFrom,
			String contactDateTo, String reContactedDateFrom, String reContactedDateTo, String councellorContact,
			String contactType, String reContacted) {
		// TODO Place repository code
		StudentCouncellorContact councellor = new StudentCouncellorContact(1, "Criage", "Adam", "(832)654-6546",
				"09/06/2017", "JACKSON", "190", "");
		List<StudentCouncellorContact> studentCouncellorContacts = new ArrayList<>();
		studentCouncellorContacts.add(councellor);

		return studentCouncellorContacts;
	}

	public List<StudentCouncellorContact> getCouncellorContactsByMoreFilter(String collegeReady, String advisor,
			String codes, String tutor, String entryDateFrom, String entrySchool, String collegeType,
			String collegeName, String entryDateTo, String gpaEntry, String gpaStart, String gpaEnd) {
		// TODO Place repository code
		StudentCouncellorContact councellor = new StudentCouncellorContact(1, "Criage", "Adam", "(832)654-6546",
				"09/06/2017", "JACKSON", "190", "");
		List<StudentCouncellorContact> studentCouncellorContacts = new ArrayList<>();
		studentCouncellorContacts.add(councellor);

		return studentCouncellorContacts;
	}

	public List<StudentCouncellorContact> getCouncellorContactsByMoreAdvanceFilter(String zipCode, String major,
			String siteLocation, String incomeSource, String entryCollege, String cohortYear) {
		// TODO Place repository code
		StudentCouncellorContact councellor = new StudentCouncellorContact(1, "Edge", "Adekunle-moses", "(832)654-6546",
				"09/06/2017", "JACKSON", "200", "");
		List<StudentCouncellorContact> studentCouncellorContacts = new ArrayList<>();
		studentCouncellorContacts.add(councellor);

		return studentCouncellorContacts;
	}

	public String deleteCouncellorContact(String councellorContactId) {
		// TODO Place repository code
		return "Deleted";
	}

}
