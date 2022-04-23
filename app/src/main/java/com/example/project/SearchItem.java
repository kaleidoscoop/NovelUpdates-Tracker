package com.example.project;

import android.widget.ImageView;

public class SearchItem {
    private String novelName;
    private String novelAuthor;

    public SearchItem(String novelName, String novelAuthor) {
        this.novelName = novelName;
        this.novelAuthor = novelAuthor;
    }

    public String getNovelName() {
        return novelName;
    }

    public String getNovelAuthor() {
        return novelAuthor;
    }
}
