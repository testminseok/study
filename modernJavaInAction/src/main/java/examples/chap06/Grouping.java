package examples.chap06;

import examples.chap04.Dish;

import java.util.*;
import java.util.stream.Collectors;

enum CaloricLevel {
    DIET,
    NORMAL,
    FAT,
}

public class Grouping {
    public static void main(String[] args) {
        // groupingBy
        /*
        * groupingBy(Dish::getType) 에 Dish::getType 을 기준으로 그룹화 되므로 이를 분류함수라고 한다.
        * */
        Map<Dish.Type, List<Dish>> dishesByType = Dish.menu.stream()
                .collect(Collectors.groupingBy(Dish::getType));
        System.out.println(dishesByType);

        /*
        * 칼로리를 기준으로 400이하는 DIET, 700 이하는 NORMAL, 그 외엔 FAT 으로 분류
        * */
        Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = Dish.menu.stream()
                .collect(Collectors.groupingBy(dish -> {
                    if (dish.getCalories() <= 400) {
                        return CaloricLevel.DIET;
                    } else if (dish.getCalories() <= 700) {
                        return CaloricLevel.NORMAL;
                    } else {
                        return CaloricLevel.FAT;
                    }
                }));
        System.out.println(dishesByCaloricLevel);

        /*
        * 500 칼로리 이상의 음식 타입으로 그룹핑 (Collectors.filtering)
        * */
        Map<Dish.Type, List<Dish>> caloricDishesByType = Dish.menu.stream()
                .collect(
                        Collectors.groupingBy(
                                Dish::getType,
                                Collectors.filtering(
                                        dish -> dish.getCalories() > 500,
                                        Collectors.toList()
                                )
                        )
                );
        System.out.println(caloricDishesByType);

        // 그룹의 각 요리를 관련 이름 목록으로 변환
        Map<Dish.Type, List<String>> dishNamesByType = Dish.menu.stream()
                .collect(
                        Collectors.groupingBy(
                                Dish::getType,
                                Collectors.mapping(Dish::getName, Collectors.toList())
                        )
                );
        System.out.println(dishNamesByType);
        
        //flatMapping 
        Map<Dish.Type, Set<String>> dishNamesByTypeToSet = Dish.menu.stream()
                .collect(
                        Collectors.groupingBy(
                                Dish::getType,
                                Collectors.flatMapping(
                                        dish -> Dish.dishTags.get(dish.getName()).stream(),
                                        Collectors.toSet()
                                )
                        )
                );
        System.out.println(dishNamesByTypeToSet);

        // 다수준 그룹화 - 여러개의 기준으로 그룹핑
        // Type 의 따른 스트림 추출 -> 추출된 스트림을 CaloricLevel 로 그룹핑
        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTypeAndCaloricLevel = Dish.menu.stream()
                .collect(
                        Collectors.groupingBy(
                                Dish::getType, // 첫번째 수중의 분류함수 (Dish Type 으로 그룹핑)
                                Collectors.groupingBy( // 두번째 수준의 분류함수 (dish 의 calories 로 그룹핑
                                        dish -> {
                                            if (dish.getCalories() <= 400) {
                                                return CaloricLevel.DIET;
                                            } else if (dish.getCalories() <= 700) {
                                                return CaloricLevel.NORMAL;
                                            } else {
                                                return CaloricLevel.FAT;
                                            }
                                        }
                                )
                        )
                );
        System.out.println(dishesByTypeAndCaloricLevel);

        Map<Dish.Type, Long> typesCount = Dish.menu.stream()
                .collect(Collectors.groupingBy(Dish::getType, Collectors.counting()));
        System.out.println(typesCount);
        
        // 음식 종류별로 칼로리가 가장 높은 음식 구하기
        Map<Dish.Type, Optional<Dish>> mostCaloricByType = Dish.menu.stream()
                .collect(
                        Collectors.groupingBy(
                                Dish::getType,
                                Collectors.maxBy(Comparator.comparingInt(Dish::getCalories))
                        )
                );
        System.out.println(mostCaloricByType);

        // 마지막 그룹화 연산에서 맵의 모든값을 Optional 로 감쌀 필요가 없으므로 Optional 삭제
        // maxBy -> 리듀싱 컬렉터는 절대 Optional.empty 를 반환하지 않는다.
        Map<Dish.Type, Dish> mostCaloricByType2 = Dish.menu.stream()
                .collect(
                        Collectors.groupingBy(
                                Dish::getType,
                                Collectors.collectingAndThen(
                                        Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)),
                                        Optional::get
                                )
                        )
                );
        System.out.println(mostCaloricByType2);

        // 메뉴별로 모든 요리의 칼로리 합계 구하기
        Map<Dish.Type, Integer> totalCaloriesByType = Dish.menu.stream()
                .collect(Collectors.groupingBy(Dish::getType, Collectors.summingInt(Dish::getCalories)));
        System.out.println(totalCaloriesByType);

        // 각 요리 형식에 존재하는 모든 CaloricLevel 값을 추출
        Map<Dish.Type, Set<CaloricLevel>> caloricLevelsByType = Dish.menu.stream()
                .collect(Collectors.groupingBy(
                        Dish::getType,
                        Collectors.mapping(dish -> {
                            if (dish.getCalories() <= 400) {
                                return CaloricLevel.DIET;
                            } else if (dish.getCalories() <= 700) {
                                return CaloricLevel.NORMAL;
                            } else {
                                return CaloricLevel.FAT;
                            }
                        }, Collectors.toSet())
                ));
        System.out.println(caloricLevelsByType);

        // Collectors.toCollection 으로 원하는 collection 을 선택할 수 있다.
        Map<Dish.Type, Set<CaloricLevel>> caloricLevelsByTypeToHashSet = Dish.menu.stream()
                .collect(Collectors.groupingBy(
                        Dish::getType,
                        Collectors.mapping(
                                dish -> {
                                    if (dish.getCalories() <= 400) {
                                        return CaloricLevel.DIET;
                                    } else if (dish.getCalories() <= 700) {
                                        return CaloricLevel.NORMAL;
                                    } else {
                                        return CaloricLevel.FAT;
                                    }
                                }, Collectors.toCollection(HashSet::new)
                        )
                ));
        System.out.println(caloricLevelsByTypeToHashSet);
    }
}
