package com.software.basic.problem.template.pattern.parser;

public class ZdNewsParser extends BaseNewsParser {

    public ZdNewsParser(String path) {
        super(path);
    }

    public void parse() {
        String title;
        String body;
        String author;
        String date;
        String email;
        String news;
        if (isEnable()) {
            news = getNews();
            title = getTitle();
            body = getBody();
            author = getAuthor();
            date = getDate();
            email = getEmail();
            makeNewsVO(title, body, author, date, email);
            storeNews();
        }
    }

    private String getEmail() {
        return null;
    }

    private String getDate() {
        return null;
    }

    private String getAuthor() {
        return null;
    }

    private String getBody() {
        return null;
    }

    private String getTitle() {
        return null;
    }
}
