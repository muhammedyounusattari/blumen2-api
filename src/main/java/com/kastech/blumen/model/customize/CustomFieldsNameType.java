package com.kastech.blumen.model.customize;

import javax.persistence.*;

@Entity
@Table(name = "custom_fields_nametype", schema = "blumen2")
public class CustomFieldsNameType {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="custom_fields_nametype_list_seq_gen")
    @SequenceGenerator(name="custom_fields_nametype_list_seq_gen", sequenceName="CUSTOM_FIELDS_NAMETYPE_LIST_SEQ")
    private Long customId;
    private String pullDownName;

    public CustomFieldsNameType() {
    }

    public CustomFieldsNameType(Long customId, String pullDownName) {
        this.customId = customId;
        this.pullDownName = pullDownName;
    }

    public Long getCustomId() {
        return customId;
    }

    public void setCustomId(Long customId) {
        this.customId = customId;
    }

    public String getPullDownName() {
        return pullDownName;
    }

    public void setPullDownName(String pullDownName) {
        this.pullDownName = pullDownName;
    }

    @Override
    public String toString() {
        return "CustomFieldsNameType{" +
                "customId='" + customId + '\'' +
                ", pullDownName='" + pullDownName + '\'' +
                '}';
    }

    public CustomFieldsNameType updateWith(CustomFieldsNameType item) {
        return new CustomFieldsNameType(
                this.customId,
                item.pullDownName
        );
    }
}
