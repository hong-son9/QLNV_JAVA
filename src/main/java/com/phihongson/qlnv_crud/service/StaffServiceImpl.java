package com.phihongson.qlnv_crud.service;

import com.phihongson.qlnv_crud.models.Staffs;
import com.phihongson.qlnv_crud.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffServiceImpl implements  StaffService{
    @Autowired
    StaffRepository staffRepository;

    @Override
    public Staffs save(Staffs entity) {
        return staffRepository.save(entity);
    }

    @Override
    public List<Staffs> saveAll(List<Staffs> entities) {
        return (List<Staffs>)staffRepository.saveAll(entities);
    }

    @Override
    public Optional<Staffs> findById(String s) {
        return staffRepository.findById(s);
    }

    @Override
    public boolean existsById(String s) {
        return staffRepository.existsById(s);
    }

    @Override
    public Iterable<Staffs> findAll() {
        return staffRepository.findAll();
    }

    @Override
    public List<Staffs> findAllById(List<String> ids) {
        return (List<Staffs>)staffRepository.findAllById(ids);
    }

    @Override
    public long count() {
        return staffRepository.count();
    }

    @Override
    public void deleteById(String s) {
        staffRepository.deleteById(s);
    }

    @Override
    public void delete(Staffs entity) {
        staffRepository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends String> strings) {
        staffRepository.deleteAllById(strings);
    }

    @Override
    public void deleteAll(List<Staffs> entities) {
        staffRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        staffRepository.deleteAll();
    }
}
