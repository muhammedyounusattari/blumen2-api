package com.kastech.blumen.repository.superadmin;

import com.kastech.blumen.model.superadmin.SecurityQuestionsList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SecurityQuestionsListRepository extends JpaRepository<SecurityQuestionsList, Long> {

    @Query(value = "SELECT sq FROM SecurityQuestionsList sq where sq.questionType=?1 ")
    List<SecurityQuestionsList> findByOrgCode(@Param("questionType") String questionType);
}
