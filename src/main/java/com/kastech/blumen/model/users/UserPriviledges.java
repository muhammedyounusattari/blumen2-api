package com.kastech.blumen.model.users;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "user_priviledges" ,schema = "blumen2")
public class UserPriviledges {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY, generator="user_priviledges_seq_gen")
    @SequenceGenerator(name="user_priviledges_seq_gen", sequenceName="user_priviledges_SEQ")
    private long UserPriviledgesId;
    private long UserRoleId;
    private long priviledgesId;
    private  AccessType IsAccess;

    public AccessType getIsAccess() {
        return IsAccess;
    }

    public void setIsAccess(AccessType isAccess) {
        IsAccess = isAccess;
    }

    public long getPriviledgesId() {
        return priviledgesId;
    }

    public void setPriviledgesId(long priviledgesId) {
        this.priviledgesId = priviledgesId;
    }

    public long getUserRoleId() {
        return UserRoleId;
    }

    public void setUserRoleId(long userRoleId) {
        UserRoleId = userRoleId;
    }

    public long getUserPriviledgesId() {
        return UserPriviledgesId;
    }

    public void setUserPriviledgesId(long userPriviledgesId) {
        this.UserPriviledgesId = UserPriviledgesId;
    }

}


