package ArraysAndStrings;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;




public class Ques1_3 {

	String sort(String x){
		char[] strArray = x.toCharArray();
		java.util.Arrays.sort(strArray);
		
		return new String(strArray);
	}
	
	String checkPermutationBySorting(String s, String t){
		if( s.length() != t.length())
			return "NO";
		
		if( sort(s).equals(sort(t))){
			return "YES";
		}
		return "NO";
	}

	String checkPermutationByCompare(String s, String t){
		if( s.length() != t.length() ){
			return "NO";
		}
		int[] asciiAry = new int[256];
		char[] charAry = s.toCharArray();
		for( char c : charAry){
			asciiAry[c]++;
		}
		
		charAry = t.toCharArray();
		for( char c : charAry){
			if( --asciiAry[c] < 0 ){
				return "NO";
			}
		}
		return "YES";
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Enter two string in separate lines");
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		String s = br.readLine();
		String t = br.readLine();
		System.out.println("Enter 1 to find permutation by sorting method");
		System.out.println("Enter 2 to find permutation by comparing method");
		int opt = Integer.parseInt(br.readLine());
		String rslt = "";
		Ques1_3 q = new Ques1_3();
		switch(opt){
			case 1:
				rslt = q.checkPermutationBySorting(s,t);
				break;
			case 2:
				rslt = q.checkPermutationByCompare(s,t);
				break;
		}
		System.out.println(rslt);
	}
	
}
