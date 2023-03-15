package com.software.basic.problem.template.pattern;

import com.software.basic.problem.template.pattern.parser.EtNewsParser;
import com.software.basic.problem.template.pattern.parser.ZdNewsParser;

public class SwitchDensityTemplateMethodPattern {

    public static final int NONE = -1;
    public static final int ETNEWS = 0;
    public static final int ZDNET = 1;
    public static final int NEWS_COM1 = 2;
    public static final int NEWS_COM2 = 3;
    public static final int NEWS_COM3 = 4;

    public static void main(String[] args) {
        int type = args != null ? Integer.parseInt(args[0]) : NONE;
        String path = args != null && args.length == 2 ? args[1] : null;

        SwitchDensityTemplateMethodPattern example = new SwitchDensityTemplateMethodPattern();
        example.getNewsData(type, path);
    }

    private void getNewsData(int type, String path) {
        switch (type) {
            case ETNEWS:
                saveEtNews(path);
                break;
            case ZDNET:
                saveZdNews(path);
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

    private void saveZdNews(String path) {
        ZdNewsParser parser = new ZdNewsParser(path);
        parser.parse();
    }

    private void saveEtNews(String path) {
        EtNewsParser parser = new EtNewsParser(path);
        parser.parse();
    }

}
