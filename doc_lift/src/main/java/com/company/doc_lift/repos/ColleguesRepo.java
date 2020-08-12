package com.company.doc_lift.repos;

import com.company.doc_lift.domian.Collegues;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;

public interface ColleguesRepo  extends JpaRepository<Collegues,Long> {
    Set<Collegues> findAllByIdIsIn(Long[] id);


    Collegues findFirstById(Long id);

    Iterable<Collegues> findAllByNameLike(String name);
}
