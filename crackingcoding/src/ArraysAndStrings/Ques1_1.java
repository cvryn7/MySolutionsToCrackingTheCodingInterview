package ArraysAndStrings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ques1_1 {
	public static void main(String[] args){
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		boolean[] charCheck = new boolean[256];
		int opt = 0;
		String str = "";
		String rslt = "YES";

		System.out.println(" Enter 1 for all 256 ascii string");
		System.out.println(" Enter 2 for only lower case letters");
		try {
			opt = Integer.parseInt(br.readLine());
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Please Enter your string");

		try {
			str = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		switch( opt ){
		case 1:
			if( str.length() > 256){
				rslt = "NO";
			}else{
				for( int i = 0; i < str.length(); i++){
					if( charCheck[ str.charAt(i) ] ){
						rslt = "NO";
						break;
					}else{
						charCheck[ str.charAt(i) ] = true;
					}
				}
			}
			System.out.println("answer is :" + rslt);
			break;
		case 2:
			if( str.length() > 26){
				rslt = "NO";
			}else{
				int checker = 0;
				int diff;
				for( int i = 0; i < str.length(); i++){
					diff =  str.charAt(i) - 'a';
					if( (checker & ( 1 << diff )) == 0 ){
						checker |= 1<<diff;
					}else{
						rslt = "NO";
						break;
					}
				}
			}
			System.out.println("answer is :" + rslt);
			break;
		}

	}

}
