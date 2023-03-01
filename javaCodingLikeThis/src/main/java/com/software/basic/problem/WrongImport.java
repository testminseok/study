package com.software.basic.problem;

import java.lang.Object;
import java.io.File;
import com.software.basic.problem.AbsKlassNaming;
/**
 * 6-2 불필요한 참조는 하지 않는다.
 *  - UnnecessaryImport : 사용하지 않는 import 문과 java.lang 을 직접 import 하는것과 중복되는경우 수정을 권고한다.
 *                        (DontImportJavaLang, DuplicateImports, UnusedImports Role 이 병합됨)
 *  - UnusedImports : 사용하지 않는 import 문이 있을경우 수정을 권고 (Deprecated : UnnecessaryImport 와 병합됨)
 *  - ImportFromSamePackage : 동일한 패키지에 있는 클래스를 참조할때 수정을 권고한다. (Deprecated : UnnecessaryImport 와 병합됨)
 * */
public class WrongImport {

}
