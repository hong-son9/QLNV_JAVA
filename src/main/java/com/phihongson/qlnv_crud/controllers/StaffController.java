package com.phihongson.qlnv_crud.controllers;

import com.phihongson.qlnv_crud.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/staffs")
public class StaffController {
    @Autowired
    StaffService staffService;
    @RequestMapping("/list")
    public String listStaff(ModelMap model){
        model.addAttribute("LIST_STAFF", staffService.findAll());
        return "view-staffs";
    }
}
