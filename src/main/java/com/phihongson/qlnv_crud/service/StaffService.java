package com.phihongson.qlnv_crud.service;

import com.phihongson.qlnv_crud.models.Departs;
import com.phihongson.qlnv_crud.models.Staffs;

import java.util.List;
import java.util.Optional;

public interface StaffService {
    List<Departs> findAllDeparts();

    Staffs save(Staffs entity);

    List<Staffs> saveAll(List<Staffs> entities);

    Optional<Staffs> findById(String s);

    boolean existsById(String s);

    Iterable<Staffs> findAll();

    List<Staffs> findAllById(List<String> ids);

    long count();

    void deleteById(String s);

    void delete(Staffs entity);

    void deleteAllById(Iterable<? extends String> strings);

    void deleteAll(List<Staffs> entities);

    void deleteAll();
}
