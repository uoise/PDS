package com.example.dbhw.controller;

import com.example.dbhw.model.DTO.DesignDTO;
import com.example.dbhw.service.DesignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DesignRESTController {

    @Autowired
    private DesignService designService;

    @PostMapping("/design")
    public ResponseEntity<String> create(@RequestBody DesignDTO designDTO){
        designService.create(designDTO);
        return new ResponseEntity<>("디자인 생성 성공", HttpStatus.NO_CONTENT);
    }

    @PutMapping("/design/{id}")
    public ResponseEntity<String> update(@RequestBody DesignDTO designDTO, @PathVariable int id){
        designService.update(id, designDTO);
        return new ResponseEntity<>("디자인 수정 성공", HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/design/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        designService.delete(id);
        return new ResponseEntity<>("디자인 삭제 성공", HttpStatus.NO_CONTENT);
    }

}
