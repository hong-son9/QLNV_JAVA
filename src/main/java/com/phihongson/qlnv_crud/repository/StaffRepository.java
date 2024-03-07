package com.phihongson.qlnv_crud.repository;

import com.phihongson.qlnv_crud.models.Staffs;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends CrudRepository<Staffs, String> {
}
