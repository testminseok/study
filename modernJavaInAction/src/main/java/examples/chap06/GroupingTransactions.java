package examples.chap06;

import java.util.*;
import java.util.stream.Collectors;

public class GroupingTransactions {
    public static List<Transaction> transactions = List.of(
            new Transaction(Currency.EUR, 1500.0),
            new Transaction(Currency.USD, 2300.0),
            new Transaction(Currency.GBP, 9900.0),
            new Transaction(Currency.EUR, 1100.0),
            new Transaction(Currency.JPY, 7800.0),
            new Transaction(Currency.CHF, 6700.0),
            new Transaction(Currency.EUR, 5600.0),
            new Transaction(Currency.USD, 4500.0),
            new Transaction(Currency.CHF, 3400.0),
            new Transaction(Currency.GBP, 3200.0),
            new Transaction(Currency.USD, 4600.0),
            new Transaction(Currency.JPY, 5700.0),
            new Transaction(Currency.EUR, 6800.0)
    );

    public static void main(String[] args) {
        // 통화별로 트랜잭션을 그룹화한 코드 ( 자바 8 이전 )
        Map<Currency, List<Transaction>> currencyListMap = new HashMap<>(); // 그룹화한 트랜잭션을 저장할 Map
        for (Transaction transaction : transactions) {
            Currency currency = transaction.currency();
            List<Transaction> transactionList = currencyListMap.get(currency);
            if (transactionList == null) { // 현재 통화를 그룹화하는 맵에 항목이 없으면 항목 생성
                transactionList = new ArrayList<>();
                currencyListMap.put(currency, transactionList);
            }
            transactionList.add(transaction); // 같은 통화를 가진 트랜잭션 리스트에 현재 탐색중인 트랜잭션 추가
        }
        System.out.println(currencyListMap);

        // 통화별로 트랜잭션을 그룹화한 코드 ( 자바 8 이후 )
        Map<Currency, List<Transaction>> collect = transactions.stream()
                .collect(Collectors.groupingBy(Transaction::currency));
        System.out.println(collect);

    }
}
