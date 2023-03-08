package com.software.basic.problem.sync;

/**
 * 8-2 너무 많은 기능을 한 클래스에 넣지 않는다.
 * - ExcessiveClassLength : 클래스 파일의 길이가 1000줄 이상일 경우 수정을 권고한다.
 *                          (과도한 클래스 파일의 길이는 일반적으로 클래스가 과도한 책임을 가지고 있을 가능성이 높으며,
 *                           코드를 분리하면 더 관리가 쉬워지며 재사용성이 높아진다.)
 * - ToManyMethods : 메소드가 10개 이상일 경우 수정을 권고한다.
 *                   (메소드가 너무 많은 클래스는 클래스의 복잡성을 줄이고 더 세분화되게 해야 하는 대상일 수 있다.)
 * */
public class SyncDAO {
    private String sqlSessionFactory = "SqlSessionFactory";

    public void autoProcedure() {}
    public void deleteDupeEquals() {}
    public void deleteOriginalData() {}
    public void deleteTrf11() {}
    public void deleteUfidListTref11Minus() {}
    public void getBackupCountCheck() {}
    public void getCntCompareTref11() {}
    public void getJobCountCheck() {}
    public void getJobStartCheck() {}
    public void getJobStartCheck1() {}
    public void getJobStartCheck2() {}
    public void getObjectidDupe() {}
    public void getObjectidDupeEquals() {}
    public void getResultCompareTref11() {}
    public void getSigCd() {}
    public void getUfidDupe() {}
    public void getUfidDupeTref11() {}
    public void getUfidDupeList() {}
    public void getUfidDupeListMinusTref11() {}
    public void getUfidDupeListMod() {}
    public void getUfidDupeTref11Minus() {}
    public void insertBackup() {}
    public void insertError() {}
    public void insertTref11() {}
    public void insertUfidListMinusTref11() {}
    public void updateNewUifd() {}
    public void updatePnu() {}
    public void updateTref11() {}
    public void updateTref11RelGrpId() {}
    public void updateUfidListTref11() {}

}
