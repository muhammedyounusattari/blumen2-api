package com.kastech.blumen.repository.student;

import com.kastech.blumen.model.admin.systemtools.TimeClockManager;
import com.kastech.blumen.model.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query(value = "SELECT s FROM Student s where s.fiscalYear=?1 ORDER BY ssno")
    List<Student> findAllStudentbyFiscalYear(@Param("fiscalYear") String fiscalYear);


    @Query(value = "SELECT s FROM Student s where s.isDeletedStudent=true ORDER BY ssno")
    List<Student> getAllDeletedStudent();

    @Query(value = "SELECT s FROM Student s where s.isDeletedStudent=true and ssno=?1 ORDER BY ssno")
    Student getDeletedStudentBySsno(@Param("ssno") Long ssno);

    /*@Transactional
    @Modifying
    @Query(value = "update Student s SET s.fiscalYear =:fiscalYear where s.ssno in (:ssnoList) ")
    void updateAllStudentbyFiscalYear(@Param("fiscalYear") String fiscalYear,@Param("ssNoList") List<String> ssNoList);*/


}

