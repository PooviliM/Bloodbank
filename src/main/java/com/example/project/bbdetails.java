package com.example.project;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class bbdetails {

    @Id
    private long id;
    private String bankname;
    private String address;
    private String contact;
    private String password;
    
    public void setId(long id) {
        this.id = id;
    }
    public void setBankname(String bankname) {
        this.bankname = bankname;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public long getId() {
        return id;
    }
    public String getBankname() {
        return bankname;
    }
    public String getAddress() {
        return address;
    }
    public String getContact() {
        return contact;
    }
    public String getPassword() {
        return password;
    }
    
    
    
}
