package com.kastech.blumen.model.student.logs;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "text_messages" ,schema = "blumen2")
public class StudentTextMessagesLog {

	@Id
	private Long id;
    private String ssno;
    private String firstName;
    private String lastName;
    private String phoneName;
    private String dateTime;
    private String sentBy;
    private String textMessage;
    private String replyRead;
    private String messageStatus;
    private String fiscalYear;
    private boolean active;
    private boolean served;
    private boolean reported;
    private String councelor;
    private String school;
    private String standing;

    public StudentTextMessagesLog() {
    }

    public StudentTextMessagesLog(String ssno, String firstName, String lastName, String phoneName, String dateTime, String sentBy, String textMessage, String replyRead, String messageStatus, String fiscalYear, boolean active, boolean served, boolean reported, String councelor, String school, String standing) {
        this.ssno = ssno;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneName = phoneName;
        this.dateTime = dateTime;
        this.sentBy = sentBy;
        this.textMessage = textMessage;
        this.replyRead = replyRead;
        this.messageStatus = messageStatus;
        this.fiscalYear = fiscalYear;
        this.active = active;
        this.served = served;
        this.reported = reported;
        this.councelor = councelor;
        this.school = school;
        this.standing = standing;
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSsno() {
        return ssno;
    }

    public void setSsno(String ssno) {
        this.ssno = ssno;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getSentBy() {
        return sentBy;
    }

    public void setSentBy(String sentBy) {
        this.sentBy = sentBy;
    }

    public String getTextMessage() {
        return textMessage;
    }

    public void setTextMessage(String textMessage) {
        this.textMessage = textMessage;
    }

    public String getReplyRead() {
        return replyRead;
    }

    public void setReplyRead(String replyRead) {
        this.replyRead = replyRead;
    }

    public String getMessageStatus() {
        return messageStatus;
    }

    public void setMessageStatus(String messageStatus) {
        this.messageStatus = messageStatus;
    }

    public String getFiscalYear() {
        return fiscalYear;
    }

    public void setFiscalYear(String fiscalYear) {
        this.fiscalYear = fiscalYear;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isServed() {
        return served;
    }

    public void setServed(boolean served) {
        this.served = served;
    }

    public boolean isReported() {
        return reported;
    }

    public void setReported(boolean reported) {
        this.reported = reported;
    }

    public String getCouncelor() {
        return councelor;
    }

    public void setCouncelor(String councelor) {
        this.councelor = councelor;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getStanding() {
        return standing;
    }

    public void setStanding(String standing) {
        this.standing = standing;
    }

    @Override
    public String toString() {
        return "StudentTextMessagesLog{" +
                "ssno='" + ssno + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneName='" + phoneName + '\'' +
                ", dateTime='" + dateTime + '\'' +
                ", sentBy='" + sentBy + '\'' +
                ", textMessage='" + textMessage + '\'' +
                ", replyRead='" + replyRead + '\'' +
                ", messageStatus='" + messageStatus + '\'' +
                ", fiscalYear='" + fiscalYear + '\'' +
                ", active=" + active +
                ", served=" + served +
                ", reported=" + reported +
                ", councelor='" + councelor + '\'' +
                ", school='" + school + '\'' +
                ", standing='" + standing + '\'' +
                '}';
    }
}
