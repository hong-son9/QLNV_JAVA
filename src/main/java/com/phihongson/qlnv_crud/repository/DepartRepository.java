package com.phihongson.qlnv_crud.repository;

import com.phihongson.qlnv_crud.models.Departs;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface DepartRepository extends CrudRepository<Departs, String> {
}
