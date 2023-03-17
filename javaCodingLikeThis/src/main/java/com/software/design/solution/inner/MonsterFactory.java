package com.software.design.solution.inner;

public class MonsterFactory {
    public IMonster makeMonster(int monsterType) {
        IMonster monster;
        switch (monsterType) {
            case 0:
                monster = new MonsterA();
                break;
            case 1:
                monster = new MonsterB();
                break;
            case 2:
                monster = new MonsterC();
                break;
            default:
                throw new NoClassDefFoundError("해당 몬스터는 존재하지 않습니다.");
        }

        return monster;
    }
}
