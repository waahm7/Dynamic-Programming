
public class Utility {

	public static void PrintArray(int[] array) {

		for (int i = 0; i < array.length; i++)
			System.out.print(array[i]+" ");

		System.out.println();
	}

	public static void PrintArray(int[][] array) {

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++)
				System.out.print(array[i][j]+" ");

			System.out.println();
		}
		
		
	}
	
	public static void PrintArray(long[][] array) {

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++)
				System.out.print(array[i][j]+" ");

			System.out.println();
		}
		
		
	}
	public static int factorial(int n) {
		int fact=1;
		for (int i = 2; i <= n; i++) {
			fact*=i;
		}
		return fact;
	}
	
	public static int[] intilizeArray(int[] array, int value){
		for (int i = 0; i < array.length; i++) {
			array[i]=value;
		}
		return array;
	}
	public static int[][] intilizeArray(int[][] array, int value){
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				array[i][j]=value;
						
			}
			
		}
		return array;
	}

}
