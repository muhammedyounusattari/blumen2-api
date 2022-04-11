//package com.kastech.blumen.model.users;
//
//import javax.persistence.*;
//import java.util.List;
//
//
//@Entity
//@Table(name = "roles" ,schema = "blumen2")
//public class UserRoles {
//    @Id
//    @GeneratedValue(strategy= GenerationType.IDENTITY, generator="user_roles_seq_gen")
//    @SequenceGenerator(name="user_roles_seq_gen", sequenceName="user_roles_SEQ")
//    private long userRoleId;
//
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinTable(
//            name =  "user_roles_mapping",
//            joinColumns = @JoinColumn(name = "UserRoleId"))
//    private List<UserPriviledges> userPriviledges;
//
//    public long getUserRoleId() {
//        return userRoleId;
//    }
//
//    public void setUserRoleId(long userRoleId) {
//        this.userRoleId = userRoleId;
//    }
//
//    public List<UserPriviledges> getUserPriviledges() {
//        return userPriviledges;
//    }
//
//    public void setUserPriviledges(List<UserPriviledges> userPriviledges) {
//        this.userPriviledges = userPriviledges;
//    }
//}
