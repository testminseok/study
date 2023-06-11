package chapter02.item36;

import java.util.Set;

public class TextByEnum {
    public enum Style {
        BOLD, ITALIC, UNDERLINE, STRIKETHROUGH
    }

    public static void main(String[] args) {
        TextByEnum textByEnum = new TextByEnum();
        textByEnum.applyStyles(Set.of(Style.BOLD, Style.ITALIC));
    }

    // EnumSet - 비트 필드를 대체하는 현대적 기법
    public void applyStyles(Set<Style> styles) {
        // 어떤 Set 을 넘겨도 되나, EnumSet 이 가장 좋다.
        System.out.println(styles);
    }
}
