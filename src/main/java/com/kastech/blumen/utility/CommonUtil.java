package com.kastech.blumen.utility;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kastech.blumen.exception.ServiceLayerException;
import com.kastech.blumen.model.StudentProfile;
import com.kastech.blumen.model.admin.systemtools.TimeClockManager;
import com.kastech.blumen.model.counselor.Counselor;
import com.kastech.blumen.model.customize.*;
import com.kastech.blumen.model.keycloak.LoggedUser;
import com.kastech.blumen.model.staff.Staff;
import com.kastech.blumen.model.student.contacts.*;
import com.kastech.blumen.model.student.dataentry.AddressNotes;
import com.kastech.blumen.model.student.dataentry.GraduatedInformation;
import com.kastech.blumen.model.student.home.StudentData;
import com.kastech.blumen.model.student.logs.*;
import com.kastech.blumen.model.teacher.Teacher;
import com.kastech.blumen.model.tutor.Tutor;
import com.kastech.blumen.model.utilities.generatesimilar.AttendanceLog;
import com.kastech.blumen.model.utilities.quickedit.CoursesInformation;
import com.kastech.blumen.model.utilities.quickedit.Semester;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

public class CommonUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommonUtil.class);


    private CommonUtil(){

    }

    public static PullDown convertJsonStringToPojoForPullDown(String object)  {
        PullDown pullDownObj = null;
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(NON_NULL);
        try {
             pullDownObj = mapper.readValue(object, PullDown.class);
        } catch (Exception e) {
            LOGGER.error("Error parsing {} json string to object ", object.getClass(), e);
            throw new ServiceLayerException("Unable to parse json string to object");
        }
        return pullDownObj;
    }

    public static CollegeSchool convertJsonStringToPojoForSchoolCollege(String object)  {
        CollegeSchool schoolCollege = null;
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(NON_NULL);
        try {
            schoolCollege = mapper.readValue(object, CollegeSchool.class);
        } catch (Exception e) {
            LOGGER.error("Error parsing {} json string to object ", object.getClass(), e);
            throw new ServiceLayerException("Unable to parse json string to object");
        }
        return schoolCollege;
    }

    public static Counselor convertJsonStringToPojoForCouncilor(String object)  {
        Counselor councilor = null;
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(NON_NULL);
        try {
            councilor = mapper.readValue(object, Counselor.class);
        } catch (Exception e) {
            LOGGER.error("Error parsing {} json string to object ", object.getClass(), e);
            throw new ServiceLayerException("Unable to parse json string to object");
        }
        return councilor;
    }


    public static Staff convertJsonStringToPojoForStaff(String object)  {
        Staff staff = null;
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(NON_NULL);
        try {
            staff = mapper.readValue(object, Staff.class);
        } catch (Exception e) {
            LOGGER.error("Error parsing {} json string to object ", object.getClass(), e);
            throw new ServiceLayerException("Unable to parse json string to object");
        }
        return staff;
    }


    public static Teacher convertJsonStringToPojoForTeacher(String object)  {
        Teacher teacher = null;
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(NON_NULL);
        try {
            teacher = mapper.readValue(object, Teacher.class);
        } catch (Exception e) {
            LOGGER.error("Error parsing {} json string to object ", object.getClass(), e);
            throw new ServiceLayerException("Unable to parse json string to object");
        }
        return teacher;
    }

    public static Tutor convertJsonStringToPojoForTutor(String object)  {
        Tutor tutor = null;
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(NON_NULL);
        try {
            tutor = mapper.readValue(object, Tutor.class);
        } catch (Exception e) {
            LOGGER.error("Error parsing {} json string to object ", object.getClass(), e);
            throw new ServiceLayerException("Unable to parse json string to object");
        }
        return tutor;
    }

    public static ActivityList convertJsonStringToPojoForActivityList(String object)  {
        ActivityList activityList = null;
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(NON_NULL);
        try {
            activityList = mapper.readValue(object, ActivityList.class);
        } catch (Exception e) {
            LOGGER.error("Error parsing {} json string to object ", object.getClass(), e);
            throw new ServiceLayerException("Unable to parse json string to object");
        }
        return activityList;
    }

    public static ActivityGroupList convertJsonStringToPojoForActivityGroupList(String object)  {
        ActivityGroupList activityGroupList = null;
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(NON_NULL);
        try {
            activityGroupList = mapper.readValue(object, ActivityGroupList.class);
        } catch (Exception e) {
            LOGGER.error("Error parsing {} json string to object ", object.getClass(), e);
            throw new ServiceLayerException("Unable to parse json string to object");
        }
        return activityGroupList;
    }

    public static GradingList convertJsonStringToPojoForGradingList(String object)  {
        GradingList gradingList = null;
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(NON_NULL);
        try {
            gradingList = mapper.readValue(object, GradingList.class);
        } catch (Exception e) {
            LOGGER.error("Error parsing {} json string to object ", object.getClass(), e);
            throw new ServiceLayerException("Unable to parse json string to object");
        }
        return gradingList;
    }


    public static GradingGroupList convertJsonStringToPojoForGradingGroupList(String object)  {
        GradingGroupList gradingGroupList = null;
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(NON_NULL);
        try {
            gradingGroupList = mapper.readValue(object, GradingGroupList.class);
        } catch (Exception e) {
            LOGGER.error("Error parsing {} json string to object ", object.getClass(), e);
            throw new ServiceLayerException("Unable to parse json string to object");
        }
        return gradingGroupList;
    }

    public static LabSettingPreferences convertJsonStringToPojoForLabSettingPreferences(String object)  {
        LabSettingPreferences labSettingPreferences = null;
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(NON_NULL);
        try {
            labSettingPreferences = mapper.readValue(object, LabSettingPreferences.class);
        } catch (Exception e) {
            LOGGER.error("Error parsing {} json string to object ", object.getClass(), e);
            throw new ServiceLayerException("Unable to parse json string to object");
        }
        return labSettingPreferences;
    }

    public static String serializeToJSON(Object object)  {
        String jsonResponse = null;
        ObjectMapper jsonMapper = new ObjectMapper();
        jsonMapper.setSerializationInclusion(NON_NULL);
        try {
            jsonResponse = jsonMapper.writeValueAsString(object);
        } catch (Exception e) {
            LOGGER.error("Error parsing {} object to JSON", object.getClass(), e);
        }
        return jsonResponse;
    }


    public static StudentExamsLog convertJsonStringToPojoForStudentExamsLog(String object)  {
        StudentExamsLog studentExamsLog = null;
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(NON_NULL);
        try {
            studentExamsLog = mapper.readValue(object, StudentExamsLog.class);
        } catch (Exception e) {
            LOGGER.error("Error parsing {} json string to object ", object.getClass(), e);
            throw new ServiceLayerException("Unable to parse json string to object");
        }
        return studentExamsLog;
    }

    public static StudentNotesLog convertJsonStringToPojoForStudentNotesLog(String object)  {
        StudentNotesLog studentNotesLog = null;
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(NON_NULL);
        try {
            studentNotesLog = mapper.readValue(object, StudentNotesLog.class);
        } catch (Exception e) {
            LOGGER.error("Error parsing {} json string to object ", object.getClass(), e);
            throw new ServiceLayerException("Unable to parse json string to object");
        }
        return studentNotesLog;
    }

    public static StudentStipendLog convertJsonStringToPojoForStudentStipendLog(String object)  {
        StudentStipendLog studentStipendLog = null;
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(NON_NULL);
        try {
            studentStipendLog = mapper.readValue(object, StudentStipendLog.class);
        } catch (Exception e) {
            LOGGER.error("Error parsing {} json string to object ", object.getClass(), e);
            throw new ServiceLayerException("Unable to parse json string to object");
        }
        return studentStipendLog;
    }

    public static StudentTextMessagesLog convertJsonStringToPojoForStudentTextMessagesLog(String object)  {
        StudentTextMessagesLog studentTextMessagesLog = null;
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(NON_NULL);
        try {
            studentTextMessagesLog = mapper.readValue(object, StudentTextMessagesLog.class);
        } catch (Exception e) {
            LOGGER.error("Error parsing {} json string to object ", object.getClass(), e);
            throw new ServiceLayerException("Unable to parse json string to object");
        }
        return studentTextMessagesLog;
    }

    public static StudentTextMessagesReplies convertJsonStringToPojoForStudentTextMessagesReplies(String object)  {
        StudentTextMessagesReplies studentTextMessagesReplies = null;
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(NON_NULL);
        try {
            studentTextMessagesReplies = mapper.readValue(object, StudentTextMessagesReplies.class);
        } catch (Exception e) {
            LOGGER.error("Error parsing {} json string to object ", object.getClass(), e);
            throw new ServiceLayerException("Unable to parse json string to object");
        }
        return studentTextMessagesReplies;
    }

    public static StudentWalletLog convertJsonStringToPojoForStudentWalletLog(String object)  {
        StudentWalletLog studentWalletLog = null;
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(NON_NULL);
        try {
            studentWalletLog = mapper.readValue(object, StudentWalletLog.class);
        } catch (Exception e) {
            LOGGER.error("Error parsing {} json string to object ", object.getClass(), e);
            throw new ServiceLayerException("Unable to parse json string to object");
        }
        return studentWalletLog;
    }

    public static StudentAttendanceLog convertJsonStringToPojoForStudentAttendanceLog(String object)  {
        StudentAttendanceLog studentAttendanceLog = null;
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(NON_NULL);
        try {
            studentAttendanceLog = mapper.readValue(object, StudentAttendanceLog.class);
        } catch (Exception e) {
            LOGGER.error("Error parsing {} json string to object ", object.getClass(), e);
            throw new ServiceLayerException("Unable to parse json string to object");
        }
        return studentAttendanceLog;
    }

    public static LoggedUser convertJsonStringToPojoForLoggedUser(String object)  {
        LoggedUser loggedUser = null;
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(NON_NULL);
        try {
            loggedUser = mapper.readValue(object, LoggedUser.class);
        } catch (Exception e) {
            LOGGER.error("Error parsing {} json string to object ", object.getClass(), e);
            throw new ServiceLayerException("Unable to parse json string to object");
        }
        return loggedUser;
    }

    public static StudentDispCouContRemin convertJsonStringToPojoForStudentDispCouContRemin(String object)  {
        StudentDispCouContRemin studentDispCouContRemin = null;
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(NON_NULL);
        try {
            studentDispCouContRemin = mapper.readValue(object, StudentDispCouContRemin.class);
        } catch (Exception e) {
            LOGGER.error("Error parsing {} json string to object ", object.getClass(), e);
            throw new ServiceLayerException("Unable to parse json string to object");
        }
        return studentDispCouContRemin;
    }

    public static StudentDispStaffContReminder convertJsonStringToPojoForStudentDispStaffCont(String object)  {
        StudentDispStaffContReminder studentDispStaffContReminder = null;
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(NON_NULL);
        try {
            studentDispStaffContReminder = mapper.readValue(object, StudentDispStaffContReminder.class);
        } catch (Exception e) {
            LOGGER.error("Error parsing {} json string to object ", object.getClass(), e);
            throw new ServiceLayerException("Unable to parse json string to object");
        }
        return studentDispStaffContReminder;
    }

    public static StudentDispTeacherContRemi convertJsonStringToPojoForStudentDispTeacherContRemi(String object)  {
        StudentDispTeacherContRemi studentDispTeacherContRemi = null;
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(NON_NULL);
        try {
            studentDispTeacherContRemi = mapper.readValue(object, StudentDispTeacherContRemi.class);
        } catch (Exception e) {
            LOGGER.error("Error parsing {} json string to object ", object.getClass(), e);
            throw new ServiceLayerException("Unable to parse json string to object");
        }
        return studentDispTeacherContRemi;
    }

    public static StudentDispTutorContReminder convertJsonStringToPojoForStudentDispTutorContReminder(String object)  {
        StudentDispTutorContReminder studentDispTutorContReminder = null;
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(NON_NULL);
        try {
            studentDispTutorContReminder = mapper.readValue(object, StudentDispTutorContReminder.class);
        } catch (Exception e) {
            LOGGER.error("Error parsing {} json string to object ", object.getClass(), e);
            throw new ServiceLayerException("Unable to parse json string to object");
        }
        return studentDispTutorContReminder;
    }

    public static StudentBotFormSubmissLog convertJsonStringToPojoForStudentBotFormSubmissLog(String object)  {
        StudentBotFormSubmissLog studentBotFormSubmissLog = null;
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(NON_NULL);
        try {
            studentBotFormSubmissLog = mapper.readValue(object, StudentBotFormSubmissLog.class);
        } catch (Exception e) {
            LOGGER.error("Error parsing {} json string to object ", object.getClass(), e);
            throw new ServiceLayerException("Unable to parse json string to object");
        }
        return studentBotFormSubmissLog;
    }

    public static StudentTutorContacts convertJsonStringToPojoForStudentTutorContacts(String object)  {
        StudentTutorContacts studentTutorContacts = null;
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(NON_NULL);
        try {
            studentTutorContacts = mapper.readValue(object, StudentTutorContacts.class);
        } catch (Exception e) {
            LOGGER.error("Error parsing {} json string to object ", object.getClass(), e);
            throw new ServiceLayerException("Unable to parse json string to object");
        }
        return studentTutorContacts;
    }

    public static StudentTeacherContacts convertJsonStringToPojoForStudentTeacherContacts(String object)  {
        StudentTeacherContacts studentTeacherContacts = null;
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(NON_NULL);
        try {
            studentTeacherContacts = mapper.readValue(object, StudentTeacherContacts.class);
        } catch (Exception e) {
            LOGGER.error("Error parsing {} json string to object ", object.getClass(), e);
            throw new ServiceLayerException("Unable to parse json string to object");
        }
        return studentTeacherContacts;
    }

    public static StudentStaffContacts convertJsonStringToPojoForStudentStaffContacts(String object)  {
        StudentStaffContacts studentStaffContacts = null;
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(NON_NULL);
        try {
            studentStaffContacts = mapper.readValue(object, StudentStaffContacts.class);
        } catch (Exception e) {
            LOGGER.error("Error parsing {} json string to object ", object.getClass(), e);
            throw new ServiceLayerException("Unable to parse json string to object");
        }
        return studentStaffContacts;
    }

    public static CustomFieldsNameType convertJsonStringToPojoForCustomFieldsNameType(String object)  {
        CustomFieldsNameType customFieldsNameType = null;
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(NON_NULL);
        try {
            customFieldsNameType = mapper.readValue(object, CustomFieldsNameType.class);
        } catch (Exception e) {
            LOGGER.error("Error parsing {} json string to object ", object.getClass(), e);
            throw new ServiceLayerException("Unable to parse json string to object");
        }
        return customFieldsNameType;
    }

    public static StudentProfile convertJsonStringToPojoForStudentProfile(String object)  {
        StudentProfile studentProfile = null;
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(NON_NULL);
        try {
            studentProfile = mapper.readValue(object, StudentProfile.class);
        } catch (Exception e) {
            LOGGER.error("Error parsing {} json string to object ", object.getClass(), e);
            throw new ServiceLayerException("Unable to parse json string to object");
        }
        return studentProfile;
    }

    public static TimeClockManager convertJsonStringToPojoForTimeClockManager(String object)  {
        TimeClockManager timeClockManager = null;
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(NON_NULL);
        try {
            timeClockManager = mapper.readValue(object, TimeClockManager.class);
        } catch (Exception e) {
            LOGGER.error("Error parsing {} json string to object ", object.getClass(), e);
            throw new ServiceLayerException("Unable to parse json string to object");
        }
        return timeClockManager;
    }

    public static AttendanceLog convertJsonStringToPojoForAttendanceLog(String object)  {
        AttendanceLog attendanceLog = null;
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(NON_NULL);
        try {
            attendanceLog = mapper.readValue(object, AttendanceLog.class);
        } catch (Exception e) {
            LOGGER.error("Error parsing {} json string to object ", object.getClass(), e);
            throw new ServiceLayerException("Unable to parse json string to object");
        }
        return attendanceLog;
    }

    public static CoursesInformation convertJsonStringToPojoForCoursesInformation(String object)  {
        CoursesInformation coursesInformation = null;
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(NON_NULL);
        try {
            coursesInformation = mapper.readValue(object, CoursesInformation.class);
        } catch (Exception e) {
            LOGGER.error("Error parsing {} json string to object ", object.getClass(), e);
            throw new ServiceLayerException("Unable to parse json string to object");
        }
        return coursesInformation;
    }


    public static GraduatedInformation convertJsonStringToPojoForGraduatedInformation(String object)  {
        GraduatedInformation graduatedInformation = null;
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(NON_NULL);
        try {
            graduatedInformation = mapper.readValue(object, GraduatedInformation.class);
        } catch (Exception e) {
            LOGGER.error("Error parsing {} json string to object ", object.getClass(), e);
            throw new ServiceLayerException("Unable to parse json string to object");
        }
        return graduatedInformation;
    }

    public static AddressNotes convertJsonStringToPojoForAddressNotes(String object)  {
        AddressNotes addressNotes = null;
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(NON_NULL);
        try {
            addressNotes = mapper.readValue(object, AddressNotes.class);
        } catch (Exception e) {
            LOGGER.error("Error parsing {} json string to object ", object.getClass(), e);
            throw new ServiceLayerException("Unable to parse json string to object");
        }
        return addressNotes;
    }

    public static Semester convertJsonStringToPojoForSemester(String object)  {
        Semester semester = null;
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(NON_NULL);
        try {
            semester = mapper.readValue(object, Semester.class);
        } catch (Exception e) {
            LOGGER.error("Error parsing {} json string to object ", object.getClass(), e);
            throw new ServiceLayerException("Unable to parse json string to object");
        }
        return semester;
    }

    public static StudentData convertJsonStringToPojoForStudent(String object)  {
        StudentData student = null;
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(NON_NULL);
        try {
            student = mapper.readValue(object, StudentData.class);
        } catch (Exception e) {
            LOGGER.error("Error parsing {} json string to object ", object.getClass(), e);
            throw new ServiceLayerException("Unable to parse json string to object");
        }
        return student;
    }

}
