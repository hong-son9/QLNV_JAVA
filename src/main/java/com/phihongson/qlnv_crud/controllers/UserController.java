package com.phihongson.qlnv_crud.controllers;


import com.phihongson.qlnv_crud.models.User;
import com.phihongson.qlnv_crud.models.UserDAO;
import com.phihongson.qlnv_crud.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    User _userBean;
    @GetMapping("/")
    public String addOrEdit(ModelMap model){
        User u = new User();
//        u.setUsername("Son");
        model.addAttribute("USER", u);
        model.addAttribute("ACTION", "saveOrUpdate");
        return "register-user";
    }
    @PostMapping("/saveOrUpdate")
    public String saveOrUpdate(ModelMap model, @ModelAttribute("USER") User user){
//        UserDAO dao = new UserDAO();
//        dao.save(user);
    userService.save(user);
        return "register-user";
    }
    @GetMapping("/list")
    public String list(ModelMap model, HttpSession session){
//        UserDAO dao = new UserDAO();
        model.addAttribute("USERS", userService.findAll());
        if(session.getAttribute("USERNAME")!= null){
            model.addAttribute("USERNAME", userService.findAll());
            return "view-user";
        }
//        userService.findAll();
        return "login";
    }
    @RequestMapping("/edit/{username}")
    public String edit(ModelMap model, @PathVariable(name = "username")String username){
//        UserDAO dao =new UserDAO();
//        User u = dao.findByUsername(username);
        Optional<User> u = userService.findById(username);
        if(u.isPresent()){
            model.addAttribute("USER", u.get());
        }else{
            model.addAttribute("USER", new User());
        }
        model.addAttribute("ACTION", "/saveOrUpdate");
        return "register-user";
    }
    @RequestMapping("/delete/{username}")
    public String delete(ModelMap model, @PathVariable(name = "username")String username){
//        UserDAO dao =new UserDAO();
//        dao.delete(username);
        userService.deleteById(username);
        model.addAttribute("USER", userService.findAll());
        return "view-user";
    }
//    -----------------------------
    @RequestMapping("/login")
    public String showLogin(){
        return "login";
    }
    @PostMapping("checklogin")
    public String checkLogin(ModelMap model, @RequestParam("username")String username, @RequestParam("password") String password
    , HttpSession session){
//        if(_userBean.getUsername().equals(username) && _userBean.getPassword().equals(password)){
//            return "view-user";
//        }else{
//
//        }

        if(userService.checkLogin(username, password)){
            System.out.println("Longin thanh cong");
            session.setAttribute("USERNAME", username);
            model.addAttribute("USERS", userService.findAll());
//        userService.findAll();
            return "view-user";
        }
        else{
            System.out.println("Login that bai");
            model.addAttribute("ERROR", "Username and password not exist");
//        userService.findAll();
        }
        return "login";
    }
    @GetMapping("logout")
    public String logout(HttpSession session){
        session.removeAttribute("USERNAME");
        return "redirect:/login";
    }
}
