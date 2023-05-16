package com.giridhar.androidapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.giridhar.androidapi.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
