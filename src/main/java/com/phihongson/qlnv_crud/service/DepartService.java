package com.phihongson.qlnv_crud.service;

import com.phihongson.qlnv_crud.models.Departs;

import java.util.List;
import java.util.Optional;

public interface DepartService {
    Departs save(Departs entity);

    List<Departs> saveAll(List<Departs> entities);

    Optional<Departs> findById(String s);

    boolean existsById(String s);

    List<Departs> findAll();

    List<Departs> findAllById(List<String> ids);

    long count();

    void deleteById(String id);

    void delete(Departs entity);

    void deleteAllById(Iterable<? extends String> strings);

    void deleteAll(List<Departs> entities);

    void deleteAll();
}
