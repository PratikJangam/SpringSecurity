package com.coddingshutte.SecurityApp.SecurityApplication.repositories;

import com.coddingshutte.SecurityApp.SecurityApplication.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {
}
