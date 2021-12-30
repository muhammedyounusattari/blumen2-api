package com.kastech.blumen.repository.student.contacts;

import com.kastech.blumen.model.student.contacts.StudentTutorContacts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentTutorContactsRepository extends JpaRepository<StudentTutorContacts,Long> {
}
