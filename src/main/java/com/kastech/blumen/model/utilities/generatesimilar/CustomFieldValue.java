package com.kastech.blumen.model.utilities.generatesimilar;

import javax.persistence.*;

@Entity
@Table(name = "custom_field_value", schema = "blumen2")
public class CustomFieldValue {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="custom_field_value_list_seq_gen")
    @SequenceGenerator(name="custom_field_value_list_seq_gen", sequenceName="CUSTOM_FIELD_VALUE_LIST_SEQ")
    private Long id;
    private String customFieldName;
    private String customFieldCode;

    public CustomFieldValue() {
    }

    public CustomFieldValue(Long id, String customFieldName, String customFieldCode) {
        this.id = id;
        this.customFieldName = customFieldName;
        this.customFieldCode = customFieldCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomFieldName() {
        return customFieldName;
    }

    public void setCustomFieldName(String customFieldName) {
        this.customFieldName = customFieldName;
    }

    public String getCustomFieldCode() {
        return customFieldCode;
    }

    public void setCustomFieldCode(String customFieldCode) {
        this.customFieldCode = customFieldCode;
    }

    @Override
    public String toString() {
        return "CustomFieldValue{" +
                "id=" + id +
                ", customFieldName='" + customFieldName + '\'' +
                ", customFieldCode='" + customFieldCode + '\'' +
                '}';
    }
}
