package com.kastech.blumen.model.users;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "priviledges" ,schema = "blumen2")
public class Priviledges {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY, generator="priviledges_seq_gen")
    @SequenceGenerator(name="priviledges_seq_gen", sequenceName="priviledges_SEQ")
    private long Id;
    private String PriviledgeName;
    private long PriviledgesParentId;

    @OneToMany(mappedBy = "PriviledgesParentId")
    private List<Priviledges> priviledgesList = new ArrayList<Priviledges>();

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public List<Priviledges> getPriviledgesList() {
        return priviledgesList;
    }

    public void setPriviledgesList(List<Priviledges> priviledgesList) {
        this.priviledgesList = priviledgesList;
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

}