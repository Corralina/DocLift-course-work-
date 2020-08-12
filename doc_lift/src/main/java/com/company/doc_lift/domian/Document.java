package com.company.doc_lift.domian;


import javax.persistence.*;

@Entity
@Table(name = "doc_attached")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String data;
    private String number;
    private String img;
    private int docid;
    private int regist;


    public Document(){}
    public Document(Long id, String name, String data, String number, String img, int docid, int regist){
        this.id = id;
        this.name = name;
        this.data = data;
        this.number = number;
        this.img = img;
        this.docid = docid;
        this.regist = regist;

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getDocid() {
        return docid;
    }

    public void setDocid(int docid) {
        this.docid = docid;
    }

    public int getRegist() {
        return regist;
    }

    public void setRegist(int regist) {
        this.regist = regist;
    }
}
