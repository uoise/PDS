package com.example.dbhw.controller;

import com.example.dbhw.service.CompanyService;
import com.example.dbhw.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CompanyService companyService;

    @GetMapping(value={"/product", ""})
    public String home(Model model){
        model.addAttribute("Products", productService.getAll());
        System.out.println(model);
        return "product/home";
    }

    @GetMapping("/product/insertform")
    public String insertForm(Model model){
        model.addAttribute("Companys", companyService.getAll());
        System.out.println(model);
        return "product/insertForm";
    }

    @GetMapping("/product/updateform/{id}")
    public String updateForm(@PathVariable int id, Model model){
        model.addAttribute("Product", productService.getById(id));
        model.addAttribute("Companys", companyService.getAll());
        System.out.println(model);
        return "product/updateForm";
    }

    @GetMapping("/product/{id}")
    public String detail(@PathVariable int id, Model model){
        model.addAttribute("Detail", productService.getSlaveProducts(id));
        model.addAttribute("Products", productService.getAll());
        System.out.println(model);
        return "product/detail";
    }
}
