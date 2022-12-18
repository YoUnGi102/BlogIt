package com.gres.tomas.businesstier.repositories;

import com.gres.tomas.businesstier.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmailIs(String email);
    User findByUsername(String usernme);

}
