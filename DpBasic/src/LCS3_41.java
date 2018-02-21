import java.util.*;
class LCS3_41 {
	static HashMap<String, Integer> map;
	public static  int lcs3(String a,String b,String c) {
		if(a.length()<=0||b.length()<=0||c.length()<=0)
			return 0;
		String key=a+":"+b+":"+c;
		if(map.containsKey(key))
			return map.get(key);
		int val;
		if(a.charAt(0)==b.charAt(0)&&b.charAt(0)==c.charAt(0))
			val=1+lcs3(a.substring(1),b.substring(1),c.substring(1));
		else
			val=Math.max(lcs3(a.substring(1),b,c)
				,Math.max(lcs3(a,b.substring(1),c),
						lcs3(a,b,c.substring(1))
						));
		map.put(key, val);
		return val;
	}
	
	
	public static void main (String[] args){
	 //code
	 Scanner scan=new Scanner(System.in);
	 int t=scan.nextInt();
	 for(int l=0;l<t;l++){
		 scan.nextInt();
		 scan.nextInt();
		 scan.nextInt();
		 map=new HashMap<>();
		 System.out.println(lcs3(scan.next(),scan.next(),scan.next()));
	 
	 }
	 
	 
	 }//cls main
}