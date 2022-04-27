package com.kastech.blumen.utility;

public final class KeycloakAdminClientConfig {

    public String getServerUrl() {
		return serverUrl;
	}
	
	public String getRealm() {
		return realm;
	}
	
	public String getClientId() {
		return clientId;
	}
	
	public String getClientSecret() {
		return clientSecret;
	}
	
	private final String serverUrl;
    private final String realm;
    private final String clientId;
    private final String clientSecret;
    
    public KeycloakAdminClientConfig(Builder builder) {
    	
    	this.serverUrl = builder.serverUrl;
    	this.clientId = builder.clientId;
    	this.realm = builder.realm;
    	this.clientSecret = builder.clientSecret;
    }
    
    public static class Builder {
    	
    	private String serverUrl;
        private String realm;
        private String clientId;
        private String clientSecret;
        
        public KeycloakAdminClientConfig build() {
        	return new KeycloakAdminClientConfig(this);
        }
        
        private Builder() {}
        
        public Builder serverUrl(String serverUrl) {
        	this.serverUrl = serverUrl;
        	return this;
        }
        
        public Builder realm(String realm) {
        	this.realm = realm;
        	return this;
        }
        
        public Builder clientId(String clientId) {
        	this.clientId = clientId;
        	return this;
        }
        
        public Builder clientSecret(String clientSecret) {
        	this.clientSecret = clientSecret;
        	return this;
        }
        
        public static Builder newInstance()
        {
            return new Builder();
        }
    }
}
