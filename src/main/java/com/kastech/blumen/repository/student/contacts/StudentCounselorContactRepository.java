package com.kastech.blumen.repository.student.contacts;

import com.kastech.blumen.model.student.contacts.StudentCounselorContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCounselorContactRepository extends JpaRepository<StudentCounselorContact,Long> {
}
