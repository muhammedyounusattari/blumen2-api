package com.kastech.blumen.model.admin.home;

import javax.persistence.*;

@Entity
@Table(name = "org_subscription_type" ,schema = "blumen2")
public class OrgSubScriptionType {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String subscriptionType;
    private String description;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSubscriptionType() {
        return this.subscriptionType;
    }

    public void setSubscriptionType(String subscriptionType) {
        this.subscriptionType = subscriptionType;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescriptions(String description) {
        this.description = description;
    }
}
