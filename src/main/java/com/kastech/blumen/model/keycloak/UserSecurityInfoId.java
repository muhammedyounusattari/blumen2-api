package com.kastech.blumen.model.keycloak;

import java.io.Serializable;
import java.util.Objects;


public class UserSecurityInfoId implements Serializable {

	private String id;
    private String orgId;

    public String getId() {
        return id;
    }

    public String getOrgId() {
        return orgId;
    }

    public UserSecurityInfoId() {}

    public UserSecurityInfoId(String id, String orgId){
        this.id = id;
        this.orgId = orgId;
    }

    @Override
    public String toString() {
        return "UserSecurityInformation{" +
                "id=" + id +
                "orgId=" + orgId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserSecurityInfoId)) return false;
        UserSecurityInfoId that = (UserSecurityInfoId) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getOrgId(), that.getOrgId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getOrgId());
    }
}
