package code;

public class Homework2Practice {
	
	public int[]countAll(String s){
		String input = s;
		int[] array = new int[27];
		for (int i = 0; i < input.length(); i++){
			char c = input.charAt(i);
			c = Character.toLowerCase(c);
			if ('a' <= c && c <= 'z'){
				array[c-'a']++;
			}
			else{
				array[26]++;
			}
		}
		return array;
	}
	
	public int smallest (int[] a){
		int smallest = a[0];
		for (int i = 0; i < a.length; i++){
			if (a[i] < smallest){
				smallest = a[i];
			}
		}
		return smallest;
	}
	public int indexOfSmallest (int[] a){
		int smallest = 0;
		for (int i = 0; i < a.length; i++){
			if (a[i] < a[smallest]){
				smallest = i;
			}
		}
		return smallest;
	}

}
