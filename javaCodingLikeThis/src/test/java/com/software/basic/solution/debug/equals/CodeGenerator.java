package com.software.basic.solution.debug.equals;

public class CodeGenerator {

    public String toCode(String value) {
        String[][] codeMap = new String[][]{{"CODE001", "입금"}, {"CODE002", "출금"}, {"CODE003", "조회"}};
        String code = "ERROR";
        for(String[] map : codeMap) {
            if(map[1].equals(value)) {
                code = map[0];
                break;
            }
        }
        return code;
    }
}
