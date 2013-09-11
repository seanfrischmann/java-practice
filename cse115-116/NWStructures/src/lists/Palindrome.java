package lists;


public class Palindrome {

	public static <E> boolean palindrome(E[] array) {
		for (int i=0; i < array.length/2; i++) {
			E f = array[i];
			E b = array[array.length-1-i];
			if (f == null || b == null) { // if either f or b is null, commit to this branch
				if (! (f == null && b == null)) {
					return false;
				}
			}
			else { // neither f nor b is null in this branch
				if (! (f.equals(b))) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		String[] a1 = {};
		String[] a2 = {"Fred"};
		String[] a3 = {"Fred","Wilma","Fred"};
		String[] a4 = {"Fred","Wilma","Wilma","Fred"};
		String[] a5 = {"Fred",null,"Fred"};
		String[] a6 = {"Fred",null,null,"Fred"};
		String[] f2 = {"Fred","Wilma"};
		String[] f3 = {"Fred","Wilma","Betty"};
		String[] f4 = {"Fred","Wilma","Wilma","Betty"};
		String[] f5 = {"Fred",null,"Betty"};
		String[] f6 = {"Fred",null,"","Fred"};
		System.out.println(
				palindrome(a1)
				+" "+
				palindrome(a2)
				+" "+
				palindrome(a3)
				+" "+
				palindrome(a4)
				+" "+
				palindrome(a5)
				+" "+
				palindrome(a6)
				+" # "+
				palindrome(f2)
				+" "+
				palindrome(f3)
				+" "+
				palindrome(f4)
				+" "+
				palindrome(f5)
				+" "+
				palindrome(f6)
				);
	}
}
