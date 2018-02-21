//https://www.geeksforgeeks.org/dynamic-programming-set-13-cutting-a-rod/
public class contiguousSubArray5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]={-2,-3,4,-1,-2,1,5,-3}; 
		int sum=0,max=0;
		for (int i = 0; i < a.length; i++) {
			sum+=a[i];
			if(sum<0)
				sum=0;
			if(sum>max)
				max=sum;
			
		}
		System.out.println(max);
		
		
	}
	

}
