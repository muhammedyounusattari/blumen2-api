package com.kastech.blumen.model.Configurations;

import javax.persistence.*;

@Entity
@Table(name = "student_data_field_master" ,schema = "blumen2")
public class StudentDataFieldMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "student_data_field_master_seq_gen", sequenceName = "student_data_field_master_seq")
    private long studentDataFieldMasterId;
    private String tableName;
    private String keyName;
    private String fieldName;

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public long getStudentDataFieldMasterId() {
        return studentDataFieldMasterId;
    }

    public void setStudentDataFieldMasterId(long studentDataFieldMasterId) {
        studentDataFieldMasterId = studentDataFieldMasterId;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }


}