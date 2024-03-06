package com.raffaelbrandao.demo.repositories;

import com.raffaelbrandao.demo.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    @Query("SELECT u FROM UserEntity u JOIN FETCH u.roles WHERE u.username = (:username)")
    public UserEntity findByUsername(@Param("username") String username);

    boolean existsByUsername(String username);
}
