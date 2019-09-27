package test;

public class test {

	public static void main(String[] args) {
		
		String s1 ="s";
		String s2 ="s";
		System.out.println(s1.length());
		System.out.println(s1==s2);
		System.out.println(s1.equals(s2));
		
		StringBuffer b1=new StringBuffer("s");
		StringBuffer b2=new StringBuffer("s");
		System.out.println(b1);
		System.out.println(b1.length());
		System.out.println(b1==b2);
		System.out.println(b1.equals(b2));
	}
	
}
