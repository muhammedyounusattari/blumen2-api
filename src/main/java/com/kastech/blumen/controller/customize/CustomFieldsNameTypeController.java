package com.kastech.blumen.controller.customize;

import com.kastech.blumen.model.customize.CustomFieldsNameType;
import com.kastech.blumen.repository.customize.CustomFieldsNameTypeRepository;
import com.kastech.blumen.service.customize.CustomFieldsNameTypeServiceV1;
import com.kastech.blumen.validator.customize.CustomFieldsNameTypeValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/blumen-api/customize")
public class CustomFieldsNameTypeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ActivityGroupListController.class);

    CustomFieldsNameTypeRepository customFieldsNameTypeRepository;

    @Autowired
    CustomFieldsNameTypeServiceV1 customFieldsNameTypeServiceV1;


    @Autowired
    CustomFieldsNameTypeValidator customFieldsNameTypeValidator;

    Map<Long, CustomFieldsNameType> customFieldsNameTypeMap = new HashMap<Long, CustomFieldsNameType>();

    @ResponseBody
    @GetMapping(path = "/getCustomFieldsNameType/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<CustomFieldsNameType> getCustomFieldsNameType() {

        List<CustomFieldsNameType> list = new ArrayList<>();
        Iterable<CustomFieldsNameType> items = customFieldsNameTypeRepository.findAll();
        items.forEach(list::add);
        return list;
    }

    @ResponseBody
    @PostMapping(path = "/customFieldsNameType/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public CustomFieldsNameType addToCustomFieldsNameType(@RequestBody String reqBody) {
        CustomFieldsNameType customFieldsNameType = customFieldsNameTypeServiceV1.doService(reqBody);
        return customFieldsNameTypeRepository.save(customFieldsNameType);
    }

    @ResponseBody
    @PutMapping(path = "/updateCustomFieldsNameType/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Optional<CustomFieldsNameType> editCustomFieldsNameType(@RequestBody String reqBody) {
        CustomFieldsNameType customFieldsNameType = customFieldsNameTypeServiceV1.doService(reqBody);

        return customFieldsNameTypeRepository.findById(customFieldsNameType.getCustomId())
                .map(oldItem -> {
                    CustomFieldsNameType updated = oldItem.updateWith(customFieldsNameType);
                    return customFieldsNameTypeRepository.save(updated);
                });
    }


    @ResponseBody
    @PutMapping(path = "/filter/customFieldsNameType/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> filterCustomFieldsNameType(@RequestBody String reqBody) {
        CustomFieldsNameType customFieldsNameType = customFieldsNameTypeServiceV1.doService(reqBody);
        return ResponseEntity.status(HttpStatus.OK).body("filter pull down list");
    }


    @ResponseBody
    @PutMapping(path = "/deleteCustomFieldsNameTypeList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<CustomFieldsNameType>> deleteCustomFieldsNameType(@RequestBody String reqBody) {

        CustomFieldsNameType customFieldsNameType = customFieldsNameTypeServiceV1.doService(reqBody);
        customFieldsNameTypeRepository.delete(customFieldsNameType);
        return ResponseEntity.noContent().build();
    }
}
