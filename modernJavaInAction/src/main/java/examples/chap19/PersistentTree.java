package examples.chap19;

import static examples.chap19.TreeProcessor.*;

public class PersistentTree {
    public static void main(String[] args) {
        Tree tree = new Tree("Mary", 22,
                new Tree("Emily", 20,
                        new Tree("Alan", 50, null, null),
                        new Tree("Georgie", 23, null, null)),
                new Tree("Tian", 29,
                        new Tree("Raoul", 23, null, null),
                        null)
        );

        System.out.printf("Raoul: %d%n", lookup("Raoul", -1, tree));
        System.out.printf("Jeff: %d%n", lookup("Jeff", -1, tree));

        Tree functionalUpdateTree = functionalUdate("Jeff", 80, tree);
        System.out.printf("Jeff: %d%n", lookup("Jeff", -1, functionalUpdateTree)); // 발견 80

        Tree updateTree = update2("Jim", 40, tree);
        System.out.printf("Jim: %d%n", lookup("Jim", -1, updateTree));
        /*
        * functionalUpdate 로 tree 의 원본 데이터가 수정되지 않았기 때문에 -1 을 반환
        * */
        System.out.printf("Jeff: %d%n", lookup("Jeff", -1, updateTree));
    }
}
