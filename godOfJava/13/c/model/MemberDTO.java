package c.model;

public class MemberDTO {
	
	public String name;
	public String phone;
	public String email;
	
	public MemberDTO() {}
	
	public MemberDTO(String name) {
		this.name = name;
	}
	
	public MemberDTO(String name, String phone, String email) {
		this.name = name;
		this.phone = phone;
		this.email = email;
	}
	
	public boolean equals(Object obj) {
		
		if (this == obj)  return true; // 주소가 같으므로 true
		if (obj == null) return false; // 대상 객체가 null 이므로 false
		if (getClass() != obj.getClass()) return false; // 대상 객체가 다른 클래스이므로 false
		
		MemberDTO other = (MemberDTO) obj;
		
		if (name == null) { // 이름이 null일때
			if (other.name != null) return false; // 대상객체도 null이 아니라면 false
		} else if (!name.equals(other.name)) return false; // 두 개의 이름이 다르면 false
		
		// name 과 같은 비교수행
		if (phone == null) {
			if (other.phone != null) return false;
		} else if (!phone.equals(other.phone)) return false;
		
		// name 과 같은 비교수행
		if (email == null) {
			if (other.email != null) return false;
		} else if (!email.equals(other.email)) return false;
		
		return true;
	}
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		
		return result;
	}
	
	public String toString() {
		return "Name = " + name + ", phone = " + phone + ", email = " + email;
	}
}