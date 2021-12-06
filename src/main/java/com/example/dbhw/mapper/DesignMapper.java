package com.example.dbhw.mapper;


import com.example.dbhw.model.DTO.SlaveDTO;
import com.example.dbhw.model.Design;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DesignMapper extends MyMapper<Design> {
    void create(Design design);

    void update(Design design);

    void delete(int designId);

    Design getById(int id);

    Design getByTargetAndSlaveId(int targetId, int slaveId);

    List<Design> getAll();

    List<Design> getDesignListByTargetId(int targetId);

    void deleteDesignsByTargetId(int targetId);

    List<SlaveDTO> getSlaveProducts(int productId);

    SlaveDTO getSlaveProduct(int productId);
}
