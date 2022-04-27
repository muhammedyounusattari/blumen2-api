package com.kastech.blumen.service.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.kastech.blumen.model.admin.TutorContact;
import com.kastech.blumen.repository.tutor.TutorContactRepository;



@Service
public class TutorContactsService {

	@Autowired
	TutorContactRepository tutorContactRepository;
	
	
	public List<TutorContact> getTutorContactList() {
		return tutorContactRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}
	
	public List<TutorContact> getTutorContactsByNormalFilter(String fiscalYear, String active,
																			String served, String reported, String counselor, String status, String ethnicity, String standing,
																			String school, String eligibility, String gender) {
		return tutorContactRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}

	public List<TutorContact> getTutorContactsByAdvanceFilter(String contactDateFrom,
																			 String contactDateTo, String reContactedDateFrom, String reContactedDateTo, String councellorContact,
																			 String contactType, String reContacted) {
		return tutorContactRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}

	public List<TutorContact> getTutorContactsByMoreFilter(String collegeReady, String advisor,
																		  String codes, String tutor, String entryDateFrom, String entrySchool, String collegeType,
																		  String collegeName, String entryDateTo, String gpaEntry, String gpaStart, String gpaEnd) {
		return tutorContactRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}

	public List<TutorContact> getTutorContactsByMoreAdvanceFilter(String zipCode, String major,
																				 String siteLocation, String incomeSource, String entryCollege, String cohortYear) {
		return tutorContactRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}

	public void deleteTutorContact(Long tutorContactId) {
		tutorContactRepository.deleteById(tutorContactId);
	}

}
