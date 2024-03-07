package com.phihongson.qlnv_crud;

import com.phihongson.qlnv_crud.models.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.net.UnknownServiceException;

@SpringBootApplication
public class QlnvCrudApplication {

    public static void main(String[] args) {

        SpringApplication.run(QlnvCrudApplication.class, args);
    }
    @Bean(name="USER_BEAN")
    public User setUser(){
        User u = new User();
        u.setUsername("admin");
        u.setPassword("admin");
        return u;
    }
}
