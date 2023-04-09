package com.software.basic.solution.debug.scenario;

public class DocumentVO {
    private String docId; // 문서 아이디
    private String title; // 문서 제목
    private String body; // 문서 내용
    private String author; // 문서 작성자

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
