package com.kastech.blumen.service.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kastech.blumen.model.admin.StaffContact;



@Service
public class StaffContactsService {

	@Autowired

	public List<StaffContact> getStaffContactList() {
		List<StaffContact> studentStaffContacts = new ArrayList<>();
		StaffContact counselor1 = new StaffContact(1, "Alex", "Smith", "(832)654-6546",
				"09/06/2017", "JACKSON", "180", "");
		StaffContact counselor2 = new StaffContact(1, "Criage", "Adam", "(832)654-6546",
				"09/06/2017", "JACKSON", "190", "");
		StaffContact counselor3 = new StaffContact(1, "Edge", "Adekunle-moses",
				"(832)654-6546", "09/06/2017", "JACKSON", "200", "");
		StaffContact counselor4 = new StaffContact(1, "Ben", "Alpher", "(832)654-6546",
				"09/06/2017", "JACKSON", "210", "");

		studentStaffContacts.add(counselor1);
		studentStaffContacts.add(counselor2);
		studentStaffContacts.add(counselor3);
		studentStaffContacts.add(counselor4);

		return studentStaffContacts;
	}

	public List<StaffContact> getStaffContactsByNormalFilter(String fiscalYear, String active,
																			String served, String reported, String counselor, String status, String ethnicity, String standing,
																			String school, String eligibility, String gender) {
		// TODO Place repository code
		StaffContact staff = new StaffContact(1, "Alex", "Smith", "(832)654-6546",
				"09/06/2017", "JACKSON", "180", "");
		List<StaffContact> studentStaffContacts = new ArrayList<>();
		studentStaffContacts.add(staff);

		return studentStaffContacts;
	}

	public List<StaffContact> getStaffContactsByAdvanceFilter(String contactDateFrom,
																			 String contactDateTo, String reContactedDateFrom, String reContactedDateTo, String councellorContact,
																			 String contactType, String reContacted) {
		// TODO Place repository code
		StaffContact staff = new StaffContact(1, "Criage", "Adam", "(832)654-6546",
				"09/06/2017", "JACKSON", "190", "");
		List<StaffContact> studentStaffContacts = new ArrayList<>();
		studentStaffContacts.add(staff);

		return studentStaffContacts;
	}

	public List<StaffContact> getStaffContactsByMoreFilter(String collegeReady, String advisor,
																		  String codes, String tutor, String entryDateFrom, String entrySchool, String collegeType,
																		  String collegeName, String entryDateTo, String gpaEntry, String gpaStart, String gpaEnd) {
		// TODO Place repository code
		StaffContact staff = new StaffContact(1, "Criage", "Adam", "(832)654-6546",
				"09/06/2017", "JACKSON", "190", "");
		List<StaffContact> studentStaffContacts = new ArrayList<>();
		studentStaffContacts.add(staff);

		return studentStaffContacts;
	}

	public List<StaffContact> getStaffContactsByMoreAdvanceFilter(String zipCode, String major,
																				 String siteLocation, String incomeSource, String entryCollege, String cohortYear) {
		// TODO Place repository code
		StaffContact staff = new StaffContact(1, "Edge", "Adekunle-moses", "(832)654-6546",
				"09/06/2017", "JACKSON", "200", "");
		List<StaffContact> studentStaffContacts = new ArrayList<>();
		studentStaffContacts.add(staff);

		return studentStaffContacts;
	}

	public String deleteStaffContact(String StaffContactId) {
		// TODO Place repository code
		return "Deleted";
	}

}
