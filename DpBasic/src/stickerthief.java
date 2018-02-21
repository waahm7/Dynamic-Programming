import java.util.Arrays;
import java.util.Scanner;

public class stickerthief {

	public static long cutRod(int[] arr) {
		long sum=0;
		boolean dp[]=new boolean[arr.length];
		sum+=arr[0];
		dp[0]=true;
	
		for (int i = 1; i < dp.length; i++) {
			//select this element or don't select
			if(dp[i-1]==false) {
				dp[i]=true;
				sum+=arr[i];
				
			}else if(arr[i-1]<arr[i]) {
				dp[i-1]=false;
				dp[i]=true;
				sum=sum+arr[i]-arr[i-1];
				if(i-3>=0&&dp[i-3]==false&&dp[i-2]==false)
					sum+=arr[i-2];
			}
			else {
				dp[i]=false;
			}
		}
		
		if(dp.length>1&&dp[0]==false&&dp[1]==false)
			sum+=arr[0];
		return sum;
	}	
	public static long cutRecur(int[] arr) {
		int max=1;
		int[] lis=new int[arr.length];
		lis[0]=arr[0];
		for (int i = 1; i < lis.length; i++) {
			lis[i]=arr[i];
			for (int j = 0; j < i; j++) {
				if(arr[i]>arr[j]) {
					lis[i]=Math.max(lis[i],arr[i]+lis[j]);
					
				}
			}
		}
		
		int[] dis=new int[arr.length];
		dis[0]=arr[0];
		for (int i = 1; i < dis.length; i++) {
			dis[i]=arr[i];
			for (int j = 0; j < i; j++) {
				if(arr[i]<arr[j]) {
					dis[i]=Math.max(dis[i],arr[i]+dis[j]);
					
				}
			}
		}
		
		
		
		
		
		
		
		return dis[arr.length-1];
	}

	
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		///	int a[] = {1, 3, 6, 3, 2, 3, 6, 8, 9, 5};

		Scanner scan=new Scanner(System.in);
		int t=scan.nextInt();
		for (int l = 0; l < t; l++) {
			int n=scan.nextInt();
			int[] a=new int[n];
			for (int i = 0; i <n; i++) {
				a[i]=scan.nextInt();
			}
			System.out.println(cutRecur(a)
			);
			
		}
		
		
	}
	

}
