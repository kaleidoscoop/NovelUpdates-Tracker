package com.example.project;

public class NovelData {

    private int ID;
    private String name;
    private String nameAlt;
    private String author;
    private String status;
    private String numChap;
    private String numSide;
    private String descrip;

    public NovelData(int ID, String name, String nameAlt, String author, String status, String numChap, String descrip) {
        this.ID = ID;
        this.name = name;
        this.nameAlt = nameAlt;
        this.author = author;
        this.status = status;
        this.numChap = numChap;
        this.descrip = descrip;
    }

    public NovelData(int ID, String name, String nameAlt, String author, String status, String numChap, String numSide, String descrip) {
        this.ID = ID;
        this.name = name;
        this.nameAlt = nameAlt;
        this.author = author;
        this.status = status;
        this.numChap = numChap;
        this.numSide = numSide;
        this.descrip = descrip;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getNameAlt() {
        return nameAlt;
    }

    public String getAuthor() {
        return author;
    }

    public String getStatus() {
        return status;
    }

    public String getNumChap() {
        return numChap;
    }

    public String getNumSide() {
        return numSide;
    }

    public String getDescrip() {
        return descrip;
    }
}
