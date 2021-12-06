package com.example.dbhw.service;

import com.example.dbhw.mapper.CompanyMapper;
import com.example.dbhw.model.Company;
import com.example.dbhw.model.DTO.CompanyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyMapper companyMapper;

    @Transactional
    public void create(CompanyDTO companyDTO) {
        Company company = new Company();
        company.DTOtoEntity(companyDTO);
        companyMapper.create(company);
    }

    @Transactional
    public void update(String id, CompanyDTO companyDTO) {
        Company company = companyMapper.getById(id);
        if(company == null) throw new IllegalArgumentException("Company Update Fail: Company doesnt exist.");
        company.DTOtoEntity(companyDTO);
        companyMapper.update(company);
    }

    @Transactional
    public void delete(String id) {
        companyMapper.delete(id);
    }

    @Transactional(readOnly = true)
    public List<Company> getAll() {
        return companyMapper.getAll();
    }

    @Transactional(readOnly = true)
    public List<Company> getListByName(String name) {
        return companyMapper.getByName(name);
    }

    @Transactional(readOnly = true)
    public Company getById(String id) {
        return companyMapper.getById(id);
    }
}
