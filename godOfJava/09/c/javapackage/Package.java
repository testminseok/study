/*
	- package 키워드는 소스의 가장 첫줄에 있어야한다. 주석이나 공백은 가능
	- package 키워드는 소스에 하나만 있어야한다.
	- package 이름과 위치한 폴더 이름이 같아야한다. 
	- package 이름은 java 로 시작할 수 없다.
	- package 는 소문자로 구성되어야한다.
	- package 는 자바의 예약어를 사용하면 안된다.
*/
package c.javapackage;

/*
	다른 패키지에 있는 클래스를 사용하려면 import 키워드를 이용하여 해당 파일이 있는 경로를 적어줘야한다.
	import c.javapackage.sub.Sub;;
	
	다른 패키지에 있는 클래스의 클래스 변수와 static 메서드를 사용하려면 아래처럼 두가지로 사용할 수 있다.
	- Sub.subClassStaticMethod()
	- import static c.javapackage.sub.Sub.subClassStaticMethod; 처럼 import하여 subClassStaticMethod(); 호출
		현재 파일에 동일한 static 으로 등록된 클래스변수와 static메서드의 이름이 동일할 경우 현재 파일에 있는게 우선적으로 사용된다.
		
	import를 하지 않아도 사용할 수 있는 클래스의 경우는 java.leng 패키지 또는 같은 패키지에 있는 클래스 파일.
	
*/
import static c.javapackage.sub.Sub.*;

public class Package {
	public static void main(String[] agrs) {
		System.out.println("Package class.");
		
		//Sub sub = new Sub();
		//sub.subClassMethod();
		
		subClassStaticMethod();
	}
	
	public static void subClassStaticMethod() {
		System.out.println("Package subClassStaticMethod");
	}
}