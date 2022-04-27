package com.kastech.blumen.repository.student.contacts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kastech.blumen.model.student.contacts.StudentDispTeacherContRemi;

@Repository
public interface StudentDispTeacherContRemiRepository extends JpaRepository<StudentDispTeacherContRemi,Long> {
}
