package com.kastech.blumen.service.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kastech.blumen.model.admin.TutorContact;



@Service
public class TutorContactsService {

	@Autowired

	public List<TutorContact> getTutorContactList() {
		List<TutorContact> studentTutorContacts = new ArrayList<>();
		TutorContact counselor1 = new TutorContact(1, "Alex", "Smith", "(832)654-6546",
				"09/06/2017", "JACKSON", "180", "");
		TutorContact counselor2 = new TutorContact(1, "Criage", "Adam", "(832)654-6546",
				"09/06/2017", "JACKSON", "190", "");
		TutorContact counselor3 = new TutorContact(1, "Edge", "Adekunle-moses",
				"(832)654-6546", "09/06/2017", "JACKSON", "200", "");
		TutorContact counselor4 = new TutorContact(1, "Ben", "Alpher", "(832)654-6546",
				"09/06/2017", "JACKSON", "210", "");

		studentTutorContacts.add(counselor1);
		studentTutorContacts.add(counselor2);
		studentTutorContacts.add(counselor3);
		studentTutorContacts.add(counselor4);

		return studentTutorContacts;
	}

	public List<TutorContact> getTutorContactsByNormalFilter(String fiscalYear, String active,
																			String served, String reported, String counselor, String status, String ethnicity, String standing,
																			String school, String eligibility, String gender) {
		// TODO Place repository code
		TutorContact tutor = new TutorContact(1, "Alex", "Smith", "(832)654-6546",
				"09/06/2017", "JACKSON", "180", "");
		List<TutorContact> studentTutorContacts = new ArrayList<>();
		studentTutorContacts.add(tutor);

		return studentTutorContacts;
	}

	public List<TutorContact> getTutorContactsByAdvanceFilter(String contactDateFrom,
																			 String contactDateTo, String reContactedDateFrom, String reContactedDateTo, String councellorContact,
																			 String contactType, String reContacted) {
		// TODO Place repository code
		TutorContact tutor = new TutorContact(1, "Criage", "Adam", "(832)654-6546",
				"09/06/2017", "JACKSON", "190", "");
		List<TutorContact> studentTutorContacts = new ArrayList<>();
		studentTutorContacts.add(tutor);

		return studentTutorContacts;
	}

	public List<TutorContact> getTutorContactsByMoreFilter(String collegeReady, String advisor,
																		  String codes, String tutor, String entryDateFrom, String entrySchool, String collegeType,
																		  String collegeName, String entryDateTo, String gpaEntry, String gpaStart, String gpaEnd) {
		// TODO Place repository code
		TutorContact tutorContact = new TutorContact(1, "Criage", "Adam", "(832)654-6546",
				"09/06/2017", "JACKSON", "190", "");
		List<TutorContact> studentTutorContacts = new ArrayList<>();
		studentTutorContacts.add(tutorContact);

		return studentTutorContacts;
	}

	public List<TutorContact> getTutorContactsByMoreAdvanceFilter(String zipCode, String major,
																				 String siteLocation, String incomeSource, String entryCollege, String cohortYear) {
		// TODO Place repository code
		TutorContact tutor = new TutorContact(1, "Edge", "Adekunle-moses", "(832)654-6546",
				"09/06/2017", "JACKSON", "200", "");
		List<TutorContact> studentTutorContacts = new ArrayList<>();
		studentTutorContacts.add(tutor);

		return studentTutorContacts;
	}

	public String deleteTutorContact(String TutorContactId) {
		// TODO Place repository code
		return "Deleted";
	}

}
