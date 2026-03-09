package com.example.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class control {

    @Autowired
    private Adminrepostory adminrepostory;

    @Autowired
    private productrepostry Productrepostry;

    @Autowired
    private bbrepostory bbrepostory;

    @GetMapping("//homepage")
    public String gethome() {
        return "home";
    }

    @GetMapping("//adminlog")
    public String getadminlogin() {        
        return "adminlogin";
    }
    @GetMapping("//adminsign")
    public String getadminsignup() {        
        return "adminsignup";
    } 

    @PostMapping("//login")
    public String postMethodName(@RequestParam("id") Long id,@RequestParam("name") String name,@RequestParam("age") String age,@RequestParam("contact") String contact,@RequestParam("email") String email,@RequestParam("blood") String blood,@RequestParam("gender") String gender,@RequestParam("address") String address,Model model) {
        
        information  info=new information();
        info.setId(id);
        info.setName(name);
        info.setAge(age);
        info.setContact(contact);
        info.setEmail(email);
        info.setBlood(blood);
        info.setGender(gender);
        info.setAddress(address);

        Productrepostry.save(info);
        model.addAttribute("message", "Added");
        return "donor";
    }

    @GetMapping("//adminpage")
    public String getadmin() {
        return "admin";
    }
    
    @GetMapping("//donorpage")
    public String getdonor() {
        return "donor";
    }
    
    @GetMapping("//bloodbankpage")
    public String getbloodbank() {
        return "bloodbank";
    }

    @GetMapping("//recipientpage")
    public String recipient() {
        return "recipient";
    }


    @PostMapping("//admininfo")
    public String postadmindetail(@RequestParam("id") Long id,@RequestParam("adminname") String adminname,@RequestParam("adminpass") String adminpass,Model model) {

        admindetails detail=new admindetails();
        detail.setId(id);
        detail.setAdminname(adminname);
        detail.setAdminpass(adminpass);

        adminrepostory.save(detail);
        model.addAttribute("message", "Added"); 
        return "adminlogin";
    }

    

    @PostMapping("//adminsign")
    public String postMethodName(@RequestParam ("adminname") String adminname,@RequestParam ("adminpass") String adminpass ,Model model) {
        
    admindetails admin = adminrepostory.findByAdminnameAndAdminpass(adminname, adminpass);

        if (admin != null) {
        model.addAttribute("information", Productrepostry.findAll());
        model.addAttribute("adminname",admin.getAdminname());
        model.addAttribute("bbdetails",bbrepostory.findAll());
        return "viewdonor";
        } else {
            model.addAttribute("message", "Invalid username or password");
            
            return "adminsignup";
        }
    }

    @PostMapping("//bblog")
    public String postMethodbank(@RequestParam ("id") Long id,@RequestParam ("bankname") String bankname,@RequestParam ("address") String address,@RequestParam ("contact") String contact, @RequestParam ("password") String password,Model model) {

        bbdetails bbdetail=new bbdetails();
        bbdetail.setId(id);
        bbdetail.setBankname(bankname);
        bbdetail.setAddress(address);
        bbdetail.setContact(contact);
        bbdetail.setPassword(password);
        
        bbrepostory.save(bbdetail);
        model.addAttribute("message", "Added");

        return "bloodbank";
    }
    
}
