package com.kastech.blumen.validator.utilities.generatesimilar;

import com.kastech.blumen.exception.DataInputException;
import com.kastech.blumen.model.RequestDataVO;
import com.kastech.blumen.utility.ValidationUtility;
import com.kastech.blumen.validator.RequestValidator;
import org.springframework.stereotype.Service;

@Service
public class CustomFieldValueValidator extends RequestValidator {

    @Override
    public void validateJSONBasedRequest(RequestDataVO requestDataVO) throws DataInputException {

        ValidationUtility.parseJSONFailFast(requestDataVO);

    }
}
