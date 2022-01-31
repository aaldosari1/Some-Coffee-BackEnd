package com.example.Some_Coffee_BackEnd.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public User findByUserName(String UserName);
    public User findByEmail(String email);
}
