package com.phihongson.qlnv_crud.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "Departs")
public class Departs {
    @Id
    @Column(length = 10)
    private String id;
    @Column(length = 50)
    private String name;

    public Departs() {
    }
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "departs")
    private Set<Staffs> staffs;

    public Set<Staffs> getStaffs() {
        return staffs;
    }

    public void setStaffs(Set<Staffs> staffs) {
        this.staffs = staffs;
    }

    public Departs(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
