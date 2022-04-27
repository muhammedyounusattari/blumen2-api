package com.kastech.blumen.repository.student.contacts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kastech.blumen.model.student.contacts.StudentDispTutorContReminder;

@Repository
public interface StudentDispTutorContReminderRepository extends JpaRepository<StudentDispTutorContReminder,Long> {
}
