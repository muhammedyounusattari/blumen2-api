package com.kastech.blumen.service.home
;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kastech.blumen.model.staff.Staff;

@Service
public class TimeClockService {

	public List<Staff> getStaffList() {
		List<Staff> staffList = new ArrayList<>();
		
		Staff staff1= new Staff();
		staff1.setStaffName("ANDERSON");
		staff1.setStaffId("1");
		
		Staff staff2= new Staff();
		staff1.setStaffName("BOOKER");
		staff1.setStaffId("2");
		
		Staff staff3= new Staff();
		staff1.setStaffName("CAMARELLO");
		staff1.setStaffId("3");
		
		staffList.add(staff1);
		staffList.add(staff2);
		staffList.add(staff3);
		return staffList;
	}

	public Staff saveOrUpdateStaffTime(Staff staff) {
		//here repostiory code fits
		return staff;
	}

}
