package com.digitaldiaries.repository;

import com.digitaldiaries.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

    public Users findByUsername(String username);
}
