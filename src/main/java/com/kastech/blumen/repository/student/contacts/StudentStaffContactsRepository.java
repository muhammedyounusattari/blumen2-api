package com.kastech.blumen.repository.student.contacts;

import com.kastech.blumen.model.student.contacts.StudentStaffContacts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentStaffContactsRepository extends JpaRepository<StudentStaffContacts,Long> {
}
