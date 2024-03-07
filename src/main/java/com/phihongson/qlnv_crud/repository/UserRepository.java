package com.phihongson.qlnv_crud.repository;

import com.phihongson.qlnv_crud.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {

}
