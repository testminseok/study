public class ReferenceStaticVariable {
	static String name;
	
	public ReferenceStaticVariable() {}
	
	public ReferenceStaticVariable(String name) {
		this.name = name;
	}
	
	public static void main(String[] agrs) {
		/*
			checkName을 통해서 reference1을 두번 출력한 결과는 아래와같다
			Sangmin
			Sungchoon
			
			예상했던 아래의 결과와는 다르다.
			Sangmin
			Sangmin
			
			왜 reference1을 두번 호출했는데 다른값이 출력되었을까.
			그것은 객체를 생성하면서 가지는 name이 static 키워드로 선언되어있어서이다.
			reference객체를 여러개 생성해도 그 안에서의 name은 static으로 선언되어있어 여러개의 객체가 같은 주소를 바라보고 있다.
			그러므로 reference2에서 해당 값을 변경하여 다르게 보여진다. 
			
		*/
		ReferenceStaticVariable reference = new ReferenceStaticVariable();
		reference.checkName();
	}
	
	public void checkName() {
		
		ReferenceStaticVariable reference1 = new ReferenceStaticVariable("Sangmin");
		System.out.println(reference1.name);
		
		ReferenceStaticVariable reference2 = new ReferenceStaticVariable("Sungchoon");
		System.out.println(reference1.name);
	}
}