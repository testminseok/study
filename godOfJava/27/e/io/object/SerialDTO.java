package e.io.object;

import java.io.Serializable;

public class SerialDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String bookName;
    transient private int bookOrder;
    private boolean bestSeller;
    private long soldPerDay;
    private String bookTypes = "IT";

    public SerialDTO(String bookName, int bookOrder, boolean bestSeller, long soldPerDay) {
        this.bookName = bookName;
        this.bookOrder = bookOrder;
        this.bestSeller = bestSeller;
        this.soldPerDay = soldPerDay;
    }

    @Override
    public String toString() {
        return "SerialDTO{" +
                "bookName='" + bookName + '\'' +
                ", bookOrder=" + bookOrder +
                ", bestSeller=" + bestSeller +
                ", soldPerDay=" + soldPerDay +
                ", bookTypes='" + bookTypes + '\'' +
                '}';
    }
}
