package code;

public class Homework1Practice {
	
	
	public  int count_e(String s){
		String mine = s;
		int count = 0;
		for (int i = 0; i < mine.length(); i++){
			char c = mine.charAt(i);
			if (c == 'e'){
				count++;
			}
		}
		return count;
	}
	
	public int count_f(String s){
		String yours = s;
		int count = 0;
		for (int i = 0; i < yours.length(); i++){
			char d = yours.charAt(i);
			if (d == 'f'){
				count++;
			}
		}
		
		return count;
	}
	
	public int count_one_char(String s, char c){
		String theirs = s;
		int count = 0;
		for (int i = 0; i < theirs.length(); i++){
			char d = theirs.charAt(i);
			if (d == c){
				count++;
			}
		}
		
		return count;
		
	}
	
	public int count_two_chars(String s, char c, char d){
		String ours = s;
		int count1 = 0;
		int count2 = 0;
		for (int i = 0; i < ours.length(); i++){
			char e = ours.charAt(i);
			char f = ours.charAt(i);
			if (e == c){
				count1++;
			}
			if (f == d){
				count2++;
			}
		}
		int sum = count1 + count2;
		return sum;
		
	}
	
	public int count_chars_in_String(String s, String t){
		String almost = s;
		String done = t;
		int count = 0;
		for (int i = 0; i < almost.length(); i++){
			char c = almost.charAt(i);
			for (int h = 0; h < done.length(); h++){
				char d = done.charAt(h);
				if (c == d){
					count++;
				}
			}
			
		}
		return count;
		
	}
	
}
