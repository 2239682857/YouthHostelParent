package com.example.user.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_role")
public class Role {

    @Id
    private String id;

    private String role;

    private String remarks;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
