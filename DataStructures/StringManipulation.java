package DataStructures;

public class StringManipulation {

	protected static int factorial(int i) {
		if(i == 0) return 1;
		return i * factorial(i-1);
	}
	
	public static void printPermutations(char[] array) {
		int total = factorial(array.length-1);
		int i = 0;
		while( i <= array.length-1) {
			char t = array[i];
			array[i] = array[0];
			array[0] = t;
			//System.out.println(new String(array));
			permute(array,total);
			i++;
		}
	}
	
	public static void permute(char[] array, int total) {
		int i = 1;
		int count = 0;
		char temp;
		while (count < total) {
			if(i == array.length-1) i=1;
			temp = array[i];
			array[i] = array[i+1];
			array[i+1] = temp;
			System.out.println(new String(array));
			i++;
			count++;
		}
	}
}
