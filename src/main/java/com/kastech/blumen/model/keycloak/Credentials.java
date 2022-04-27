package com.kastech.blumen.model.keycloak;

public class Credentials {
    String type;
    String value;
    boolean temporary;

    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    public boolean isTemporary() {
        return temporary;
    }


    public Credentials(CredentialsBuilder credentialsBuilder) {
        this.type = credentialsBuilder.type;
        this.value = credentialsBuilder.value;
        this.temporary = credentialsBuilder.temporary;
    }

    public static class CredentialsBuilder {
        String type;
        String value;
        boolean temporary;
        public CredentialsBuilder() {}

        public CredentialsBuilder type(String type) {
            this.type = type;
            return this;
        }

        public CredentialsBuilder value(String value) {
            this.value = value;
            return this;
        }

        public CredentialsBuilder temporary(boolean temporary) {
            this.temporary = temporary;
            return this;
        }

        public Credentials buildCredentials() {
            return new Credentials(this);
        }

    }
}
