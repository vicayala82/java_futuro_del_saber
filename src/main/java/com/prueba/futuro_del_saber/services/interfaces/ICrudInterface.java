package com.prueba.futuro_del_saber.services.interfaces;

import java.util.List;

public interface ICrudInterface <DTOType ,ID>{
    DTOType create(DTOType dto);
    DTOType get(ID id);
    List<DTOType> getAll();
    DTOType update(DTOType dto, ID id);
    void delete(ID id);
}
