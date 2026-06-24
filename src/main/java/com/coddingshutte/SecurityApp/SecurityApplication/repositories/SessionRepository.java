package com.coddingshutte.SecurityApp.SecurityApplication.repositories;

import com.coddingshutte.SecurityApp.SecurityApplication.entity.Session;
import com.coddingshutte.SecurityApp.SecurityApplication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SessionRepository extends JpaRepository<Session, Long> {
    List<Session> findByUser(User user);

    Optional<Session> findByRefreshToken(String refreshToken);
}
