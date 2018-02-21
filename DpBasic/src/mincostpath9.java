//https://www.geeksforgeeks.org/dynamic-programming-set-6-min-cost-path/
public class mincostpath9 {

	public static int minCost(int[][] arr,int i,int j) {
		if(i==0&&j==0) {
			return arr[0][0];
		}
		if(i<0||j<0)
			return Integer.MAX_VALUE;
		
		int min1=Integer.MAX_VALUE,min2=Integer.MAX_VALUE,min3=Integer.MAX_VALUE;
		if(i-1>=0)
			min1=minCost(arr,i-1, j);
		if(j-1>=0)
			min2=minCost(arr,i, j-1);
		if(i-1>=0&&j-1>=0)
			min3=minCost(arr,i-1, j-1);
		
		
		return arr[i][j]+Math.min(min1,Math.min(min2,min3));
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[][]={ {1, 2, 3},
                {4, 8, 2},
                {1, 5, 3} };; 
		
                System.out.println(minCost(a,2,2));
	}
	

}
