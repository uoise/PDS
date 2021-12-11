package com.example.dbhw.controller;

import com.example.dbhw.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/company")
    public String home(Model model){
        model.addAttribute("Companys", companyService.getAll());
        System.out.println(model);
        return "company/home";
    }

    @GetMapping("/company/insertform")
    public String insertForm(){
        return "company/insertForm";
    }

    @GetMapping("/company/{id}/updateForm")
    public String updateForm(@PathVariable String id, Model model){
        model.addAttribute("Company", companyService.getById(id));
        return "company/updateForm";
    }

}
