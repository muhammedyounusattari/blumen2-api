package com.kastech.blumen.repository.student.logs;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kastech.blumen.model.student.logs.StudentTextMessagesReplies;

@Repository
public interface StudentTextMessagesRepliesRepository extends JpaRepository<StudentTextMessagesReplies, Long> {
}
