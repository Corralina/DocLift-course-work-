package com.company.doc_lift.repos;

import com.company.doc_lift.domian.Collegues;
import com.company.doc_lift.domian.Document;
import com.company.doc_lift.domian.Register;
import com.company.doc_lift.domian.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterRepo extends JpaRepository<Register, Long> {

    Iterable<Register> findAllByAuthor(User author);

    Iterable<Register> findAllByDocIn(Iterable<Document> documents);

    Iterable<Register> findAllByCollIn(Iterable<Collegues> colls);

}
