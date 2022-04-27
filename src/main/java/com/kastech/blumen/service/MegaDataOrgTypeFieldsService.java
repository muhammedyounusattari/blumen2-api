package com.kastech.blumen.service;

import com.kastech.blumen.model.MegaDataOrgTypeFields;

public interface MegaDataOrgTypeFieldsService {

    MegaDataOrgTypeFields save(MegaDataOrgTypeFields megaDataOrgTypeFields);

    MegaDataOrgTypeFields getMegaDataOrgTypeFieldsById(long id);

    void deleteMegaDataOrgTypeFieldsById(long id);

}
