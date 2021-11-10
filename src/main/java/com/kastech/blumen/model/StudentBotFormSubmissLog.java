package com.kastech.blumen.model;

public class StudentBotFormSubmissLog {

    private String submissionId;
    private String botFormName;
    private String submissionDate;
    private String name;
    private String email;
    private String status;
    private String archive;
    private String preview;

    public StudentBotFormSubmissLog() {
    }

    public StudentBotFormSubmissLog(String submissionId, String botFormName, String submissionDate, String name, String email, String status, String archive, String preview) {
        this.submissionId = submissionId;
        this.botFormName = botFormName;
        this.submissionDate = submissionDate;
        this.name = name;
        this.email = email;
        this.status = status;
        this.archive = archive;
        this.preview = preview;
    }

    public String getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(String submissionId) {
        this.submissionId = submissionId;
    }

    public String getBotFormName() {
        return botFormName;
    }

    public void setBotFormName(String botFormName) {
        this.botFormName = botFormName;
    }

    public String getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(String submissionDate) {
        this.submissionDate = submissionDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getArchive() {
        return archive;
    }

    public void setArchive(String archive) {
        this.archive = archive;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    @Override
    public String toString() {
        return "StudentBotFormSubmissLog{" +
                "submissionId='" + submissionId + '\'' +
                ", botFormName='" + botFormName + '\'' +
                ", submissionDate='" + submissionDate + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", status='" + status + '\'' +
                ", archive='" + archive + '\'' +
                ", preview='" + preview + '\'' +
                '}';
    }
}
