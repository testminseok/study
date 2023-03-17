package com.software.design.problem.inner;

import com.software.design.problem.inner.MonsterFactory.IMonster;

/**
 * 몬스터 생성을 요청하는 클래스
 */
public class MonsterController {
    public static void main(String[] args) {
        MonsterFactory monsterFactory = new MonsterFactory();
        IMonster monsterA = monsterFactory.makeMonster(0);
        IMonster monsterB = monsterFactory.makeMonster(1);
        IMonster monsterC = monsterFactory.makeMonster(2);
        IMonster monsterD = monsterFactory.makeMonster(3);
    }
}
