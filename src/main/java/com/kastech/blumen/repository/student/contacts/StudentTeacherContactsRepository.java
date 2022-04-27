package com.kastech.blumen.repository.student.contacts;

import com.kastech.blumen.model.student.contacts.StudentTeacherContacts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentTeacherContactsRepository extends JpaRepository<StudentTeacherContacts,Long> {
}
