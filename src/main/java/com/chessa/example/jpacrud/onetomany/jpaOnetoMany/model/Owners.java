package com.chessa.example.jpacrud.onetomany.jpaOnetoMany.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "owners")
//@EntityListeners(AuditingEntityListener.class)
public class Owners implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "owners_id", unique = true, nullable = false)
    private Long owners_id;

//    @NotBlank
    private String fullname;

//    @NotBlank
    private String address;

//    @NotBlank
    private  String identity_number;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "owners")
//    private Cars cars;
    private List<Cars> cars;

    //getter and setters


    public Long getOwners_id() {
        return owners_id;
    }

    public void setOwners_id(Long owners_id) {
        this.owners_id = owners_id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdentity_number() {
        return identity_number;
    }

    public void setIdentity_number(String identity_number) {
        this.identity_number = identity_number;
    }

    public List<Cars> getCars() {
        return cars;
    }

    public void setCars(List<Cars> cars) {
        this.cars = cars;
    }
}
