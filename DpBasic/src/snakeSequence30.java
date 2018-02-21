
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Scanner;

//https://www.geeksforgeeks.org/dynamic-programming-set-13-cutting-a-rod/
 class snakeSequence30 {

	public static long pathWithMaxCost(int[][] n, int tokkens) {
		int[][] arr = new int[n.length][n[0].length];

		// starting position
		arr[arr.length - 1][0] = n[arr.length - 1][0];

		// first column
		for (int i = arr.length - 2; i >= 0; i--) {
			arr[i][0] = arr[i + 1][0] + n[i][0];
		}

		// last row
		for (int i = 1; i < arr[0].length; i++) {
			arr[arr.length - 1][i] = arr[arr.length - 1][i - 1] + n[arr.length - 1][i];
		}

		for (int i = arr.length - 2; i >= 0; i--) {
			for (int j = 1; j < arr[0].length; j++) {
				arr[i][j] = Math.max(arr[i][j - 1], arr[i + 1][j]) + n[i][j];

			}
		}

		return arr[0][arr[0].length - 1];
	}

	public static long[][] dp;
	public static HashMap<String, Long> map;
public static long pathWithMaxCostRecur(int[][] n,int x,int y, int tokkens) {
		if(x<0||x>=n.length||y<0||y>=n[0].length)
			return 0; 
		String key=x+":"+y+":"+tokkens;
		
		if(dp[x][y]!=-1)
			return dp[x][y];
		
		long val=n[x][y]+Math.max(pathWithMaxCostRecur(n,x+1,y, tokkens),
					pathWithMaxCostRecur(n,x,y-1, tokkens)
				);
		
		if(tokkens>1&&n[x][y]>0) {
			long val2=2*n[x][y]+Math.max(pathWithMaxCostRecur(n,x+1,y, tokkens-1),
					pathWithMaxCostRecur(n,x,y-1, tokkens-1)
					);
			return dp[x][y]=Math.max(val,val2);
		}
		
		return dp[x][y]=val;
	}

public static long pathWithMaxCostHash(int[][] n,int x,int y, int tokkens) {
	if(x<0||x>=n.length||y<0||y>=n[0].length)
		return 0; 
	String key=x+":"+y+":"+tokkens;
	
	if(map.containsKey(key))
		return map.get(key);
	
	long val=n[x][y]+Math.max(pathWithMaxCostRecur(n,x+1,y, tokkens),
				pathWithMaxCostRecur(n,x,y-1, tokkens)
			);
	
	if(tokkens>2&&n[x][y]>0) {
		long val2=2*n[x][y]+Math.max(pathWithMaxCostRecur(n,x+1,y, tokkens-1),
				pathWithMaxCostRecur(n,x,y-1, tokkens-1)
				);
		val2=Math.max(val,val2);
		map.put(key,val2);
		return val2;
	}
	
	map.put(key,val);
	return val;

}


	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File f=new File("input.txt");
		Scanner scan = null;
		try {
			scan = new Scanner(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 int t=scan.nextInt();
		 int[][] arr;
		 for (int l = 0; l < t; l++) {
			int r=scan.nextInt();
			int c=scan.nextInt();
			int tkn=scan.nextInt();
			dp=new long[r][c];
			arr=new int[r][c];
			map=new HashMap<>();
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					arr[i][j]=scan.nextInt();
					dp[i][j]=-1;
				}
			}
			pathWithMaxCostHash(arr,0,arr[0].length-1, tkn);
		//	Utility.PrintArray(dp);
			String key=0+":"+(c-1)+":"+tkn;
			System.out.println(map.get(key));
			
		 }
	}

}
