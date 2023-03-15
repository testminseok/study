package com.software.basic.problem.template.pattern.parser;

import com.software.basic.problem.template.pattern.vo.NewsVO;

/*
* 응집도와 복잡도 측면에서 더욱 개선됐지만 상위 클래스인 BaseParser 가 공통기능을 통합하는 역활만을 수행함으로써
* 각 구현 클래스인 EtNewsParser 와 ZdNewsParser 에서 이러한 공통 기능과 상세 기능을 구현하는 프로세스가 중복으로 존재한다.
* 일반적인 상속 구조는 정형화되지 않은 다양한 형태를 보이는 클래스의 공통 기능을 묶어서 재사용성을 높이는 용도로 매우 유용하다.
* 하지만 지금과 같이 일정한 형태와 절차를 유지하고 상세 구현 기능만 다른 정형화된 구조에서는 상위 클래스가 정형화된 절차나 기능의
* 일부분까지 전담해서 하위 클래스에서 구현할 부분을 최소한으로 작성할 수 있다. 주요 알고리즘이나 기능을 모두 상위 클래스에서
* 전담해서 관리하므로 기능과 절차를 잘못 구현하는 문제를 방지하고 차후 유지보수가 매우 수월해진다.
* */
public class BaseNewsParser {

    private NewsVO newsVO;
    private String path;
    private String news;

    public BaseNewsParser(String path) {
        this.path = path;
    }

    public boolean isEnable() {
        return true;
    }

    public String getNews() {
        return null;
    }

    public void makeNewsVO(String title, String body, String author, String date, String email) {
        this.newsVO =  new NewsVO(title, body, author, date, email);
    }

    public void storeNews() {
        System.out.println(newsVO);
    }
}
