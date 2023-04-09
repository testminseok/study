package com.software.basic.problem.debug.scenario;

public class DocumentController {

    /**
     * 문서를 생성하는 가상 메소드
     * */
    public boolean create(DocumentVO document) {
        // 전달된 문서가 null 이라면 문서를 생성할 수 없다.

        boolean isOkay = true;
        if(document == null) {
            isOkay = false;
        // docId 의 접두사가 DOC 가 아니면 문서가 아니다.
        } else if(!document.getDocId().startsWith("DOC")) {
            isOkay = false;
        // 문서의 제목은 null 일 수 없다.
        } else if(document.getTitle() == null) {
            isOkay = false;
        // 제목의 길이는 최대 20자다
        } else if(document.getTitle().length() > 20) {
            isOkay = false;
        }

        if (isOkay) {
            System.out.println("문서를 생성합니다.");
        } else {
            System.out.println("문서를 생성할 수 없습니다.");
        }

        return isOkay;
    }

    /**
     * 문서를 삭제하는 가상 메소드
     */
    public boolean delete(DocumentVO document) {
        // 문서 삭제 절차....
        return true;
    }

    /**
     * 문서를 수정하는 가상 메소드
     * */
    public boolean update(DocumentVO document) {
        // 문서 수정 절차....
        return true;
    }

    /**
     * 문서를 조회하는 가상 메소드
     * */
    public DocumentVO read(String docId) {
        if (docId == null) {
            return null;
        }

        // 문서 조회 절차....
        return new DocumentVO();
    }
}

