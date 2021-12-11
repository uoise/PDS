package com.example.dbhw.service;

import com.example.dbhw.mapper.DesignMapper;
import com.example.dbhw.mapper.ProductMapper;
import com.example.dbhw.model.DTO.SlaveDTO;
import com.example.dbhw.model.Design;
import com.example.dbhw.model.MethodType;
import com.example.dbhw.model.Product;
import com.example.dbhw.model.DTO.DesignDTO;
import com.example.dbhw.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DesignService implements MyService<DesignDTO, Design> {

    @Autowired
    private DesignMapper designMapper;

    @Autowired
    private ProductMapper productMapper;

    public boolean isValid(DesignDTO designDTO, MethodType methodType) {

        Product target = productMapper.getById(designDTO.getTargetProduct());
        if (target == null) {
            System.out.println("Design Fail: Target doesnt exist");
            return false;
        }

        Product slave = productMapper.getById(designDTO.getSlaveProduct());
        if (slave == null) {
            System.out.println("Design Fail: Slave doesnt exist");
            return false;
        }

        if (designMapper.getByTargetAndSlaveId(target.getId(), slave.getId()) != null && methodType==MethodType.Create) {
            System.out.println("Design Fail: Already Exist");
            return false;
        }

        if (designMapper.getByTargetAndSlaveId(slave.getId(), target.getId()) != null) {
            System.out.println("Design Fail: Reverse Exist");
            return false;
        }
        return true;
    }

    @Transactional
    public void create(User user, DesignDTO designDTO) {
        if (!isValid(designDTO, MethodType.Create)) throw new IllegalArgumentException("Design Create Fail");
        Design design = new Design();
        design.DTOtoEntity(designDTO);
        design.setCreateUser(user);
        System.out.println(design);
        designMapper.create(design);
    }

    @Transactional
    public void update(User user, int id, DesignDTO designDTO) {
        if (!isValid(designDTO, MethodType.Update)) throw new IllegalArgumentException("Design Update Fail");
        Design design = designMapper.getById(id);
        design.DTOtoEntity(designDTO);
        design.setCreateUser(user);
        System.out.println(design);
        designMapper.update(design);
    }

    @Transactional
    public void delete(int id) {
        designMapper.delete(id);
    }

    @Transactional(readOnly = true)
    public List<Design> getAll() {
        return designMapper.getAll();
    }

    @Transactional(readOnly = true)
    public Design getById(int id) {
        return designMapper.getById(id);
    }

    @Transactional(readOnly = true)
    public List<Design> getDesignsListByTargetId(int id) {
        return designMapper.getDesignListByTargetId(id);
    }

    @Transactional(readOnly = true)
    public SlaveDTO getDesignWithProduct(int id) {
        return designMapper.getSlaveProduct(id);
    }
}
