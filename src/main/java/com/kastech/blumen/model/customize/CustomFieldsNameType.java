package com.kastech.blumen.model.customize;

public class CustomFieldsNameType {


    private String customId;
    private String pullDownName;

    public CustomFieldsNameType() {
    }

    public CustomFieldsNameType(String customId, String pullDownName) {
        this.customId = customId;
        this.pullDownName = pullDownName;
    }

    public String getCustomId() {
        return customId;
    }

    public void setCustomId(String customId) {
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
}
