package com.greatersum.rental;

public class Movie {
    private final String id;
    private final String title;
    private final Code code;

    public Movie(String id, String title, Code code) {
        this.id = id;
        this.title = title;
        this.code = code;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Code getCode() {
        return code;
    }

    public enum Code {
        REGULAR,
        CHILDRENS,
        NEW
    }
}
