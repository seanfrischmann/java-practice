package stack;

public class EmptyStackException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public EmptyStackException(String msg) {
		super(msg);
	}
}
