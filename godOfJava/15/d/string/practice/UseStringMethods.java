package d.string.practice;

public class UseStringMethods {
	
	public static void main(String[] args) {
		
		UseStringMethods sample = new UseStringMethods();
		String str = "The String class represents character strings.";
		
		sample.printWords(str);
		System.out.println("------------------");
		sample.findString(str, "string");
		System.out.println("------------------");
		sample.findAnyCaseString(str, "string");
		System.out.println("------------------");
		sample.countChar(str, 's');
		System.out.println("------------------");
		sample.printContainWords(str, "ss");
	}
	
	public void printWords(String str) {
		
		String[] values = str.split(" ");
		
		for (String value : values) {
			System.out.println(value);
		}
		
	}
	
	public void findString(String str, String findStr) {
		System.out.println("string is appeared at " + str.indexOf(findStr));
	}
	
	public void findAnyCaseString(String str, String findStr) {
		System.out.println("string is appeared at " + str.toLowerCase().indexOf(findStr));
	}
	
	public void countChar(String str, char c) {
		
		int charCount = 0;
		char[] charArray = str.toCharArray();
		
		for (char ch : charArray) {
			if (ch == c) charCount++;
		}
		
		System.out.println("char '" + c + "' count is " + charCount);
	}
	
	public void printContainWords(String str, String findStr) {
		
		String[] strArray = str.split(" ");
		
		for (String string : strArray) {
			if (string.contains(findStr)) System.out.println(string + " contains " + findStr);
		}
	}
}