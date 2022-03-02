package com.kastech.blumen.model.users;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "priviledges" ,schema = "blumen2")
public class Priviledges {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY, generator="priviledges_seq_gen")
    @SequenceGenerator(name="priviledges_seq_gen", sequenceName="priviledges_SEQ")
    private long PriviledgesId;
    private String PriviledgeName;
    private long PriviledgesParentId;
    private AccessType IsAccess;

    public long getPriviledgesId() {
        return PriviledgesId;
    }

    public void setPriviledgesId(long priviledgesId) {
        PriviledgesId = priviledgesId;
    }

    public String getPriviledgeName() {
        return PriviledgeName;
    }

    public void setPriviledgeName(String priviledgeName) {
        PriviledgeName = priviledgeName;
    }

    public long getPriviledgesParentId() {
        return PriviledgesParentId;
    }

    public void setPriviledgesParentId(long priviledgesParentId) {
        PriviledgesParentId = priviledgesParentId;
    }

    public AccessType getIsAccess() {
        return IsAccess;
    }

    public void setIsAccess(AccessType isAccess) {
        IsAccess = isAccess;
    }
}