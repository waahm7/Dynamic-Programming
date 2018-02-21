
import java.util.HashMap;
import java.util.Scanner;

//https://www.geeksforgeeks.org/dynamic-programming-set-13-cutting-a-rod/
public class breakin3Parts34 {
	static HashMap<Long, Long> map;
	
	public static long cutRod(int n) {
			if(map.containsKey(n))
				return map.get(n);
			
			if(n<2)
				return n;
			
		
		
			return 0;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		map=new HashMap<>();
		Scanner scan=new Scanner(System.in);
		 int t=scan.nextInt();
		 for(int l=0;l<t;l++){
		 
			int n=scan.nextInt();
			System.out.println(cutRod(n));
				
							 
		 }
		 
		
	}
	

}
