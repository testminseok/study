package com.software.basic.problem.template.pattern;

/**
 * 9-4 복잡한 switch 문과 템플릿 메소드 패턴
 * - SwitchDensity : switch case 절이 길고 복잡해 질떄 수정을 권고한다.
 *                   case 가 늘어난다는 것은 새 메소드로 이동하고나 하위 클래스를 만드는것을 고려해야한다.
 */
public class SwitchDensityExample {

    public static final int NONE = -1;
    public static final int ETNEWS = 0;
    public static final int ZDNET = 1;
    public static final int NEWS_COM1 = 2;
    public static final int NEWS_COM2 = 3;
    public static final int NEWS_COM3 = 4;

    public static void main(String[] args) {
        int type = args != null ? Integer.parseInt(args[0]) : NONE;
        String path = args != null && args.length == 2 ? args[1] : null;

        SwitchDensityExample example = new SwitchDensityExample();
        example.getNewsData(type, path);
    }

    private void getNewsData(int type, String path) {
        NewsVO newsVO;
        String title;
        String body;
        String author;
        String date;
        String email;
        String news;
        switch (type) {
            case ETNEWS:
                if (!isEnable(path)) {
                    break;
                }

                news = getNews(path);
                title = getEtNewsTitle(news);
                body = getEtNewsBody(news);
                author = getEtAuthor(news);
                date = getEtDate(news);
                email = getEtEmail(news);
                newsVO = new NewsVO(title, body, author, date, email);
                storeNews(newsVO);
                break;
            case ZDNET:
                if (!isEnable(path)) {
                    break;
                }
                news = getNews(path);
                title = getZdNewsTitle(news);
                body = getZdNewsBody(news);
                author = getZdAuthor(news);
                date = getZdDate(news);
                email = getZdEmail(news);
                newsVO = new NewsVO(title, body, author, date, email);
                storeNews(newsVO);
                break;
            case NEWS_COM1:
                // .... code
                break;
            case NEWS_COM2:
                // .... code
                break;
            case NEWS_COM3:
                // .... code
                break;
            default:
                break;
        }
    }

    private String getZdEmail(String news) {
        return null;
    }

    private String getZdDate(String news) {
        return null;
    }

    private String getZdAuthor(String news) {
        return null;
    }

    private String getZdNewsBody(String news) {
        return null;
    }

    private String getZdNewsTitle(String news) {
        return null;
    }

    private void storeNews(NewsVO newsVO) {

    }

    private String getEtEmail(String news) {
        return null;
    }

    private String getEtDate(String news) {
        return null;
    }

    private String getEtAuthor(String news) {
        return null;
    }

    private String getEtNewsBody(String news) {
        return null;
    }

    private String getEtNewsTitle(String news) {
        return null;
    }

    private String getNews(String path) {
        return null;
    }

    private boolean isEnable(String path) {
        return true;
    }

    class NewsVO {

        public NewsVO(String title, String body, String author, String date, String email) {

        }
    }
}
