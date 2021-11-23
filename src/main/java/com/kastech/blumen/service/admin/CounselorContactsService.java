package com.kastech.blumen.service.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kastech.blumen.model.admin.CounselorContact;



@Service
public class CounselorContactsService {

	@Autowired

	public List<CounselorContact> getCounselorContactList() {
		List<CounselorContact> studentCounselorContacts = new ArrayList<>();
		CounselorContact counselor1 = new CounselorContact(1, "Alex", "Smith", "(832)654-6546",
				"09/06/2017", "JACKSON", "180", "");
		CounselorContact counselor2 = new CounselorContact(1, "Criage", "Adam", "(832)654-6546",
				"09/06/2017", "JACKSON", "190", "");
		CounselorContact counselor3 = new CounselorContact(1, "Edge", "Adekunle-moses",
				"(832)654-6546", "09/06/2017", "JACKSON", "200", "");
		CounselorContact counselor4 = new CounselorContact(1, "Ben", "Alpher", "(832)654-6546",
				"09/06/2017", "JACKSON", "210", "");

		studentCounselorContacts.add(counselor1);
		studentCounselorContacts.add(counselor2);
		studentCounselorContacts.add(counselor3);
		studentCounselorContacts.add(counselor4);

		return studentCounselorContacts;
	}

	public List<CounselorContact> getCounselorContactsByNormalFilter(String fiscalYear, String active,
																			String served, String reported, String counselor, String status, String ethnicity, String standing,
																			String school, String eligibility, String gender) {
		// TODO Place repository code
		CounselorContact Counselor = new CounselorContact(1, "Alex", "Smith", "(832)654-6546",
				"09/06/2017", "JACKSON", "180", "");
		List<CounselorContact> studentCounselorContacts = new ArrayList<>();
		studentCounselorContacts.add(Counselor);

		return studentCounselorContacts;
	}

	public List<CounselorContact> getCounselorContactsByAdvanceFilter(String contactDateFrom,
																			 String contactDateTo, String reContactedDateFrom, String reContactedDateTo, String councellorContact,
																			 String contactType, String reContacted) {
		// TODO Place repository code
		CounselorContact Counselor = new CounselorContact(1, "Criage", "Adam", "(832)654-6546",
				"09/06/2017", "JACKSON", "190", "");
		List<CounselorContact> studentCounselorContacts = new ArrayList<>();
		studentCounselorContacts.add(Counselor);

		return studentCounselorContacts;
	}

	public List<CounselorContact> getCounselorContactsByMoreFilter(String collegeReady, String advisor,
																		  String codes, String tutor, String entryDateFrom, String entrySchool, String collegeType,
																		  String collegeName, String entryDateTo, String gpaEntry, String gpaStart, String gpaEnd) {
		// TODO Place repository code
		CounselorContact counselor = new CounselorContact(1, "Criage", "Adam", "(832)654-6546",
				"09/06/2017", "JACKSON", "190", "");
		List<CounselorContact> studentCounselorContacts = new ArrayList<>();
		studentCounselorContacts.add(counselor);

		return studentCounselorContacts;
	}

	public List<CounselorContact> getCounselorContactsByMoreAdvanceFilter(String zipCode, String major,
																				 String siteLocation, String incomeSource, String entryCollege, String cohortYear) {
		// TODO Place repository code
		CounselorContact counselor = new CounselorContact(1, "Edge", "Adekunle-moses", "(832)654-6546",
				"09/06/2017", "JACKSON", "200", "");
		List<CounselorContact> studentCounselorContacts = new ArrayList<>();
		studentCounselorContacts.add(counselor);

		return studentCounselorContacts;
	}

	public String deleteCounselorContact(String counselorContactId) {
		// TODO Place repository code
		return "Deleted";
	}

}
