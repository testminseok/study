package examples.chap09;

import java.util.ArrayList;
import java.util.List;

public class ObserverMain {
    public static void main(String[] args) {
        Feed feed = new Feed();
        feed.registerObserver(new NYTimes());
        feed.registerObserver(new Guardian());
        feed.registerObserver(new LeMonde());
        feed.notifyObservers("The queen said her favourite book is Modern Java in Action!");

        // about Lambda
        Feed feedByLambda = new Feed();
        feedByLambda.registerObserver(tweet -> {
            if (tweet != null && tweet.contains("money")) {
                System.out.println("Breaking news is NY! " + tweet);
            }
        });
        feedByLambda.registerObserver(tweet -> {
            if (tweet != null && tweet.contains("queen")) {
                System.out.println("Yet more news from London... " + tweet);
            }
        });
        feedByLambda.registerObserver(tweet -> {
            if (tweet != null && tweet.contains("wine")) {
                System.out.println("Today cheese, wine and news! " + tweet);
            }
        });
        feedByLambda.notifyObservers("The queen said her favourite wine is redWine");
    }

    interface Observer {
        void notify(String tweet);
    }

    interface Subject {
        void registerObserver(Observer observer);

        void notifyObservers(String tweet);
    }

    static class NYTimes implements Observer {
        @Override
        public void notify(String tweet) {
            if (tweet != null && tweet.contains("money")) {
                System.out.println("Breaking news is NY! " + tweet);
            }
        }
    }

    static class Guardian implements Observer {
        @Override
        public void notify(String tweet) {
            if (tweet != null && tweet.contains("queen")) {
                System.out.println("Yet more news from London... " + tweet);
            }
        }
    }

    static class LeMonde implements Observer {
        @Override
        public void notify(String tweet) {
            if (tweet != null && tweet.contains("wine")) {
                System.out.println("Today cheese, wine and news! " + tweet);
            }
        }
    }

    static class Feed implements Subject {
        private final List<Observer> observers;

        Feed() {
            this(new ArrayList<>());
        }

        Feed(List<Observer> observers) {
            this.observers = observers;
        }

        @Override
        public void registerObserver(Observer observer) {
            this.observers.add(observer);
        }

        @Override
        public void notifyObservers(String tweet) {
            observers.forEach(observer -> observer.notify(tweet));
        }
    }
}
