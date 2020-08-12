package com.company.doc_lift.domian;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Collegues {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int cid;
    private String name;
    private String department;
    private String email;
    private String domen;
    private boolean chief;

    public Collegues(){}
    public Collegues(Long id, int cic, String name, String department, String email, String domen, boolean chief){
        this.id = id;
        this.cid = cic;
        this.name = name;
        this.department = department;
        this.email = email;
        this.domen = domen;
        this.chief = chief;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDomen() {
        return domen;
    }

    public void setDomen(String domen) {
        this.domen = domen;
    }

    public boolean isChief() {
        return chief;
    }

    public void setChief(boolean chief) {
        this.chief = chief;
    }
}
