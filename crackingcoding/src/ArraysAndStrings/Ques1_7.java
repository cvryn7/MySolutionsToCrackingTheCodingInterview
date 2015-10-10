package ArraysAndStrings;
import java.util.BitSet;
import java.util.Scanner;

public class Ques1_7 {

	void replace(int[][] mat, int n, int m){
		BitSet row = new BitSet(n);
		BitSet col = new BitSet(m);
		
		for( int i = 0 ; i < n ; i++){
			for( int j = 0; j < m; j++){
				if( mat[i][j] == 0){
					row.set(i);
					col.set(j);
				}
			}
		}
		
		for( int i = 0; i < n; i++){
			for( int j = 0; j < m ; j++){
				if( row.get(i) || col.get(j)){
					mat[i][j] = 0;
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter size of row and colum of matrix NXM");
		int n;
		int m;
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		System.out.println("Enter the matrix");
		
		int[][] mat = new int[n][m];
		
		for( int i = 0; i < n; i++){
			for( int j = 0; j < m ; j++){
				mat[i][j] = sc.nextInt();
			}
		}
		
		Ques1_7 q7 = new Ques1_7();
		q7.replace(mat,n,m);
		
		for( int i = 0; i < n; i++){
			for( int j = 0 ; j < m; j++){
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
		
		
	}

}
