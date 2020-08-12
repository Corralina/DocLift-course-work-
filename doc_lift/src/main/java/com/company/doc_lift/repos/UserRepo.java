package com.company.doc_lift.repos;

import com.company.doc_lift.domian.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
