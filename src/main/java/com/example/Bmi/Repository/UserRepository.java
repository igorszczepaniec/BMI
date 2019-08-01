package com.example.Bmi.Repository;

import com.example.Bmi.Model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

}
