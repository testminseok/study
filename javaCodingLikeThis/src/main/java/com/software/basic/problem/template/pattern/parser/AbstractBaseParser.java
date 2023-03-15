package com.software.basic.problem.template.pattern.parser;

import com.software.basic.problem.template.pattern.vo.NewsVO;

abstract class AbstractBaseParser {
    private NewsVO newsVO;
    private String path;
    private String news;

    public AbstractBaseParser(String path) {
        this.path = path;
    }

    /*
    * 프로세스의 진행을 담당하는 곹옹 메소드
    * final 예약어로 메소드 재정의를 금지한다.
    * */
    public final void parse() {
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

    private void storeNews() {
        System.out.println(this.newsVO);
    }

    private void makeNewsVO(String title, String body, String author, String date, String email) {
        this.newsVO = new NewsVO(title, body, author, date, email);
    }

    /*
    * 각 상세 구현 클래스에서 구형할 구조를 추상화 메소드로 정의한다. 
    * */
    protected abstract String getEmail();

    protected abstract String getDate();

    protected abstract String getAuthor();

    protected abstract String getBody();

    protected abstract String getTitle();

    protected abstract String getNews();

    private boolean isEnable() {
        return true;
    }
}
