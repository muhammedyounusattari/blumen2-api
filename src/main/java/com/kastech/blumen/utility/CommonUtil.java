package com.kastech.blumen.utility;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kastech.blumen.exception.ServiceLayerException;
import com.kastech.blumen.model.*;
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

    public static Councilor convertJsonStringToPojoForCouncilor(String object)  {
        Councilor councilor = null;
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(NON_NULL);
        try {
            councilor = mapper.readValue(object, Councilor.class);
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



}
