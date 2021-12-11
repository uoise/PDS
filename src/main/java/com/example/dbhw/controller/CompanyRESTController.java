package com.example.dbhw.controller;

import com.example.dbhw.model.DTO.CompanyDTO;
import com.example.dbhw.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CompanyRESTController {

    @Autowired
    private CompanyService companyService;

    @PostMapping("/company")
    public ResponseEntity<String> create(@RequestBody CompanyDTO companyDTO) {
        companyService.create(companyDTO);
        return new ResponseEntity<>("회사 생성 성공", HttpStatus.NO_CONTENT);
    }

    @PutMapping("/company/{id}")
    public ResponseEntity<String> update(@RequestBody CompanyDTO companyDTO, @PathVariable String id) {
        companyService.update(id, companyDTO);
        return new ResponseEntity<>("회사 수정 성공", HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/company")
    public ResponseEntity<String> delete(@PathVariable String id) {
        companyService.delete(id);
        return new ResponseEntity<>("회사 수정 성공", HttpStatus.NO_CONTENT);
    }

    @PostMapping("/company/valid/{id}")
    public ResponseEntity<Boolean> valid(@PathVariable String id) {
        if (companyService.getById(id) != null)
            return new ResponseEntity<>(true, HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(false, HttpStatus.NO_CONTENT);
    }
}
