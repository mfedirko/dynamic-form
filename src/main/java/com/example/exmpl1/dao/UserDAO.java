package com.example.exmpl1.dao;

import com.example.exmpl1.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDAO extends CrudRepository<User,Long>{
}
