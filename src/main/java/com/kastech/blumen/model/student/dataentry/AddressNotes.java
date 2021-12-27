package com.kastech.blumen.model.student.dataentry;

import javax.persistence.*;

@Entity
@Table(name = "address_notes", schema = "blumen2")
public class AddressNotes {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="address_notes_list_seq_gen")
    @SequenceGenerator(name="address_notes_list_seq_gen", sequenceName="ADDRESS_NOTES_LIST_SEQ")
    private Long id;
    private String address;
    private String city;
    private String state;
    private String zipcode;
    private String email;
    private String phone1;
    private String phone2;
    private String website;
    private String notes;

    public AddressNotes() {
    }

    public AddressNotes(Long id, String address, String city, String state, String zipcode, String email, String phone1, String phone2, String website, String notes) {
        this.id = id;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.email = email;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.website = website;
        this.notes = notes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "AddressNotes{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", email='" + email + '\'' +
                ", phone1='" + phone1 + '\'' +
                ", phone2='" + phone2 + '\'' +
                ", website='" + website + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
