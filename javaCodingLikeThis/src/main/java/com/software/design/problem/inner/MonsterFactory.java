package com.software.design.problem.inner;

/**
 * 몬스터를 생성하는 내부 클래스의 구조
 * */
public class MonsterFactory {
    public IMonster makeMonster(int monsterType) throws NoClassDefFoundError {
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

    public interface IMonster {
        void forword();
        void backword();
        void turnLeft();
        void turnRight();
        void attact();
        void defence();
    }

    public class MonsterA implements IMonster {
        private int type = 0;
        private String name = "슬라임";

        @Override
        public void forword() {

        }

        @Override
        public void backword() {

        }

        @Override
        public void turnLeft() {

        }

        @Override
        public void turnRight() {

        }

        @Override
        public void attact() {

        }

        @Override
        public void defence() {

        }
    }

    public class MonsterB implements IMonster {
        private int type = 1;
        private String name = "오크";

        @Override
        public void forword() {

        }

        @Override
        public void backword() {

        }

        @Override
        public void turnLeft() {

        }

        @Override
        public void turnRight() {

        }

        @Override
        public void attact() {

        }

        @Override
        public void defence() {

        }
    }

    public class MonsterC implements IMonster {
        private int type = 2;
        private String name = "보스";

        @Override
        public void forword() {

        }

        @Override
        public void backword() {

        }

        @Override
        public void turnLeft() {

        }

        @Override
        public void turnRight() {

        }

        @Override
        public void attact() {

        }

        @Override
        public void defence() {

        }
    }
}
