package com.example.dbhw.controller;

import com.example.dbhw.config.auth.PrincipalDetail;
import com.example.dbhw.model.DTO.ProductDTO;
import com.example.dbhw.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductRESTController {

    @Autowired
    private ProductService productService;

    @PostMapping("/product")
    public ResponseEntity<String> create(@RequestBody ProductDTO productDTO, @AuthenticationPrincipal PrincipalDetail principalDetail) {
        productService.create(principalDetail.getUser(), productDTO);
        return new ResponseEntity<>("제품 생성 성공", HttpStatus.NO_CONTENT);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<String> update(@RequestBody ProductDTO productDTO, @PathVariable int id, @AuthenticationPrincipal PrincipalDetail principalDetail) {
        productService.update(principalDetail.getUser() ,id, productDTO);
        return new ResponseEntity<>("제품 수정 성공", HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        productService.delete(id);
        return new ResponseEntity<>("제품 삭제 성공", HttpStatus.NO_CONTENT);
    }

}
