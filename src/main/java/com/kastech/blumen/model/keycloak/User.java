package com.kastech.blumen.model.keycloak;

import java.util.List;

public class User {
    String id;
    String username;
    String firstName;
    String lastName;
    String email;
    boolean emailVerified;
    boolean enabled;
    List<Credentials> credentials;

    public String getId() {
        return id;
    }
    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public boolean isEmailVerified() {
        return emailVerified;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public List<Credentials> getCredentials() {
        return credentials;
    }

    public User() {}

    public User(UserBuilder userBuilder) {
        this.id = userBuilder.id;
        this.username = userBuilder.username;
        this.firstName = userBuilder.firstName;
        this.lastName = userBuilder.lastName;
        this.email = userBuilder.email;
        this.emailVerified = userBuilder.emailVerified;
        this.enabled = userBuilder.enabled;
        this.credentials = userBuilder.credentials;
    }

    public static class UserBuilder {
        String id;
        String username;
        String firstName;
        String lastName;
        String email;
        boolean emailVerified;
        boolean enabled;
        List<Credentials> credentials;

        public UserBuilder() {
        }

        public UserBuilder id(String id) {
            this.id = id;
            return this;
        }

        public UserBuilder username(String username) {
            this.username = username;
            return this;
        }
        public UserBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }
        public UserBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }
        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }
        public UserBuilder enabled(boolean enabled) {
            this.enabled = enabled;
            return this;
        }
        public UserBuilder emailVerified(boolean emailVerified) {
            this.emailVerified = emailVerified;
            return this;
        }

        public UserBuilder credentials(List<Credentials> credentials) {
            this.credentials = credentials;
            return this;
        }

        public User buildUser() {
            return new User(this);
        }
    }
}
