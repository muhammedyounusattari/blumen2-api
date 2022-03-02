package com.kastech.blumen.model.users;

import java.util.List;

public class PriviledgeResponse {
    private long priviledgesId;
    private String priviledgeName;
    private long PriviledgesParentId;
    private AccessType isAccess;
    private List<PriviledgeResponse> priviledgesList;

    public long getPriviledgesId() {
        return priviledgesId;
    }

    public void setPriviledgesId(long priviledgesId) {
        this.priviledgesId = priviledgesId;
    }

    public String getPriviledgeName() {
        return priviledgeName;
    }

    public void setPriviledgeName(String priviledgeName) {
        this.priviledgeName = priviledgeName;
    }

    public long getPriviledgesParentId() {
        return PriviledgesParentId;
    }

    public void setPriviledgesParentId(long priviledgesParentId) {
        PriviledgesParentId = priviledgesParentId;
    }

    public AccessType getIsAccess() {
        return isAccess;
    }

    public void setIsAccess(AccessType isAccess) {
        this.isAccess = isAccess;
    }

    public List<PriviledgeResponse> getPriviledgesList() {
        return priviledgesList;
    }

    public void setPriviledgesList(List<PriviledgeResponse> priviledgesList) {
        this.priviledgesList = priviledgesList;
    }
}
