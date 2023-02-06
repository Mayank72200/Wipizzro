package com.Wipro.User.Repository;


import com.Wipro.User.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {

    //Implement custom methods or queries


}
