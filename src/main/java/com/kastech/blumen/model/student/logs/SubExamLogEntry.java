package com.kastech.blumen.model.student.logs;

import javax.persistence.*;

@Entity
@Table(name = "sub_exam_log" ,schema = "blumen2")
public class SubExamLogEntry {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="sub_exam_log_seq_gen")
    @SequenceGenerator(name="sub_exam_log_seq_gen", sequenceName="SUB_EXAM_LOG_SEQ")
    private Long id;
    String subExamName;
    Double subExamScore;

    public SubExamLogEntry() {
    }

    public SubExamLogEntry(Long id, String subExamName, Double subExamScore) {
        this.id = id;
        this.subExamName = subExamName;
        this.subExamScore = subExamScore;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubExamName() {
        return subExamName;
    }

    public void setSubExamName(String subExamName) {
        this.subExamName = subExamName;
    }

    public Double getSubExamScore() {
        return subExamScore;
    }

    public void setSubExamScore(Double subExamScore) {
        this.subExamScore = subExamScore;
    }

    @Override
    public String toString() {
        return "SubExamLogEntry{" +
                "id=" + id +
                ", subExamName='" + subExamName + '\'' +
                ", subExamScore=" + subExamScore +
                '}';
    }
}
