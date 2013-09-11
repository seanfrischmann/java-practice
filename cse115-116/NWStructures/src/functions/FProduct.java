package functions;

public class FProduct implements UnaryFunction<Integer,Integer> {
	private UnaryFunction<Integer,Integer> f;
	private UnaryFunction<Integer,Integer> g;
	public FProduct(UnaryFunction<Integer,Integer> f, UnaryFunction<Integer,Integer> g) { this.f=f; this.g=g; }
	@Override public Integer apply(Integer arg) { return f.apply(arg) * g.apply(arg); }
}
