package com.phihongson.qlnv_crud.controllers;


import com.phihongson.qlnv_crud.models.Departs;
import com.phihongson.qlnv_crud.models.Staffs;
import com.phihongson.qlnv_crud.models.User;
import com.phihongson.qlnv_crud.service.DepartService;
import com.phihongson.qlnv_crud.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/staffs")
public class StaffController {
    @Autowired
    StaffService staffService;
    @Autowired
    DepartService departService;
    @RequestMapping("/list")
    public String listStaff(ModelMap model){
        model.addAttribute("LIST_STAFF", staffService.findAll());
        return "view-staffs";
    }
    @GetMapping("/")
    public String addOrEdit(ModelMap model){
        Staffs staff = new Staffs();
        model.addAttribute("STAFF", staff);
        model.addAttribute("ACTION", "/staffs/saveOrUpdate");
        return "staff";
    }
    @PostMapping("/saveOrUpdate")
    public String save(ModelMap model, @ModelAttribute("STAFF") Staffs staff){
        staffService.save(staff);
        return "staff";
    }
    @RequestMapping("/edit/{id}")
    public String edit(ModelMap model, @PathVariable(name = "id") String id){
        Optional<Staffs> s = staffService.findById(id);
        if(s.isPresent()){
            model.addAttribute("STAFF", s.get());
        }else{
            model.addAttribute("STAFF", new Staffs());
        }
        model.addAttribute("ACTION", "/staffs/saveOrUpdate");
        return "staff";
    }
    @RequestMapping("/delete/{id}")
    public String delete(ModelMap model, @PathVariable(name = "id")String id){
        staffService.deleteById(id);
        model.addAttribute("LIST_STAFF", staffService.findAll());
        return "view-staffs";
    }
    @ModelAttribute(name = "DEPARTS")
    public List<Departs> getAllDeparts(){
        return staffService.findAllDeparts();
    }
}
