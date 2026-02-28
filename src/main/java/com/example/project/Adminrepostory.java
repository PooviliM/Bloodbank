package com.example.project;

import org.springframework.data.jpa.repository.JpaRepository;


public interface  Adminrepostory extends JpaRepository<admindetails, Long>{
    admindetails findByAdminnameAndAdminpass(String adminname, String adminpass);

}
