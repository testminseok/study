package com.software.basic.problem;

import java.awt.*;
import java.util.*;
import java.io.File;            // not used, can be removed
import java.util.Collections;   // used below
import java.util.*;             // so this one is not used

import java.lang.Object;        // imports from java.lang, unnecessary
import java.lang.Object;        // duplicate, unnecessary
import java.util.List;

/**
 * 6-1 중복된 참조는 가독성이 떨어진다.
 * - UnnecessaryImport : 사용하지 않는 import 문과 java.lang 을 직접 import 하는것과 중복되는경우 수정을 권고한다.
 *                       (DontImportJavaLang, DuplicateImports Role 이 병합됨)
 */
public class DuplicatedPackageExample {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        Panel panel = new Panel();
        List<String> a = new ArrayList<>();
    }
}
