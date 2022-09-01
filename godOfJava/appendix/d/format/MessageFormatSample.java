package d.format;

import java.text.MessageFormat;

public class MessageFormatSample {
    public static void main(String[] args) {
        MessageFormatSample sample = new MessageFormatSample();
        sample.stringSample("testMin", "Macbook Pro", "10");
        sample.messageFormatSample("testMin", "Macbook Pro", "10");
        sample.totalPriceMessage("testMin", 1200585);
    }

    private void totalPriceMessage(String customer, int price) {
        String message = "{0}님이 구매하신 총 금액은 {1, number, #,##0.00} 원입니다.";

        System.out.println(MessageFormat.format(message, customer, price));
    }

    private void messageFormatSample(String customer, String product, String days) {
        String message = "{0}님 구매해 주셔서 감사합니다. \n " +
                "구매하신 \"{1}\"는 {2}일 내에 배송 될것입니다. \n"
                + "궁금하신 사항은 abcd@efg.com 으로 문의하시기 바랍니다.";

        System.out.println(MessageFormat.format(message, customer, product, days));
    }

    private void stringSample(String customer, String product, String days) {
        String message = customer + "님 구매해 주셔서 감사합니다. \n 구매하신 \""
                + product + "\"는 "
                + days + "일 내에 배송 될것입니다. \n"
                + "궁금하신 사항은 abcd@efg.com 으로 문의하시기 바랍니다.";
        System.out.println(message);
    }
}
