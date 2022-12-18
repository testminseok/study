package examples.chap16;

import static examples.chap16.Util.delay;

public class ExchangeService {

    public static double getRate(Money source, Money destination) {
        return getRateWithDelay(source, destination);
    }

    private static double getRateWithDelay(Money source, Money destination) {
        delay();
        return source.getRate() / destination.getRate();
    }
}
