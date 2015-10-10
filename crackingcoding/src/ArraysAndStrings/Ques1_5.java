package ArraysAndStrings;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ques1_5 {

	
	String stringCompress(String str){
		int compSize = compressSize(str);
		if( compSize >= str.length()){
			return str;
		}
		
		char[] strAry = new char[compSize];
		
		int count = 1;
		char c = str.charAt(0);
		int aryIdx = 0;
		for( int i = 1; i < str.length(); i++){
			if( c == str.charAt(i)){
				count++;
			}else{
				aryIdx = setChar(strAry,c,aryIdx,count);
				c = str.charAt(i);
				count = 1;
			}
		}
		
		aryIdx = setChar(strAry,c,aryIdx,count);
		return new String(strAry);
	}
	
	int compressSize(String str){
		int count = 1;
		int size = 0;
		char c;
		c = str.charAt(0);
		for( int i = 0; i < str.length(); i++){
			if( c == str.charAt(i)){
				count++;
			}else{
				size += 1 + String.valueOf(count).length();
				c = str.charAt(i);
				count = 1;
			}
		}
		size += 1 + String.valueOf(count).length();
		return size;
	}
	
	int setChar( char[] strAry, char c, int idx, int count){
		strAry[idx++] = c;
		for( char ch : String.valueOf(count).toCharArray()){
			strAry[idx++] = ch;
		}
		return idx;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the string for compression");
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in));
		String str = "";
		String compStr;
		try {
			str = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Ques1_5 q5 = new Ques1_5();
		compStr = q5.stringCompress(str);
		System.out.println(compStr);
	}

}
