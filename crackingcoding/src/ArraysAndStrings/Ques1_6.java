package ArraysAndStrings;
import java.util.Scanner;

public class Ques1_6 {

	void rotate( int[][] mat, int n){
		int temp;
		int first;
		int last;
		int offset;
		for( int layer = 0; layer < n/2; layer++){
			first = layer;
			last = n-1-layer;
			
			for( int i = first; i < last; i++){
				offset = i - first;
				temp = mat[first][i];
				mat[first][i] = mat[last-offset][first];
				mat[last-offset][first] = mat[last][last-offset];
				mat[last][last-offset] = mat[i][last];
				mat[i][last] = temp;
			}
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of NXN matrix");
		int n = sc.nextInt();
		System.out.println("Enter the matrix is matrix format with space between numbers and each row on new line");
		int[][] mat = new int[n][n];
		
		for( int i = 0; i < n; i++){
			for( int j = 0; j < n ; j++){
				mat[i][j] = sc.nextInt();
			}
		}
		
		Ques1_6 q6 = new Ques1_6();
		q6.rotate( mat, n);
		
		for( int i = 0; i < n; i++){
			for( int j = 0; j < n ; j++){
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
		
	}

}
