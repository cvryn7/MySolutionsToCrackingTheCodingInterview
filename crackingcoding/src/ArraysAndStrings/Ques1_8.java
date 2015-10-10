package ArraysAndStrings;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ques1_8 {

	boolean checkRotation(String s1, String s2){
		if( (s1.length() == s2.length()) && s1.length() > 0){
			String s1s1 = s1 + s1;
			return isSubstring(s1s1,s2);
		}
		return false;
	}
	
	boolean isSubstring( String s, String t){
		return s.contains(t);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter String S1 and S2 in separate lines");
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in));
		String s1 = "";
		String s2 = "";
		
		try {
			s1 = br.readLine();
			s2 = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Ques1_8 q8 = new Ques1_8();
		System.out.println("Is S2 rotation of S1?... " + q8.checkRotation(s1,s2));
		
	}

}
