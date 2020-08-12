package com.company.doc_lift.repos;

import com.company.doc_lift.domian.Document;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface DocumentRepo extends JpaRepository<Document,Long> {

    Document findFirstByDocid(int docid);

    Iterable<Document> findAllByDocid(int d);

    Iterable<Document> findAllByNumberLike(String number);

}
