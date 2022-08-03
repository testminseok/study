public class ProfilePrint {
	byte age;
	String name;
	boolean isMarried;
	
	public static void main(String[] agrs) {
		ProfilePrint profile = new ProfilePrint();
		
		profile.setAge((byte)20);
		profile.setName("홍길동");
		profile.setMarried(false);
		
		System.out.println(profile.getAge());
		System.out.println(profile.getName());
		System.out.println(profile.getMarried());
	}
	
	public void setAge(byte age) {
		this.age = age;
	}
	
	public byte getAge() {
		return this.age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setMarried(boolean isMarried) {
		this.isMarried = isMarried;
	}
	
	public boolean getMarried() {
		return this.isMarried;
	}
	
}