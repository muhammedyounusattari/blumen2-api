package com.kastech.blumen.repository.student;

import com.kastech.blumen.model.student.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query(value = "from Student student")
    public Page<Student> getStudents(Pageable page);
    @Query(nativeQuery = true,value = "SELECT student.sfirst,student.slast,student.phone1 ,student.phone2,student_yearly.yearfi,\n" +
            "student_yearly.active,student_yearly.served,student_yearly.reported,student_yearly.counsel,\n" +
            "student_yearly.school,student_yearly.standing  FROM student student \n" +
            "INNER JOIN student_yearly student_yearly\n" +
            "ON student_yearly.stuid=student.stuid\n" +
            "where student_yearly.yearfi =:yearfi\n" +
            "and ( 1=:activeAll or  student_yearly.active  =:active)\n" +
            "and (1=:reportedAll or student_yearly.reported =:reported)\n" +
            "and (1=:servedAll or student_yearly.served =:served)"
            )
    public Page<StudentFilterView> findStudentView(Pageable page, @Param("yearfi") Integer yearfi, @Param("active") Boolean active,

                                        @Param("activeAll") Integer activeAll, @Param("reported") Boolean reported,

                                        @Param("reportedAll") Integer reportedAll, @Param("served") Boolean served,

                                        @Param("servedAll") Integer servedAll);

    /*@Query(value = "SELECT s FROM Student s where s.fiscalYear=?1 ORDER BY ssno")
    List<Student> findAllStudentbyFiscalYear(@Param("fiscalYear") String fiscalYear);


    @Query(value = "SELECT s FROM Student s where s.isDeletedStudent=true ORDER BY ssno")
    List<Student> getAllDeletedStudent();

    @Query(value = "SELECT s FROM Student s where s.isDeletedStudent=true and ssno=?1 ORDER BY ssno")
    Student getDeletedStudentBySsno(@Param("ssno") Long ssno);*/

    Student findFirstByOrganizationIdOrderByStuidDesc(Integer organizationId);

    Student findBySsnoAndOrganizationId(String ssno, Integer organizationId);

    Student findBySfirstAndSlastAndOrganizationId(String sfirst, String slast, Integer organizationId);

    @Modifying
    @Query("update Student set imagePath = :imagePath where stuid=:id")
    void updateStudentProfileImagePath(@Param("id") long id, @Param("imagePath") String imagePath);
}

