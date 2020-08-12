package com.company.doc_lift.domian;


import javax.persistence.*;
import javax.xml.crypto.Data;

import java.util.Set;

import static javax.persistence.GenerationType.*;

@Entity
@Table(name = "reg_doc")
public class Register {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String comment;
    private String start;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "autor_id")
    public User author;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "doc_id")
    public Document doc;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "reg_coll",
            joinColumns = @JoinColumn(name = "register_id"),
            inverseJoinColumns = @JoinColumn(name = "collegue_id"))
    public Set<Collegues> coll;


    public Register(){}
    public Register(Long id, String comment, String start, User author, Document doc, Set<Collegues> coll){
        this.id = id;
        this.comment = comment;
        this.start = start;
        this.author = author;
        this.doc = doc;
        this.coll = coll;
    }


    public Document getDoc() {
        return doc;
    }

    public void setDoc(Document doc) {
        this.doc = doc;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public Set<Collegues> getColl() {
        return coll;
    }

    public void setColl(Set<Collegues> coll) {
        this.coll = coll;
    }
}
