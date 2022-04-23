package com.example.project;

public class ListItem {
    private String listName;
    private String listAuthor;
    private int numRead;
    private int numChaps;
    private String currStatus;
    private int score;

    public ListItem(String listName, String listAuthor, int numRead, int numChaps, String currStatus, int score) {
        this.listName = listName;
        this.listAuthor = listAuthor;
        this.numRead = numRead;
        this.numChaps = numChaps;
        this.currStatus = currStatus;
        this.score = score;
    }

    public String getListName() {
        return listName;
    }

    public String getListAuthor() {
        return listAuthor;
    }

    public int getNumRead() {
        return numRead;
    }

    public int getNumChaps() {
        return numChaps;
    }

    public String getCurrStatus() {
        return currStatus;
    }

    public int getScore() {
        return score;
    }

    public void setNumRead(int read) {
        numRead = read;
    }

    public void setCurrStatus (String status) {
        currStatus = status;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
