package com.kastech.blumen.utility;

import com.google.common.collect.ImmutableList;

public class KeycloakConstants {
    
    private KeycloakConstants() {
        
    }

    public static final String KEYCLOAK_ADMIN_CLIENT_ID="admin-cli";
    public static final String ROLE_API_ACCESS = "apiAccess";
    public static final String ROLE_GUI_ACCESS = "guiAccess";
    public static final String ROLE_ADMINISTRATOR = "administrator";
    public static final String ROLE_USER_MANAGEMENT = "userManagement";
    public static final ImmutableList<String> ROLE_KEYCLOAK_DEFAULT_EXCLUDED = ImmutableList.of("uma_authorization", "offline_access");
}
