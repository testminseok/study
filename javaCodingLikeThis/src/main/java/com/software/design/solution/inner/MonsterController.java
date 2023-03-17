package com.software.design.solution.inner;

public class MonsterController {
    public static void main(String[] args) {
        MonsterFactory monsterFactory = new MonsterFactory();
        IMonster monsterA = monsterFactory.makeMonster(0);
        IMonster monsterB = monsterFactory.makeMonster(1);
        IMonster monsterC = monsterFactory.makeMonster(2);
        IMonster monsterD = monsterFactory.makeMonster(3);
    }
}
