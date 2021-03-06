package com.kastech.blumen.validator.customize;

import com.kastech.blumen.exception.DataInputException;
import com.kastech.blumen.model.RequestDataVO;
import com.kastech.blumen.utility.ValidationUtility;
import com.kastech.blumen.validator.RequestValidator;
import org.springframework.stereotype.Component;

@Component
public class PullDownListValidator extends RequestValidator {
/*
    RequestAPIType getRequestAPIType() {
        return RequestAPIType.PULL_DOWN_LIST_V1;
    }*/

    @Override
    public void validateJSONBasedRequest(RequestDataVO requestDataVO) throws DataInputException {

        ValidationUtility.parseJSONFailFast(requestDataVO);

    }

}
