package com.example.dbhw.controller;

import com.example.dbhw.model.Design;
import com.example.dbhw.service.DesignService;
import com.example.dbhw.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DesignController {

    @Autowired
    private DesignService designService;
    @Autowired
    private ProductService productService;

    @GetMapping("/design")
    public String home(Model model){
        model.addAttribute("Designs", designService.getAll());
        System.out.println(model);
        return "design/home";
    }

    @GetMapping("/design/{targetId}/insertform")
    public String insertForm(Model model, @PathVariable int targetId){
        model.addAttribute("targetProduct", productService.getById(targetId));
        System.out.println(model);
        return "design/insertForm";
    }

    @GetMapping("/design/updateform/{id}")
    public String updateForm(@PathVariable int id, Model model){
        model.addAttribute("design_info", designService.getById(id));
        model.addAttribute("design", designService.getDesignWithProduct(id));
        System.out.println(model);
        return "design/updateForm";
    }

    @GetMapping("/design/{id}")
    public String detail(Model model, @PathVariable int id){
        Design design = designService.getById(id);
        model.addAttribute("targetProduct", productService.getById(design.getTargetProduct().getId()));
        model.addAttribute("slaveProduct", designService.getDesignWithProduct(id));
        System.out.println(model);
        return "design/detail";
    }

}
