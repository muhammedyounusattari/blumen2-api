package com.kastech.blumen.model.customize;

public class LabSettingPreferences {

    private String lapSearchPriority;
    private String labFiscalYear;
    private String labComponents;
    private boolean labHideStudentList;
    private boolean labHideCheckOutList;
    private String labWaitWindowTime;
    private boolean labAutomaticallyCheckInCheckOut;

    //lab services fields
    private boolean labServicesVisibile;
    private boolean labServicerRequired;
    private String labDefaultService;
    private boolean labStudentsCanChooseMultipleService;
    private boolean labReasonForVisitOptionVisible;
    private boolean labStaffMemberOptionVisible;

    private String labMaxCheckoutTime;
    private String labForcedTimeSpent;
    private boolean labAcknowledgement;

    public LabSettingPreferences() {
    }

    public LabSettingPreferences(String lapSearchPriority, String labFiscalYear, String labComponents, boolean labHideStudentList, boolean labHideCheckOutList, String labWaitWindowTime, boolean labAutomaticallyCheckInCheckOut, boolean labServicesVisibile, boolean labServicerRequired, String labDefaultService, boolean labStudentsCanChooseMultipleService, boolean labReasonForVisitOptionVisible, boolean labStaffMemberOptionVisible, String labMaxCheckoutTime, String labForcedTimeSpent, boolean labAcknowledgement) {
        this.lapSearchPriority = lapSearchPriority;
        this.labFiscalYear = labFiscalYear;
        this.labComponents = labComponents;
        this.labHideStudentList = labHideStudentList;
        this.labHideCheckOutList = labHideCheckOutList;
        this.labWaitWindowTime = labWaitWindowTime;
        this.labAutomaticallyCheckInCheckOut = labAutomaticallyCheckInCheckOut;
        this.labServicesVisibile = labServicesVisibile;
        this.labServicerRequired = labServicerRequired;
        this.labDefaultService = labDefaultService;
        this.labStudentsCanChooseMultipleService = labStudentsCanChooseMultipleService;
        this.labReasonForVisitOptionVisible = labReasonForVisitOptionVisible;
        this.labStaffMemberOptionVisible = labStaffMemberOptionVisible;
        this.labMaxCheckoutTime = labMaxCheckoutTime;
        this.labForcedTimeSpent = labForcedTimeSpent;
        this.labAcknowledgement = labAcknowledgement;
    }

    public String getLapSearchPriority() {
        return lapSearchPriority;
    }

    public void setLapSearchPriority(String lapSearchPriority) {
        this.lapSearchPriority = lapSearchPriority;
    }

    public String getLabFiscalYear() {
        return labFiscalYear;
    }

    public void setLabFiscalYear(String labFiscalYear) {
        this.labFiscalYear = labFiscalYear;
    }

    public String getLabComponents() {
        return labComponents;
    }

    public void setLabComponents(String labComponents) {
        this.labComponents = labComponents;
    }

    public boolean isLabHideStudentList() {
        return labHideStudentList;
    }

    public void setLabHideStudentList(boolean labHideStudentList) {
        this.labHideStudentList = labHideStudentList;
    }

    public boolean isLabHideCheckOutList() {
        return labHideCheckOutList;
    }

    public void setLabHideCheckOutList(boolean labHideCheckOutList) {
        this.labHideCheckOutList = labHideCheckOutList;
    }

    public String getLabWaitWindowTime() {
        return labWaitWindowTime;
    }

    public void setLabWaitWindowTime(String labWaitWindowTime) {
        this.labWaitWindowTime = labWaitWindowTime;
    }

    public boolean isLabAutomaticallyCheckInCheckOut() {
        return labAutomaticallyCheckInCheckOut;
    }

    public void setLabAutomaticallyCheckInCheckOut(boolean labAutomaticallyCheckInCheckOut) {
        this.labAutomaticallyCheckInCheckOut = labAutomaticallyCheckInCheckOut;
    }

    public boolean isLabServicesVisibile() {
        return labServicesVisibile;
    }

    public void setLabServicesVisibile(boolean labServicesVisibile) {
        this.labServicesVisibile = labServicesVisibile;
    }

    public boolean isLabServicerRequired() {
        return labServicerRequired;
    }

    public void setLabServicerRequired(boolean labServicerRequired) {
        this.labServicerRequired = labServicerRequired;
    }

    public String getLabDefaultService() {
        return labDefaultService;
    }

    public void setLabDefaultService(String labDefaultService) {
        this.labDefaultService = labDefaultService;
    }

    public boolean isLabStudentsCanChooseMultipleService() {
        return labStudentsCanChooseMultipleService;
    }

    public void setLabStudentsCanChooseMultipleService(boolean labStudentsCanChooseMultipleService) {
        this.labStudentsCanChooseMultipleService = labStudentsCanChooseMultipleService;
    }

    public boolean isLabReasonForVisitOptionVisible() {
        return labReasonForVisitOptionVisible;
    }

    public void setLabReasonForVisitOptionVisible(boolean labReasonForVisitOptionVisible) {
        this.labReasonForVisitOptionVisible = labReasonForVisitOptionVisible;
    }

    public boolean isLabStaffMemberOptionVisible() {
        return labStaffMemberOptionVisible;
    }

    public void setLabStaffMemberOptionVisible(boolean labStaffMemberOptionVisible) {
        this.labStaffMemberOptionVisible = labStaffMemberOptionVisible;
    }

    public String getLabMaxCheckoutTime() {
        return labMaxCheckoutTime;
    }

    public void setLabMaxCheckoutTime(String labMaxCheckoutTime) {
        this.labMaxCheckoutTime = labMaxCheckoutTime;
    }

    public String getLabForcedTimeSpent() {
        return labForcedTimeSpent;
    }

    public void setLabForcedTimeSpent(String labForcedTimeSpent) {
        this.labForcedTimeSpent = labForcedTimeSpent;
    }

    public boolean getLabAcknowledgement() {
        return labAcknowledgement;
    }

    public void setLabAcknowledgement(boolean labAcknowledgement) {
        this.labAcknowledgement = labAcknowledgement;
    }

    @Override
    public String toString() {
        return "LabSettingPreferences{" +
                "lapSearchPriority='" + lapSearchPriority + '\'' +
                ", labFiscalYear='" + labFiscalYear + '\'' +
                ", labComponents='" + labComponents + '\'' +
                ", labHideStudentList=" + labHideStudentList +
                ", labHideCheckOutList=" + labHideCheckOutList +
                ", labWaitWindowTime='" + labWaitWindowTime + '\'' +
                ", labAutomaticallyCheckInCheckOut=" + labAutomaticallyCheckInCheckOut +
                ", labServicesVisibile=" + labServicesVisibile +
                ", labServicerRequired=" + labServicerRequired +
                ", labDefaultService='" + labDefaultService + '\'' +
                ", labStudentsCanChooseMultipleService=" + labStudentsCanChooseMultipleService +
                ", labReasonForVisitOptionVisible=" + labReasonForVisitOptionVisible +
                ", labStaffMemberOptionVisible=" + labStaffMemberOptionVisible +
                ", labMaxCheckoutTime='" + labMaxCheckoutTime + '\'' +
                ", labForcedTimeSpent='" + labForcedTimeSpent + '\'' +
                ", labAcknowledgement='" + labAcknowledgement + '\'' +
                '}';
    }
}
