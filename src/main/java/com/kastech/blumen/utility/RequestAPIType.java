package com.kastech.blumen.utility;

public enum RequestAPIType {

    GET_PULL_DOWN_LIST_V1("/api/blumen-api/getPullDownList/v1"),
    PULL_DOWN_LIST_V1("/api/blumen-api/pullDownList/v1"),
    UPDATE_PULL_DOWN_LIST_V1("/api/blumen-api/updatePullDownList/v1"),
    FILTER_PULL_DOWN_LIST_V1("/api/blumen-api/filter/pulldownlist/v1"),
    DELETE_PULL_DOWN_LIST_V1("/api/blumen-api/deletePullDownList/v1"),


    GET_TEACHER_LIST_V1("/api/blumen-api/getTeacherList/v1"),
    TEACHER_LIST_V1("/api/blumen-api/teacherList/v1"),
    UPDATE_TEACHER_LIST_V1("/api/blumen-api/updateTeacherList/v1"),
    FILTER_TEACHER_LIST_V1("/api/blumen-api/filter/teacherlist/v1"),
    DELETE_TEACHER_LIST_V1("/api/blumen-api/deleteTeacherList/v1"),


    GET_TUTOR_LIST_V1("/api/blumen-api/getTutorList/v1"),
    TUTOR_LIST_V1("/api/blumen-api/TutorList/v1"),
    UPDATE_TUTOR_LIST_V1("/api/blumen-api/updateTutorList/v1"),
    FILTER_TUTOR_LIST_V1("/api/blumen-api/filter/tutorlist/v1"),
    DELETE_TUTOR_LIST_V1("/api/blumen-api/deleteTutorList/v1"),


    GET_STAFF_LIST_V1("/api/blumen-api/getStaffList/v1"),
    STAFF_LIST_V1("/api/blumen-api/staffList/v1"),
    UPDATE_STAFF_LIST_V1("/api/blumen-api/updateStaffList/v1"),
    FILTER_STAFF_LIST_V1("/api/blumen-api/filter/stafflist/v1"),
    DELETE_STAFF_LIST_V1("/api/blumen-api/deleteStaffList/v1"),


    GET_COUNCILOR_LIST_V1("/api/blumen-api/getCouncilorList/v1"),
    COUNCILOR_LIST_V1("/api/blumen-api/councilorList/v1"),
    UPDATE_COUNCILOR_LIST_V1("/api/blumen-api/updateCouncilorList/v1"),
    FILTER_COUNCILOR_LIST_V1("/api/blumen-api/filter/councilorlist/v1"),
    DELETE_COUNCILOR_LIST_V1("/api/blumen-api/deleteCouncilorList/v1"),


    GET_COLLEGE_SCHOOL_LIST_V1("/api/blumen-api/getCollegeSchoolList/v1"),
    COLLEGE_SCHOOL_LIST_V1("/api/blumen-api/collegeSchoolList/v1"),
    UPDATE_COLLEGE_SCHOOL_LIST_V1("/api/blumen-api/updateCollegeSchoolList/v1"),
    FILTER_COLLEGE_SCHOOL_LIST_V1("/api/blumen-api/filter/collegeSchoollist/v1"),
    DELETE_COLLEGE_SCHOOL_LIST_V1("/api/blumen-api/deleteCollegeSchoolList/v1");

    private String apiPath;

    private RequestAPIType(String apiPath) {
        this.apiPath = apiPath;
    }

    public String getApiPath() {
        return this.apiPath;
    }

}
