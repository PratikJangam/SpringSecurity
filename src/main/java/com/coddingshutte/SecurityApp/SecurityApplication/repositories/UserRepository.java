package com.coddingshutte.SecurityApp.SecurityApplication.repositories;

import com.coddingshutte.SecurityApp.SecurityApplication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String userName);
}
