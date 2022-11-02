package examples.chap05;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Practice {
    public static void main(String[] args) {
        List<Transaction> transactions = List.of(
                new Transaction(new Trader("Brian", "Cambridge"), 2011, 300),
                new Transaction(new Trader("Raoul", "Cambridge"), 2012, 1000),
                new Transaction(new Trader("Raoul", "Cambridge"), 2011, 400),
                new Transaction(new Trader("Mario", "Milan"), 2012, 710),
                new Transaction(new Trader("Mario", "Milan"), 2012, 700),
                new Transaction(new Trader("Alan", "Cambridge"), 2012, 950)
        );

        // 1. 2011년에 일어난 모든 트랜잭션을 찾아 값을 오름차순으로 정렬하시오.
        List<Transaction> transactionBy2011 = transactions.stream()
                .filter(transaction -> transaction.year() == 2011)
                .sorted(Comparator.comparing(Transaction::value))
                .collect(Collectors.toList());
        System.out.println(transactionBy2011);

        // 2. 거래자가 근무하는 모든 도시를 중복 없이 나열하시오.
        List<String> distinctCity = transactions.stream()
                .map(Transaction::trader)
                .map(Trader::getCity)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(distinctCity);

        // 3. 케임브리지에서 근무하는 모든 거래자를 찾아서 이름순으로 정렬하시오.
        List<String> orderedNames = transactions.stream()
                .map(Transaction::trader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .map(Trader::getName)
                .sorted(String::compareTo)
                .collect(Collectors.toList());
        System.out.println(orderedNames);

        // 3. 정답
        List<Trader> orderedNamesTrader = transactions.stream()
                .map(Transaction::trader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
        System.out.println(orderedNamesTrader);

        // 4. 모든 거래자의 이름을 알파벳순으로 정렬해서 반환하시오
        List<String> findAllByOrderedNames = transactions.stream()
                .map(Transaction::trader)
                .map(Trader::getName)
                .sorted(String::compareTo)
                .collect(Collectors.toList());
        System.out.println(findAllByOrderedNames);

        // 4. 정답
        String str = transactions.stream()
                .map(transaction -> transaction.trader().getName())
                .sorted()
                .reduce("", (s, s2) -> s + s2);
        System.out.println(str);

        // 5. 밀라노에 거래자가 있는가?
        boolean containsMilanTrader = transactions.stream()
                .map(Transaction::trader)
                .anyMatch(trader -> trader.getCity().equals("Milan"));
        System.out.println(containsMilanTrader);

        // 6. 케임브리지에 거주하는 거래자의 모든 트랜잭션값을 출력하시오
        transactions.stream()
                .filter(transaction -> transaction.trader().getCity().equals("Cambridge"))
                .forEach(transaction -> System.out.println(transaction.value()));

        // 6. 정답
        transactions.stream()
                .filter(transaction -> "Cambridge".equals(transaction.trader().getCity()))
                .map(Transaction::value)
                .forEach(System.out::println);

        // 7. 전체 트랜잭션 중 최대값은 얼마인가
        int maxValue = transactions.stream()
                .map(Transaction::value)
                .reduce(0, Integer::max);
        System.out.println(maxValue);

        // 8. 전체 트랜잭션 중 최소값은 얼마인가
        int minValue = transactions.stream()
                .map(Transaction::value)
                .reduce(Integer.MAX_VALUE, Integer::min);
        System.out.println(minValue);
    }
}
