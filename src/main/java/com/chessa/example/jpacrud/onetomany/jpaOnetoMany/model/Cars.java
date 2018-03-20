package com.chessa.example.jpacrud.onetomany.jpaOnetoMany.model;


import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="cars")
@EntityListeners(AuditingEntityListener.class)
public class Cars implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id", unique = true, nullable = false)
    private Long car_id;

//    @NotBlank
    private String name;

//    @NotBlank
    private String brand;

//    @NotBlank
    private  String color;

//    @NotBlank
    private String vehicle_number;

    private Long owners_id;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Owners.class)
    @JoinColumn(name = "owners_id", insertable = false, updatable = false, nullable = false)
//    private Owners owners;
    private Owners owners;

//    @Column(nullable = false, updatable = false)
//    @Temporal(TemporalType.TIMESTAMP)
//    @CreationTimestamp
//    private Date createdAt;
//
//    @Column(nullable = false)
//    @Temporal(TemporalType.TIMESTAMP)
//    @UpdateTimestamp
//    private Date updatedAt;

    //getter and setters




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getVehicle_number() {
        return vehicle_number;
    }

    public void setVehicle_number(String vehicle_number) {
        this.vehicle_number = vehicle_number;
    }

    public Long getOwners_id() {
        return owners_id;
    }

    public void setOwners_id(Long owners_id) {
        this.owners_id = owners_id;
    }



    public Long getCar_id() {
        return car_id;
    }

    public void setCar_id(Long car_id) {
        this.car_id = car_id;
    }


}
