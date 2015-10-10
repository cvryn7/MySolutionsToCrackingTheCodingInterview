package ArraysAndStrings;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ques1_4 {

	String replaceSpaces(char[] str, int len){
		int numOfSpaces = 0;
		
		for( int i= 0; i < len ; i++){
			if( str[i] == ' '){
				numOfSpaces++;
			}
		}
		
		int newLength = len + numOfSpaces*2;
		
		str[newLength] = '\0';
		for( int i = len-1 ; i >= 0 ; i--){
			if( str[i] == ' '){
				str[newLength-1] = '0';
				str[newLength-2] = '2';
				str[newLength-3] = '%';
				newLength -= 3;
			}else{
				str[newLength-1] = str[i];
				newLength -= 1;
			}
		}
		
		return new String(str);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Please enter string with spaces");
		
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in));
		String str = "";
		char[] chrStr = new char[100];
		try {
			str = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for( int i = 0; i < str.length(); i++){
			chrStr[i] = str.charAt(i);
		}
		Ques1_4 q4 = new Ques1_4();
		str = q4.replaceSpaces( chrStr, str.length());
		System.out.println(str);
	}

}
