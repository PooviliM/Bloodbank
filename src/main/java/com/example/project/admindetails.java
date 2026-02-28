package com.example.project;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class admindetails {
    @Id
    private long id;
    private String adminname;
    private String adminpass;

    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getAdminname() {
        return adminname;
    }
    public void setAdminname(String adminname) {
        this.adminname = adminname;
    }
    public String getAdminpass() {
        return adminpass;
    }
    public void setAdminpass(String adminpass) {
        this.adminpass = adminpass;
    }

    
}
